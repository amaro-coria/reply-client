/**
 * Teknei 2016
 */
package com.teknei.service.client;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.teknei.dto.ResponseDTO;
import com.teknei.util.UtilConstants;

/**
 * Failure implementing class
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component
public class VerifierClientFailureHandler implements VerifierClient {

	private static final List<ResponseDTO> lisFailure = Arrays.asList(
			new ResponseDTO(UtilConstants.STATUS_API_ACCESS_EXCEPTION, UtilConstants.MESSAGE_API_ACCESS_EXCEPTION));
	private static final Logger log = LoggerFactory.getLogger(VerifierClientFailureHandler.class);

	/* (non-Javadoc)
	 * @see com.teknei.service.client.VerifierClient#count(java.lang.Integer)
	 */
	@Override
	public List<ResponseDTO> count(Integer idEqui) {
		log.error("Error in count for params: {}", idEqui);
		return lisFailure;
	}

	/* (non-Javadoc)
	 * @see com.teknei.service.client.VerifierClient#countStartDate(java.lang.Integer, java.lang.String)
	 */
	@Override
	public List<ResponseDTO> countStartDate(Integer idEqui, String startDate) {
		log.error("Error in count for params: {}, {}", idEqui, startDate);
		return lisFailure;
	}

	/* (non-Javadoc)
	 * @see com.teknei.service.client.VerifierClient#countBetweenDates(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ResponseDTO> countBetweenDates(Integer idEqui, String startDate, String endDate) {
		log.error("Error in count for params: {}, {} , {}", idEqui, startDate, endDate);
		return lisFailure;
	}

	/* (non-Javadoc)
	 * @see com.teknei.service.client.VerifierClient#countBetweenDatesAndAPIOption(java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<ResponseDTO> countBetweenDatesAndAPIOption(Integer idEqui, String startDate, String endDate,
			Integer apiOption) {
		log.error("Error in count for params: {}, {} , {}, {}", idEqui, startDate, endDate, apiOption);
		return lisFailure;
	}

}
