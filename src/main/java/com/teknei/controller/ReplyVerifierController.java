/**
 * Teknei 2016
 */
package com.teknei.controller;

import java.util.Optional;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teknei.dto.ResponseDTO;
import com.teknei.service.ReplyPurgeService;
import com.teknei.service.ReplyVerifierServiceInvoker;

/**
 * Rest Controller for quantity verifying
 * 
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
	@Autowired
	private ReplyPurgeService serviceReplyPurge;

	/**
	 * Fires the synchronization process for the given parameters
	 * 
	 * @param startDate
	 *            - the start date of the sync process
	 * @param endDate
	 *            - the end date of the sync process
	 * @param apiOption
	 *            - the API option of the sync process
	 * @return
	 */
	@RequestMapping(value = { "sync", "sync/{startDate}", "sync/{startDate}/{endDate}",
			"sync/{startDate}/{endDate}/{apiOption}" }, method = RequestMethod.GET)
	public ResponseDTO reSyncForDates(@PathVariable Optional<String> startDate, @PathVariable Optional<String> endDate,
			@PathVariable Optional<Integer> apiOption) {
		ResponseDTO dto = serviceInvoker.verify(startDate, endDate, apiOption);
		serviceReplyPurge.replyData();
		return dto;
	}

	/**
	 * Invokes the sync process for no date (in order to process all for
	 * yesterday). Fires everyday at 2am
	 */
	@Scheduled(cron = "0 0 2 1/1 * ? *")
	public void invokeDayli() {
		serviceInvoker.verify(Optional.empty(), Optional.empty(), Optional.empty());
		serviceReplyPurge.replyData();
	}

	/**
	 * Invokes the sync process every Sunday for the records of the week. Fires
	 * at Sunday 1am
	 */
	@Scheduled(cron = "0 0 1 ? * SUN *")
	public void invokeWeekly() {
		DateTime startDate = new DateTime().withTimeAtStartOfDay().withDayOfWeek(DateTimeConstants.MONDAY);
		DateTime endDate = new DateTime().withTimeAtStartOfDay().minusMillis(1);
		DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd");
		serviceInvoker.verify(Optional.of(dtf.print(startDate)), Optional.of(dtf.print(endDate)), Optional.empty());
		serviceReplyPurge.replyData();
	}
	
}
