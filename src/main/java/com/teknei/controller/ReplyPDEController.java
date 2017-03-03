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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.teknei.dto.ResponseDTO;
import com.teknei.service.ReplyServiceInvoker;
import com.teknei.util.ReplyOptions;
import com.teknei.util.ReplySpeedOption;
import com.teknei.util.UtilConstants;

/**
 * Controller for reply PDE - VIA components
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component
@Profile("pde")
public class ReplyPDEController {

	/*
	 * Injected elements
	 */
	@Autowired
	private ReplyServiceInvoker serviceInvoker;
	@Value("${tkn.api.fail-fast}")
	private boolean failFast;
	@Value("${tkn.api.hierarchy}")
	private boolean hierarchy;
	@Value("${tkn.reply.number}")
	private Integer noTranReply;
	private ReplySpeedOption replySpeedOption;

	private static final Logger log = LoggerFactory.getLogger(ReplyPDEController.class);

	/**
	 * Entry point for scheduled processes
	 */
	@Scheduled(fixedRateString = "${tkn.reply.rate}")
	public void reply() {
		replyData();
	}

	@PostConstruct
	private void postConstruct() {
		if (failFast) {
			log.info("Reply in mode failFast");
		} else if (hierarchy) {
			log.info("Reply in mode hierarchy");
		} else {
			log.info("Reply in mode noFail");
		}
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
	 * Business method for types of replication
	 */
	private void replyData() {
		log.debug("Reply time: {}", System.currentTimeMillis());
		if (failFast) {
			replyDataFailFast();
		} else if (hierarchy) {
			replyDataHierarchy();
		} else {
			replyDataNoFail();
		}
	}

	/**
	 * Reply data regardless fails
	 */
	private void replyDataNoFail() {
		serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TURN).replyData(replySpeedOption);
		serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_ASGN_TURN).replyData(replySpeedOption);
		serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_ACCE_SALI).replyData(replySpeedOption);
		serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_CONT_ACCE).replyData(replySpeedOption);
		serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TRAN).replyData(replySpeedOption);
		serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TRAN_DIVI).replyData(replySpeedOption);
		serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_RECA).replyData(replySpeedOption);
		serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_RECA_DIVI).replyData(replySpeedOption);
		serviceInvoker.getMapReplyServices().get(ReplyOptions.SFMO_HIST).replyBlockData();
	}

	/**
	 * Reply data with hierarchy mode according to business
	 */
	private void replyDataHierarchy() {
		ResponseDTO response = null;
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TURN).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Reply aborted at turn, error detected. Continue from the beginnig");
			return;
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_ASGN_TURN).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.warn("Error detected in asgnTurn, not aborting, no fatal error.");
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_ACCE_SALI).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.warn("Error detected in acceSali, not aborting, no fatal error.");
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TRAN).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Reply aborted at sbopTran, error detected. Continue from the beginnig");
			return;
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TRAN_DIVI).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.warn("Error detected in tranDivi, not aborting, no fatal error.");
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_RECA).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Reply aborted at sbopReca, error detected. Continue from the beginnig");
			return;
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_RECA_DIVI).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.warn("Error detected in recaDivi, not aborting, no fatal error.");
		}
		log.debug("Successful lap!");

	}

	/**
	 * Reply data. When error is detected in any method, aborts
	 */
	private void replyDataFailFast() {
		ResponseDTO response = null;
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TURN).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.warn("Reply aborted at turn, error detected. Continue from the beginnig");
			return;
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_ASGN_TURN).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.warn("Reply aborted at asgnTurn, error detected. Continue from the beginnig");
			return;
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_ACCE_SALI).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Reply aborted at acceSali, error detected. Continue from the beginnig");
			return;
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TRAN).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Reply aborted at sbopTran, error detected. Continue from the beginnig");
			return;
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TRAN_DIVI).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Reply aborted at sbopTranDivi, error detected. Continue from the beginnig");
			return;
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_RECA).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Reply aborted at sbopReca, error detected. Continue from the beginnig");
			return;
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_RECA_DIVI).replyData(replySpeedOption);
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Reply aborted at sbopRecaDivi, error detected. Continue from the beginnig");
			return;
		}
	}

}
