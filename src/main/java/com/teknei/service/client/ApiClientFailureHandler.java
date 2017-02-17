/**
 * Teknei 2016
 */
package com.teknei.service.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.teknei.dto.CaupTranDTO;
import com.teknei.dto.ResponseDTO;
import com.teknei.dto.SbopAcceSaliDTO;
import com.teknei.dto.SbopAsgnTurnDTO;
import com.teknei.dto.SbopContAcceDTO;
import com.teknei.dto.SbopRecaDTO;
import com.teknei.dto.SbopRecaDiviDTO;
import com.teknei.dto.SbopTranDTO;
import com.teknei.dto.SbopTranDiviDTO;
import com.teknei.dto.SbopTurnDTO;
import com.teknei.dto.SfmoHistReceNaveDTO;
import com.teknei.dto.SfopEquiAlarDTO;
import com.teknei.dto.SfopMsgCondDTO;
import com.teknei.dto.SfruAsgnDTO;
import com.teknei.dto.SfvhDataDiaDTO;
import com.teknei.util.UtilConstants;

/**
 * Failure implementing class
 * 
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Component
public class ApiClientFailureHandler implements ApiClient {

	private static final Logger log = LoggerFactory.getLogger(ApiClientFailureHandler.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teknei.service.client.ApiClient#sendTurnRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendTurnRecords(List<SbopTurnDTO> list) {
		log.error("Error sending turn records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teknei.service.client.ApiClient#sendAcceRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendAcceRecords(List<SbopAcceSaliDTO> list) {
		log.error("Error sending access records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teknei.service.client.ApiClient#sendAsgnTurnRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendAsgnTurnRecords(List<SbopAsgnTurnDTO> list) {
		log.error("Error sending asgnTurn records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teknei.service.client.ApiClient#sendTranRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendTranRecords(List<SbopTranDTO> list) {
		log.error("Error sending tranRecords records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teknei.service.client.ApiClient#sendTranDiviRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendTranDiviRecords(List<SbopTranDiviDTO> list) {
		log.error("Error sending tranDivi records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teknei.service.client.ApiClient#sendRecaRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendRecaRecords(List<SbopRecaDTO> list) {
		log.error("Error sending reca records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teknei.service.client.ApiClient#sendRecaDiviRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendRecaDiviRecords(List<SbopRecaDiviDTO> list) {
		log.error("Error sending recaDivi records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teknei.service.client.ApiClient#sendContAcceRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendContAcceRecords(List<SbopContAcceDTO> list) {
		log.error("Error sending contAcce records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teknei.service.client.ApiClient#sendSfopEquiAlarRecords(java.util.
	 * List)
	 */
	@Override
	public ResponseDTO sendSfopEquiAlarRecords(List<SfopEquiAlarDTO> list) {
		log.error("Error sending sfopEquiAlar records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.teknei.service.client.ApiClient#sendMsgCondRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendMsgCondRecords(List<SfopMsgCondDTO> list) {
		log.error("Error sending msgCond records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teknei.service.client.ApiClient#sendSfruRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendSfruRecords(List<SfruAsgnDTO> list) {
		log.error("Error sending sfruAsgn records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teknei.service.client.ApiClient#sendSfvhRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendSfvhRecords(List<SfvhDataDiaDTO> list) {
		log.error("Error sending sfvhDataDia records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teknei.service.client.ApiClient#sendSfmoRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendSfmoRecords(List<SfmoHistReceNaveDTO> list) {
		log.error("Error sending sfmoHistReceNave records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

	/* (non-Javadoc)
	 * @see com.teknei.service.client.ApiClient#sendCauRecords(java.util.List)
	 */
	@Override
	public ResponseDTO sendCauRecords(List<CaupTranDTO> list) {
		log.error("Error sending cauTran records to API");
		return new ResponseDTO(UtilConstants.STATUS_DATA_ACCESS_EXCEPTION, UtilConstants.MESSAGE_DATA_ACCESS_EXCEPTION);
	}

}
