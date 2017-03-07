/**
 * Teknei 2016
 */
package com.teknei.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teknei.dto.ResponseDTO;
import com.teknei.service.ReplyVerifierServiceInvoker;

/**
 * Rest Controller for quantity verifying
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("/api")
public class ReplyVerifierController {

	@Autowired
	private ReplyVerifierServiceInvoker serviceInvoker;

	/**
	 * Fires the synchronization process for the given parameters
	 * @param startDate - the start date of the sync process
	 * @param endDate - the end date of the sync process
	 * @param apiOption - the API option of the sync process 
	 * @return
	 */
	@RequestMapping(value = { "sync", "sync/{startDate}", "sync/{startDate}/{endDate}",
			"sync/{startDate}/{endDate}/{apiOption}" }, method = RequestMethod.GET)
	public ResponseDTO reSyncForDates(@PathVariable Optional<String> startDate, @PathVariable Optional<String> endDate,
			@PathVariable Optional<Integer> apiOption) {
		ResponseDTO dto = serviceInvoker.verify(startDate, endDate, apiOption);
		return dto;
	}

}
