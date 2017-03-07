/**
 * Teknei 2016
 */
package com.teknei.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknei.dto.ResponseDTO;
import com.teknei.persistence.dao.CaupTranEnviDAO;
import com.teknei.persistence.dao.CrudRepositoryEnvi;
import com.teknei.persistence.dao.SbeqEquiDispDAO;
import com.teknei.persistence.dao.SbopAcceSaliEnviDAO;
import com.teknei.persistence.dao.SbopAsgnTurnEnviDAO;
import com.teknei.persistence.dao.SbopContAcceEnviDAO;
import com.teknei.persistence.dao.SbopRecaDiviEnviDAO;
import com.teknei.persistence.dao.SbopRecaEnviDAO;
import com.teknei.persistence.dao.SbopTranDiviEnviDAO;
import com.teknei.persistence.dao.SbopTranEnviDAO;
import com.teknei.persistence.dao.SbopTurnEnviDAO;
import com.teknei.persistence.dao.SfmoHistReceNaveEnviDAO;
import com.teknei.persistence.dao.SfopEquiAlarEnviDAO;
import com.teknei.persistence.dao.SfopMsgCondEnviDAO;
import com.teknei.persistence.dao.SfruAsgnEnviDAO;
import com.teknei.persistence.dao.SfvhDataDiaEnviDAO;
import com.teknei.service.client.VerifierClient;
import com.teknei.util.ReplyOptions;
import com.teknei.util.UtilConstants;

