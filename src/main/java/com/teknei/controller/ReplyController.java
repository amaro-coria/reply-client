package com.teknei.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teknei.dto.ResponseDTO;
import com.teknei.service.FileStatusService;
import com.teknei.service.ReplyServiceImpl;
import com.teknei.service.ReplyServiceInvoker;
import com.teknei.util.ReplyOptions;
import com.teknei.util.ReplySpeedOption;
import com.teknei.util.UtilConstants;

@RestController
@RequestMapping("/api")
public class ReplyController {

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

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = { "count", "count/{startDate}", "count/{startDate}/{endDate}",
			"count/{startDate}/{endDate}/{apiOption}" }, method = RequestMethod.GET)
	public ResponseEntity<List<ResponseDTO>> countDay(@PathVariable Optional<String> startDate,
			@PathVariable Optional<String> endDate, @PathVariable Optional<Integer> apiOption) {
		DateTime dtStart = null;
		DateTime dtEnd = null;
		List<ResponseDTO> listResponse = new ArrayList<>();
		if (startDate.isPresent() && endDate.isPresent()) {
			dtStart = new DateTime(startDate.get());
			dtEnd = new DateTime(endDate.get());
			if (dtStart.isAfter(dtEnd)) {
				ResponseDTO errorResponse = new ResponseDTO(UtilConstants.STATUS_API_USAGE_BAD_REQUEST_EXCEPTION,
						UtilConstants.MESSAGE_API_USAGE_BAD_REQUEST_EXCEPTION);
				listResponse.add(errorResponse);
				return new ResponseEntity<List<ResponseDTO>>(listResponse, HttpStatus.BAD_REQUEST);
			}
		} else if (startDate.isPresent()) {
			dtStart = new DateTime(startDate.get());
			dtEnd = new DateTime(startDate.get());
		} else {
			dtStart = new DateTime();
			dtEnd = new DateTime();
		}
		dtStart = dtStart.withTimeAtStartOfDay();
		dtEnd = dtEnd.withTimeAtStartOfDay();
		dtEnd = dtEnd.plusDays(1);
		dtEnd = dtEnd.minusMillis(1);
		if (apiOption.isPresent()) {
			ReplyOptions opt = ReplyOptions.getReplyOptionFromNumber(apiOption.get());
			ReplyServiceImpl service = serviceInvoker.getMapReplyServices().get(opt);
			listResponse.add(new ResponseDTO(String.valueOf(service.countDataForDay(dtStart.toDate(), dtEnd.toDate())),
					opt.name()));
			return new ResponseEntity<List<ResponseDTO>>(listResponse, HttpStatus.OK);
		} else {
			for (ReplyOptions option : ReplyOptions.values()) {
				ReplyServiceImpl service = serviceInvoker.getMapReplyServices().get(option);
				if (service != null) {
					listResponse.add(new ResponseDTO(
							String.valueOf(service.countDataForDay(dtStart.toDate(), dtEnd.toDate())), option.name()));
				}
			}
		}
		return new ResponseEntity<List<ResponseDTO>>(listResponse, HttpStatus.OK);
	}

}
