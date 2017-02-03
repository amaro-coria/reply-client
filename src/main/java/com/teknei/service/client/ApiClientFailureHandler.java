package com.teknei.service.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.teknei.dto.ResponseDTO;
import com.teknei.dto.SbopAcceSaliDTO;
import com.teknei.dto.SbopAsgnTurnDTO;
import com.teknei.dto.SbopTurnDTO;
import com.teknei.util.UtilConstants;

@Component
public class ApiClientFailureHandler implements ApiClient{
	
	private static final Logger log = LoggerFactory.getLogger(ApiClientFailureHandler.class);

	@Override
	public ResponseDTO sendTurnRecords(List<SbopTurnDTO> list) {
		log.error("Error sending turn records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	@Override
	public ResponseDTO sendAcceRecords(List<SbopAcceSaliDTO> list) {
		log.error("Error sending access records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	@Override
	public ResponseDTO sendAsgnTurnRecords(List<SbopAsgnTurnDTO> list) {
		log.error("Error sending asgnTurn records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

}