/**
 * Service that invokes verifying processes on remote server and fires local
 * processes for update purposes
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service
public class ReplyVerifierServiceInvoker {
	/*
	 * Injected elements
	 * */
	@Autowired
	private VerifierClient clientVerifier;
	@Autowired
	private SbeqEquiDispDAO daoEqui;
	@Autowired
	private SbopAcceSaliEnviDAO daoEnviAcceSali;
	@Autowired
	private SbopTurnEnviDAO daoEnviSbopTurn;
	@Autowired
	private SbopAsgnTurnEnviDAO daoEnviSbopAsgnTurn;
	@Autowired
	private SbopTranEnviDAO daoEnviSbopTran;
	@Autowired
	private SbopTranDiviEnviDAO daoEnviSbopTranDivi;
	@Autowired
	private SbopRecaEnviDAO daoEnviSbopReca;
	@Autowired
	private SbopRecaDiviEnviDAO daoEnviSbopRecaDivi;
	@Autowired
	private SbopContAcceEnviDAO daoEnviSbopContAcce;
	@Autowired
	private SfopEquiAlarEnviDAO daoEnviSfopEquiAlar;
	@Autowired
	private SfopMsgCondEnviDAO daoEnviSfopMsgCond;
	@Autowired
	private SfruAsgnEnviDAO daoEnviSfruAsgn;
	@Autowired
	private SfvhDataDiaEnviDAO daoEnviSfvhDataDia;
	@Autowired
	private SfmoHistReceNaveEnviDAO daoEnviSfmoHistReceNave;
	@Autowired
	private CaupTranEnviDAO daoEnviCaupTran;
	private Integer idEqui;
	@SuppressWarnings("rawtypes")
	private Map<String, CrudRepositoryEnvi> mapRepository;

	/**
	 * Post-construct init method
	 */
	@PostConstruct
	private void postConstruct() {
		idEqui = daoEqui.findTopByIdEstaOrderByIdEquiAsc(1).getIdEqui();
		initRepositoryMap();

	}

	/**
	 * Init's the repository local map
	 */
	private void initRepositoryMap() {
		mapRepository = new HashMap<>();
		mapRepository.put(ReplyOptions.SBOP_TURN.name(), daoEnviSbopTurn);
		mapRepository.put(ReplyOptions.SBOP_ASGN_TURN.name(), daoEnviSbopAsgnTurn);
		mapRepository.put(ReplyOptions.SBOP_ACCE_SALI.name(), daoEnviAcceSali);
		mapRepository.put(ReplyOptions.SBOP_CONT_ACCE.name(), daoEnviSbopContAcce);
		mapRepository.put(ReplyOptions.SBOP_TRAN.name(), daoEnviSbopTran);
		mapRepository.put(ReplyOptions.SBOP_TRAN_DIVI.name(), daoEnviSbopTranDivi);
		mapRepository.put(ReplyOptions.SBOP_RECA.name(), daoEnviSbopReca);
		mapRepository.put(ReplyOptions.SBOP_RECA_DIVI.name(), daoEnviSbopRecaDivi);
		mapRepository.put(ReplyOptions.SFRU_ASGN.name(), daoEnviSfruAsgn);
		mapRepository.put(ReplyOptions.CAUP_TRAN.name(), daoEnviCaupTran);
		mapRepository.put(ReplyOptions.SFMO_HIST.name(), daoEnviSfmoHistReceNave);
		mapRepository.put(ReplyOptions.SFVH_DATA_DIA.name(), daoEnviSfvhDataDia);
		mapRepository.put(ReplyOptions.SFOP_MSG_COND.name(), daoEnviSfopMsgCond);
		mapRepository.put(ReplyOptions.SFOP_EQUI_ALAR.name(), daoEnviSfopEquiAlar);
	}

	/**
	 * Verifies the local tables according to the remote status
	 * @param startDate - the start date
	 * @param endDate - the end date
	 * @param apiOption - the api option
	 * @return
	 */
	public ResponseDTO verify(Optional<String> startDate, Optional<String> endDate, Optional<Integer> apiOption) {
		List<ResponseDTO> listResponse = null;
		if (!startDate.isPresent() && !endDate.isPresent()) {
			listResponse = clientVerifier.count(idEqui);
		} else if (startDate.isPresent() && !endDate.isPresent()) {
			listResponse = clientVerifier.countStartDate(idEqui, startDate.get());
		} else if (startDate.isPresent() && endDate.isPresent()) {
			DateTime dtStart = new DateTime(startDate.get());
			DateTime dtEnd = new DateTime(endDate.get());
			if (dtStart.isAfter(dtEnd)) {
				return new ResponseDTO(UtilConstants.STATUS_API_USAGE_BAD_REQUEST_EXCEPTION,
						UtilConstants.MESSAGE_API_USAGE_BAD_REQUEST_EXCEPTION);
			} else {
				if (apiOption.isPresent()) {
					listResponse = clientVerifier.countBetweenDatesAndAPIOption(idEqui, startDate.get(), endDate.get(),
							apiOption.get());
				} else {
					listResponse = clientVerifier.countBetweenDates(idEqui, startDate.get(), endDate.get());
				}
			}
		} else {
			listResponse = clientVerifier.count(idEqui);
		}
		resync(listResponse, startDate, endDate);
		return new ResponseDTO(UtilConstants.STATUS_OK, UtilConstants.MESSAGE_OK);
	}

	/**
	 * Fires up the local process
	 * @param listResponse - the list containing the remote results
	 * @param startDate - the start date of the process
	 * @param endDate - the end date of the process
	 */
	private void resync(List<ResponseDTO> listResponse, Optional<String> startDate, Optional<String> endDate) {
		DateTime stDate = null;
		DateTime enDate = null;
		if (startDate.isPresent()) {
			stDate = new DateTime(startDate.get()).withTimeAtStartOfDay();
			if (endDate.isPresent()) {
				enDate = new DateTime(endDate.get()).plusDays(1).withTimeAtStartOfDay().minusMillis(1);
			} else {
				enDate = new DateTime(startDate.get()).plusDays(1).withTimeAtStartOfDay().minusMillis(1);
			}
		} else {
			stDate = new DateTime().withTimeAtStartOfDay();
		}
		if (listResponse != null && !listResponse.isEmpty()) {
			final Date sDate = stDate.toDate();
			final Date eDate = enDate.toDate();
			listResponse.forEach(e -> rollback(e, sDate, eDate));
		}
	}

	/**
	 * Rollback local tables
	 * @param replyOption - the DTO containing the information
	 * @param startDate - the start date of the comparison
	 * @param endDate - the end date of the comparison
	 */
	@SuppressWarnings("rawtypes")
	private void rollback(ResponseDTO replyOption, Date startDate, Date endDate) {
		CrudRepositoryEnvi crudEnvi = mapRepository.get(replyOption.getMessage().trim());
		if (crudEnvi != null) {
			String master = replyOption.getStatusCode();
			Long lMaster = null;
			try {
				lMaster = Long.parseLong(master);
				Long origin = crudEnvi.countByBolEnviAndFchEnviBetween(true, startDate, endDate);
				if (origin != null & origin != -1) {
					if (lMaster < origin) {
						crudEnvi.setBolEnviFalseByFchEnviBetween(startDate, endDate);
					}
				}
			} catch (Exception e) {
			}
		}
	}

}
