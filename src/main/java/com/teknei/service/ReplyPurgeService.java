package com.teknei.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.teknei.dto.ReplyStatusDTO;
import com.teknei.dto.ResponseDTO;
import com.teknei.util.ReplyOptions;
import com.teknei.util.ReplySpeedOption;
import com.teknei.util.ReplyStatus;
import com.teknei.util.UtilConstants;

@Service
public class ReplyPurgeService {
	/*
	 * Injected elements
	 */
	@Autowired
	private ReplyServiceInvoker serviceInvoker;
	@Autowired
	private FileStatusService serviceStatus;
	@Value("${tkn.reply.number}")
	private Integer noTranReply;
	private static final Logger log = LoggerFactory.getLogger(ReplyPurgeService.class);
	private ReplySpeedOption replySpeedOption;
	
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
	 * Business method for replication of remaining records
	 * 
	 * <pre>
	 * Enables async processes
	 * </pre>
	 */
	@Async
	public void replyData() {
		ReplyStatus.getInstance().setFree(false);
		log.info("Reply time init: {}", System.currentTimeMillis());
		replyPurgeData();
		callReplyStatus(ReplyOptions.STATUS_FINISHED, 0);
		log.info("Reply time end: {}", System.currentTimeMillis());
		ReplyStatus.getInstance().setFree(true);
	}
	
	
	/**
	 * Reply data in 'bus-way' , invokes continuous the services until there are
	 * no remaining records to send
	 * 
	 * @see replyBusDataForService
	 */
	private void replyPurgeData() {
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TURN),
				ReplyOptions.SBOP_TURN);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_ASGN_TURN),
				ReplyOptions.SBOP_ASGN_TURN);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_ACCE_SALI),
				ReplyOptions.SBOP_ACCE_SALI);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_CONT_ACCE),
				ReplyOptions.SBOP_CONT_ACCE);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TRAN),
				ReplyOptions.SBOP_TRAN);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TRAN_DIVI),
				ReplyOptions.SBOP_TRAN_DIVI);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_RECA),
				ReplyOptions.SBOP_RECA);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_RECA_DIVI),
				ReplyOptions.SBOP_RECA_DIVI);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.CAUP_TRAN),
				ReplyOptions.CAUP_TRAN);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SFOP_EQUI_ALAR),
				ReplyOptions.SFOP_EQUI_ALAR);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SFOP_MSG_COND),
				ReplyOptions.SFOP_MSG_COND);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SFRU_ASGN),
				ReplyOptions.SFRU_ASGN);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SFVH_DATA_DIA),
				ReplyOptions.SFVH_DATA_DIA);
		replyPurgeDataForService(serviceInvoker.getMapReplyServices().get(ReplyOptions.SFMO_HIST),
				ReplyOptions.SFMO_HIST);
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
	private void replyPurgeDataForService(ReplyServiceImpl service, ReplyOptions option) {
		long counterRemaining = service.countMoreData();
		if (!(counterRemaining > 0)) {
			log.info("No data remaining for option: {}", option);
			return;
		}
		log.info("Data remaining : {} for option: {}", counterRemaining, option);
		callReplyStatus(option, counterRemaining);
		if (option.equals(ReplyOptions.SFMO_HIST)) {
			replyPurgeSfmo(service, option);
			return;
		}
		ResponseDTO d = service.replyData(replySpeedOption);
		if (!d.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Error {} replicating data: {}", d.getStatusCode(), option);
			if (canContinue()) {
				replyPurgeDataForService(service, option);
			} else {
				log.error("Maximum error counter reached, aborting");
				setLastStatusError();
				return;
			}
		}
		replyPurgeDataForService(service, option);

	}
	
	/**
	 * Check if the service can continue based on previous errors detected
	 * @return
	 */
	private boolean canContinue() {
		ReplyStatus.getInstance().addError();
		if (ReplyStatus.getInstance().getErrorCounter() >= 5) {
			return false;
		}
		return true;
	}

	/**
	 * Sets the flag to error
	 */
	private void setLastStatusError() {
		ReplyStatus.getInstance().setLastStatusWasError(true);
		ReplyStatus.getInstance().setFree(true);
	}

	/**
	 * Sets the status indicators to file
	 * @param optionActive
	 * @param counter
	 */
	private void callReplyStatus(ReplyOptions optionActive, long counter) {
		ReplyStatusDTO status = new ReplyStatusDTO();
		status.setRemaining(counter);
		status.setReplyOption(optionActive);
		serviceStatus.writeStatusFile(status);
	}
	
	/**
	 * Recursive method for sync process
	 * @param service - The service to be invoked
	 * @param option - The option to reply
	 */
	@SuppressWarnings("rawtypes")
	private void replyPurgeSfmo(ReplyServiceImpl service, ReplyOptions option) {
		ResponseDTO d = service.replyBlockData();
		if (!d.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Error replicating data: {}", option);
			if (canContinue()) {
				replyPurgeSfmo(service, option);
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
			replyPurgeSfmo(service, option);
		}
	}
}
