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
import com.teknei.util.UtilConstants;

/**
 * Controller for reply BUS components
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component
@Profile("cau")
public class ReplyCauController {

	/*
	 * Injected elements
	 */
	@Autowired
	private ReplyServiceInvoker serviceInvoker;
	@Value("${tkn.api.fail-fast}")
	private boolean failFast;
	@Value("${tkn.api.hierarchy}")
	private boolean hierarchy;

	private static final Logger log = LoggerFactory.getLogger(ReplyCauController.class);

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
		serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TURN).replyData();
		serviceInvoker.getMapReplyServices().get(ReplyOptions.CAUP_TRAN).replyData();
	}

	/**
	 * Reply data with hierarchy mode according to business
	 */
	private void replyDataHierarchy() {
		ResponseDTO response = null;
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TURN).replyData();
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Reply aborted at turn, error detected. Continue from the beginnig");
			return;
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.CAUP_TRAN).replyData();
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.error("Reply aborted at cauTran, error detected. Continue from the beginnig");
			return;
		}
		log.debug("Successful lap!");

	}

	/**
	 * Reply data. When error is detected in any method, aborts
	 */
	private void replyDataFailFast() {
		ResponseDTO response = null;
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.SBOP_TURN).replyData();
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.warn("Reply aborted at turn, error detected. Continue from the beginnig");
			return;
		}
		response = serviceInvoker.getMapReplyServices().get(ReplyOptions.CAUP_TRAN).replyData();
		if (!response.getStatusCode().equalsIgnoreCase(UtilConstants.STATUS_OK)) {
			log.warn("Reply aborted at cauTran, error detected. Continue from the beginnig");
			return;
		}
	}

}
