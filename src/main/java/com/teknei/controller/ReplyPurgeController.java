/**
 * Teknei 2016
 */
package com.teknei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teknei.dto.ResponseDTO;
import com.teknei.service.ReplyPurgeService;
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
@RequestMapping("/api/purge")
public class ReplyPurgeController {

	/*
	 * Injected elements
	 */
	@Autowired
	private ReplyPurgeService servicePurge;

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
	 * Business method for call replication of remaining records
	 * 
	 */
	private void replyData() {
		servicePurge.replyData();
	}

}
