/**
 * Teknei 2016
 */
package com.teknei.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teknei.dto.ReplyStatusDTO;
import com.teknei.dto.ResponseDTO;
import com.teknei.service.FileStatusService;
import com.teknei.service.ReplyServiceImpl;
import com.teknei.service.ReplyServiceInvoker;
import com.teknei.util.ReplyOptions;
import com.teknei.util.ReplySpeedOption;
import com.teknei.util.ReplyStatus;
import com.teknei.util.UtilConstants;

/**
 * Controller for reply BUS components
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api/bus")
@Profile("bus")
public class ReplyBusController {

	/*
	 * Injected elements
	 */
	@Autowired
	private ReplyServiceInvoker serviceInvoker;
	@Autowired
	private FileStatusService serviceStatus;
	@Value("${tkn.api.fail-fast}")
	private boolean failFast;
	@Value("${tkn.api.hierarchy}")
	private boolean hierarchy;
	@Value("${tkn.reply.number}")
	private Integer noTranReply;
	private ReplySpeedOption replySpeedOption;

	private static final Logger log = LoggerFactory.getLogger(ReplyBusController.class);

	/**
	 * Post-construct for delete file on startup
	 */
	@PostConstruct
	private void postConstruct() {
		serviceStatus.deleteStatusFile();
		checkNoTranReply();
	}

	/**
	 * Check reply speed
	 */
	private void checkNoTranReply() {
		replySpeedOption = ReplySpeedOption.REPLY_SPEED_VIA;
		if (noTranReply <= 50) {
			replySpeedOption = ReplySpeedOption.REPLY_SPEED_VIA;
		} else if (noTranReply > 50 && noTranReply <= 500) {
			replySpeedOption = ReplySpeedOption.REPLY_SPEED_VIA_FAST;
		} else if (noTranReply > 500 && noTranReply <= 1000) {
			replySpeedOption = ReplySpeedOption.REPLY_SPEED_CDE;
		} else if (noTranReply > 1000) {
			replySpeedOption = ReplySpeedOption.REPLY_SPEED_CDE_FAST;
		}
		log.info("Reply speed: {}", replySpeedOption);
	}

	/**
	 * Entry point for reply bus processes
	 */
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ResponseEntity<ResponseDTO> reply() {
		ResponseDTO dto = null;
		if (!ReplyStatus.getInstance().isFree()) {
			dto = new ResponseDTO(UtilConstants.STATUS_API_USAGE_EXCEPTION, UtilConstants.MESSAGE_API_USAGE_EXCEPTION);
			return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
		}
		replyData();
		if (ReplyStatus.getInstance().isLastStatusWasError()) {
			dto = new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION,
					UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
		} else {
			dto = new ResponseDTO(UtilConstants.STATUS_OK, UtilConstants.MESSAGE_OK);
		}
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	/**
	 * Business method for replication of remaining records
	 * 
	 * <pre>
	 * Enables async processes
	 * </pre>
	 */
	@Async
	private void replyData() {
		ReplyStatus.getInstance().setFree(false);
		log.info("Reply time init: {}", System.currentTimeMillis());
		replyBusData();
		callReplyStatus(ReplyOptions.STATUS_FINISHED, 0);
		log.info("Reply time end: {}", System.currentTimeMillis());
		ReplyStatus.getInstance().setFree(true);
	}

	/**
	 * Invoker method for specific service in order to reply data to remote api
	 * 
	 * @param service
	 *            - the service to invoke
	 * @param option
	 *            - the api option
	 */
	@SuppressWarnings("rawtypes")
	private void replyBusDataForService(ReplyServiceImpl service, ReplyOptions option) {
		long counterRemaining = service.countMoreData();
		if (!(counterRemaining > 0)) {
			log.info("No data remaining for option: {}", option);
			return;
		}
		log.info("Data remaining : {} for option: {}", counterRemaining, option);
		callReplyStatus(option, counterRemaining);
		if (option.equals(ReplyOptions.SFMO_HIST)) {
			replyBusSfmo(service, option);
			return;
		}
		ResponseDTO d = service.replyData(replySpeedOption);
		if (!d.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Error {} replicating data: {}", d.getStatusCode(), option);
			if (canContinue()) {
				replyBusDataForService(service, option);
			} else {
				log.error("Maximum error counter reached, aborting");
				setLastStatusError();
				return;
			}
		}
		replyBusDataForService(service, option);

	}

	private boolean canContinue() {
		ReplyStatus.getInstance().addError();
		if (ReplyStatus.getInstance().getErrorCounter() >= 5) {
			return false;
		}
		return true;
	}

	private void setLastStatusError() {
		ReplyStatus.getInstance().setLastStatusWasError(true);
		ReplyStatus.getInstance().setFree(true);
	}

	private void callReplyStatus(ReplyOptions optionActive, long counter) {
		ReplyStatusDTO status = new ReplyStatusDTO();
		status.setRemaining(counter);
		status.setReplyOption(optionActive);
		serviceStatus.writeStatusFile(status);
	}

	@SuppressWarnings("rawtypes")
	private void replyBusSfmo(ReplyServiceImpl service, ReplyOptions option) {
		ResponseDTO d = service.replyBlockData();
		if (!d.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Error replicating data: {}", option);
			if (canContinue()) {
				replyBusSfmo(service, option);
			} else {
				log.error("Maximum error counter reached, aborting");
				setLastStatusError();
				return;
			}
		}
		long counterRemaining = service.countMoreData();
		if (counterRemaining > 0) {
			log.info("Data remaining : {} for option: {}", counterRemaining, option);
			callReplyStatus(option, counterRemaining);
			replyBusSfmo(service, option);
		}
	}

	/**
	 * Reply data in 'bus-way' , invokes continuous the services until there are
	 * no remaining records to send
	 * 
	 * @see replyBusDataForService
	 */
	private void replyBusData() {
		replyBusDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TURN),
				ReplyOptions.SBOP_TURN);
		replyBusDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_ASGN_TURN),
				ReplyOptions.SBOP_ASGN_TURN);
		replyBusDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_ACCE_SALI),
				ReplyOptions.SBOP_ACCE_SALI);
		replyBusDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_CONT_ACCE),
				ReplyOptions.SBOP_CONT_ACCE);
		replyBusDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SFMO_HIST),
				ReplyOptions.SFMO_HIST);
		replyBusDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SFOP_EQUI_ALAR),
				ReplyOptions.SFOP_EQUI_ALAR);
		replyBusDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SFOP_MSG_COND),
				ReplyOptions.SFOP_MSG_COND);
		replyBusDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SFRU_ASGN),
				ReplyOptions.SFRU_ASGN);
		replyBusDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SFVH_DATA_DIA),
				ReplyOptions.SFVH_DATA_DIA);
	}

}
