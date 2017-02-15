/**
 * Teknei 2016
 */
package com.teknei.controller;

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

import com.teknei.dto.ResponseDTO;
import com.teknei.service.ReplyServiceImpl;
import com.teknei.service.ReplyServiceInvoker;
import com.teknei.util.ReplyOptions;
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
	@Value("${tkn.api.fail-fast}")
	private boolean failFast;
	@Value("${tkn.api.hierarchy}")
	private boolean hierarchy;

	private static final Logger log = LoggerFactory.getLogger(ReplyBusController.class);

	/**
	 * Entry point for reply bus processes
	 */
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ResponseEntity<ResponseDTO> reply() {
		replyData();
		ResponseDTO dto = new ResponseDTO(UtilConstants.STATUS_OK, UtilConstants.MESSAGE_OK);
		return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
	}

	/**
	 * Business method for replication of remaining records
	 * <pre>Enables async processes </pre>
	 */
	@Async
	private void replyData() {
		log.debug("Reply time init: {}", System.currentTimeMillis());
		replyBusData();
		log.debug("Reply time end: {}", System.currentTimeMillis());
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
		ResponseDTO d = service.replyData();
		if (!d.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Error replicating data: {}", option);
			replyBusDataForService(service, option);
		}
		long counterRemaining = service.countMoreData();
		if (counterRemaining > 0) {
			log.info("Data remaining : {} for option: {}", counterRemaining, option);
			replyBusDataForService(service, option);
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
