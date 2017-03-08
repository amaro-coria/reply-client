/**
 * Teknei 2016
 */
package com.teknei.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknei.dto.CaupTranDTO;
import com.teknei.dto.SbopAcceSaliDTO;
import com.teknei.dto.SbopAsgnTurnDTO;
import com.teknei.dto.SbopContAcceDTO;
import com.teknei.dto.SbopContReplDTO;
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
import com.teknei.persistence.dao.CaupTranDispDAO;
import com.teknei.persistence.dao.CaupTranEnviDAO;
import com.teknei.persistence.dao.SbopAcceSaliDispDAO;
import com.teknei.persistence.dao.SbopAcceSaliEnviDAO;
import com.teknei.persistence.dao.SbopAsgnTurnDispDAO;
import com.teknei.persistence.dao.SbopAsgnTurnEnviDAO;
import com.teknei.persistence.dao.SbopContAcceDispDAO;
import com.teknei.persistence.dao.SbopContAcceEnviDAO;
import com.teknei.persistence.dao.SbopContReplDispDAO;
import com.teknei.persistence.dao.SbopContReplEnviDAO;
import com.teknei.persistence.dao.SbopRecaDispDAO;
import com.teknei.persistence.dao.SbopRecaDiviDispDAO;
import com.teknei.persistence.dao.SbopRecaDiviEnviDAO;
import com.teknei.persistence.dao.SbopRecaEnviDAO;
import com.teknei.persistence.dao.SbopTranDispDAO;
import com.teknei.persistence.dao.SbopTranDiviDispDAO;
import com.teknei.persistence.dao.SbopTranDiviEnviDAO;
import com.teknei.persistence.dao.SbopTranEnviDAO;
import com.teknei.persistence.dao.SbopTurnDispDAO;
import com.teknei.persistence.dao.SbopTurnEnviDAO;
import com.teknei.persistence.dao.SfmoHistReceNaveDispDAO;
import com.teknei.persistence.dao.SfmoHistReceNaveEnviDAO;
import com.teknei.persistence.dao.SfopEquiAlarDispDAO;
import com.teknei.persistence.dao.SfopEquiAlarEnviDAO;
import com.teknei.persistence.dao.SfopMsgCondDispDAO;
import com.teknei.persistence.dao.SfopMsgCondEnviDAO;
import com.teknei.persistence.dao.SfruAsgnDispDAO;
import com.teknei.persistence.dao.SfruAsgnEnviDAO;
import com.teknei.persistence.dao.SfvhDataDiaDispDAO;
import com.teknei.persistence.dao.SfvhDataDiaEnviDAO;
import com.teknei.persistence.entities.disp.CaupTran;
import com.teknei.persistence.entities.disp.CaupTranPK;
import com.teknei.persistence.entities.disp.SbopAcceSali;
import com.teknei.persistence.entities.disp.SbopAcceSaliPK;
import com.teknei.persistence.entities.disp.SbopAsgnTurn;
import com.teknei.persistence.entities.disp.SbopAsgnTurnPK;
import com.teknei.persistence.entities.disp.SbopContAcce;
import com.teknei.persistence.entities.disp.SbopContAccePK;
import com.teknei.persistence.entities.disp.SbopContRepl;
import com.teknei.persistence.entities.disp.SbopContReplPK;
import com.teknei.persistence.entities.disp.SbopReca;
import com.teknei.persistence.entities.disp.SbopRecaDivi;
import com.teknei.persistence.entities.disp.SbopRecaDiviPK;
import com.teknei.persistence.entities.disp.SbopRecaPK;
import com.teknei.persistence.entities.disp.SbopTran;
import com.teknei.persistence.entities.disp.SbopTranDivi;
import com.teknei.persistence.entities.disp.SbopTranDiviPK;
import com.teknei.persistence.entities.disp.SbopTranPK;
import com.teknei.persistence.entities.disp.SbopTurn;
import com.teknei.persistence.entities.disp.SbopTurnPK;
import com.teknei.persistence.entities.disp.SfmoHistReceNave;
import com.teknei.persistence.entities.disp.SfmoHistReceNavePK;
import com.teknei.persistence.entities.disp.SfopEquiAlar;
import com.teknei.persistence.entities.disp.SfopEquiAlarPK;
import com.teknei.persistence.entities.disp.SfopMsgCond;
import com.teknei.persistence.entities.disp.SfopMsgCondPK;
import com.teknei.persistence.entities.disp.SfruAsgn;
import com.teknei.persistence.entities.disp.SfruAsgnPK;
import com.teknei.persistence.entities.disp.SfvhDataDia;
import com.teknei.persistence.entities.disp.SfvhDataDiaPK;
import com.teknei.persistence.entities.envi.EnviCaupTran;
import com.teknei.persistence.entities.envi.EnviCaupTranPK;
import com.teknei.persistence.entities.envi.EnviSbopAcceSali;
import com.teknei.persistence.entities.envi.EnviSbopAcceSaliPK;
import com.teknei.persistence.entities.envi.EnviSbopAsgnTurn;
import com.teknei.persistence.entities.envi.EnviSbopAsgnTurnPK;
import com.teknei.persistence.entities.envi.EnviSbopContAcce;
import com.teknei.persistence.entities.envi.EnviSbopContAccePK;
import com.teknei.persistence.entities.envi.EnviSbopContRepl;
import com.teknei.persistence.entities.envi.EnviSbopContReplPK;
import com.teknei.persistence.entities.envi.EnviSbopReca;
import com.teknei.persistence.entities.envi.EnviSbopRecaDivi;
import com.teknei.persistence.entities.envi.EnviSbopRecaDiviPK;
import com.teknei.persistence.entities.envi.EnviSbopRecaPK;
import com.teknei.persistence.entities.envi.EnviSbopTran;
import com.teknei.persistence.entities.envi.EnviSbopTranDivi;
import com.teknei.persistence.entities.envi.EnviSbopTranDiviPK;
import com.teknei.persistence.entities.envi.EnviSbopTranPK;
import com.teknei.persistence.entities.envi.EnviSbopTurn;
import com.teknei.persistence.entities.envi.EnviSbopTurnPK;
import com.teknei.persistence.entities.envi.EnviSfmoHistReceNave;
import com.teknei.persistence.entities.envi.EnviSfmoHistReceNavePK;
import com.teknei.persistence.entities.envi.EnviSfopEquiAlar;
import com.teknei.persistence.entities.envi.EnviSfopEquiAlarPK;
import com.teknei.persistence.entities.envi.EnviSfopMsgCond;
import com.teknei.persistence.entities.envi.EnviSfopMsgCondPK;
import com.teknei.persistence.entities.envi.EnviSfruAsgn;
import com.teknei.persistence.entities.envi.EnviSfruAsgnPK;
import com.teknei.persistence.entities.envi.EnviSfvhDataDia;
import com.teknei.persistence.entities.envi.EnviSfvhDataDiaPK;
import com.teknei.service.assembler.TKNAssembler;
import com.teknei.service.client.ApiClient;
import com.teknei.util.ReplyOptions;

/**
 * Generic invoker for business calls
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service
public class ReplyServiceInvoker {
	/*
	 * Injected elements
	 */
	@Autowired
	private ApiClient client;
	@Autowired
	private TKNAssembler assembler;
	@Autowired
	private SbopAcceSaliEnviDAO daoEnviAcceSali;
	@Autowired
	private SbopAcceSaliDispDAO daoDispAcceSali;
	@Autowired
	private SbopTurnEnviDAO daoEnviSbopTurn;
	@Autowired
	private SbopTurnDispDAO daoDispSbopTurn;
	@Autowired
	private SbopAsgnTurnDispDAO daoDispSbopAsgnTurn;
	@Autowired
	private SbopAsgnTurnEnviDAO daoEnviSbopAsgnTurn;
	@Autowired
	private SbopTranEnviDAO daoEnviSbopTran;
	@Autowired
	private SbopTranDispDAO daoDispSbopTran;
	@Autowired
	private SbopTranDiviEnviDAO daoEnviSbopTranDivi;
	@Autowired
	private SbopTranDiviDispDAO daoDispSbopTranDivi;
	@Autowired
	private SbopRecaEnviDAO daoEnviSbopReca;
	@Autowired
	private SbopRecaDispDAO daoDispSbopReca;
	@Autowired
	private SbopRecaDiviEnviDAO daoEnviSbopRecaDivi;
	@Autowired
	private SbopRecaDiviDispDAO daoDispSbopRecaDivi;
	@Autowired
	private SbopContAcceEnviDAO daoEnviSbopContAcce;
	@Autowired
	private SbopContAcceDispDAO daoDispSbopContAcce;
	@Autowired
	private SfopEquiAlarEnviDAO daoEnviSfopEquiAlar;
	@Autowired
	private SfopEquiAlarDispDAO daoDispSfopEquiAlar;
	@Autowired
	private SfopMsgCondEnviDAO daoEnviSfopMsgCond;
	@Autowired
	private SfopMsgCondDispDAO daoDispSfopMsgCond;
	@Autowired
	private SfruAsgnDispDAO daoDispSfruAsgn;
	@Autowired
	private SfruAsgnEnviDAO daoEnviSfruAsgn;
	@Autowired
	private SfvhDataDiaDispDAO daoDispSfvhDataDia;
	@Autowired
	private SfvhDataDiaEnviDAO daoEnviSfvhDataDia;
	@Autowired
	private SfmoHistReceNaveDispDAO daoDispSfmoHistReceNave;
	@Autowired
	private SfmoHistReceNaveEnviDAO daoEnviSfmoHistReceNave;
	@Autowired
	private CaupTranDispDAO daoDispCaupTran;
	@Autowired
	private CaupTranEnviDAO daoEnviCaupTran;
	@Autowired
	private SbopContReplDispDAO daoDispSbopContRepl;
	@Autowired
	private SbopContReplEnviDAO daoEnviSbopContRepl;
	/* Access map for store services */
	private Map<ReplyOptions, ReplyServiceImpl> mapReplyServices;

	/**
	 * Map that contains services for reply business data. Access is through
	 * {@code ReplyOptions} values
	 * 
	 * @return the service associated with the given value
	 */
	public Map<ReplyOptions, ReplyServiceImpl> getMapReplyServices() {
		return mapReplyServices;
	}

	/**
	 * Constructs the actual services
	 */
	@PostConstruct
	private void postConstruct() {
		mapReplyServices = new HashMap<>();
		// Invoker for SbopAcceSali
		ReplyServiceImpl<EnviSbopAcceSali, EnviSbopAcceSaliPK, SbopAcceSali, SbopAcceSaliPK, SbopAcceSaliDTO> serviceAcceSali = new ReplyServiceImpl<>(
				SbopAcceSaliPK.class, daoEnviAcceSali, daoDispAcceSali, assembler.getAssemblerSbopAcceSali(),
				"sendAcceRecords", client);
		// Invoker for SbopTurn
		ReplyServiceImpl<EnviSbopTurn, EnviSbopTurnPK, SbopTurn, SbopTurnPK, SbopTurnDTO> serviceSbopTurn = new ReplyServiceImpl<>(
				SbopTurnPK.class, daoEnviSbopTurn, daoDispSbopTurn, assembler.getAssemblerSbopTurn(), "sendTurnRecords",
				client);
		// Invoker for SbopAsgnTurn
		ReplyServiceImpl<EnviSbopAsgnTurn, EnviSbopAsgnTurnPK, SbopAsgnTurn, SbopAsgnTurnPK, SbopAsgnTurnDTO> serviceSbopAsgnTurn = new ReplyServiceImpl<>(
				SbopAsgnTurnPK.class, daoEnviSbopAsgnTurn, daoDispSbopAsgnTurn, assembler.getAssemblerSbopAsgnTurn(),
				"sendAsgnTurnRecords", client);
		// Invoker for SbopTran
		ReplyServiceImpl<EnviSbopTran, EnviSbopTranPK, SbopTran, SbopTranPK, SbopTranDTO> serviceSbopTran = new ReplyServiceImpl<>(
				SbopTranPK.class, daoEnviSbopTran, daoDispSbopTran, assembler.getAssemblerSbopTran(), "sendTranRecords",
				client);
		// Invoker for SbopTranDivi
		ReplyServiceImpl<EnviSbopTranDivi, EnviSbopTranDiviPK, SbopTranDivi, SbopTranDiviPK, SbopTranDiviDTO> serviceSbopTranDivi = new ReplyServiceImpl<>(
				SbopTranDiviPK.class, daoEnviSbopTranDivi, daoDispSbopTranDivi, assembler.getAssemblerSbopTranDivi(),
				"sendTranDiviRecords", client);
		// Invoker for SbopReca
		ReplyServiceImpl<EnviSbopReca, EnviSbopRecaPK, SbopReca, SbopRecaPK, SbopRecaDTO> serviceSbopReca = new ReplyServiceImpl<>(
				SbopRecaPK.class, daoEnviSbopReca, daoDispSbopReca, assembler.getAssemblerSbopReca(), "sendRecaRecords",
				client);
		// Invoker for SbopRecaDivi
		ReplyServiceImpl<EnviSbopRecaDivi, EnviSbopRecaDiviPK, SbopRecaDivi, SbopRecaDiviPK, SbopRecaDiviDTO> serviceSbopRecaDivi = new ReplyServiceImpl<>(
				SbopRecaDiviPK.class, daoEnviSbopRecaDivi, daoDispSbopRecaDivi, assembler.getAssemblerSbopRecaDivi(),
				"sendRecaDiviRecords", client);
		// Invoker for SbopContAcce
		ReplyServiceImpl<EnviSbopContAcce, EnviSbopContAccePK, SbopContAcce, SbopContAccePK, SbopContAcceDTO> serviceSbopContAcce = new ReplyServiceImpl<>(
				SbopContAccePK.class, daoEnviSbopContAcce, daoDispSbopContAcce, assembler.getAssemblerSbopContAcce(),
				"sendContAcceRecords", client);
		// Invoker for SfopEquiAlar
		ReplyServiceImpl<EnviSfopEquiAlar, EnviSfopEquiAlarPK, SfopEquiAlar, SfopEquiAlarPK, SfopEquiAlarDTO> serviceSfopEquiAlar = new ReplyServiceImpl<>(
				SfopEquiAlarPK.class, daoEnviSfopEquiAlar, daoDispSfopEquiAlar, assembler.getAssemblerSfopEquiAlar(),
				"sendSfopEquiAlarRecords", client);
		// Invoker for SfopEquiAlar
		ReplyServiceImpl<EnviSfopMsgCond, EnviSfopMsgCondPK, SfopMsgCond, SfopMsgCondPK, SfopMsgCondDTO> serviceSfopMsgCond = new ReplyServiceImpl<>(
				SfopMsgCondPK.class, daoEnviSfopMsgCond, daoDispSfopMsgCond, assembler.getAssemblerSfopMsgCond(),
				"sendMsgCondRecords", client);
		// Invoker for SfruAsgn
		ReplyServiceImpl<EnviSfruAsgn, EnviSfruAsgnPK, SfruAsgn, SfruAsgnPK, SfruAsgnDTO> serviceSfruAsgn = new ReplyServiceImpl<>(
				SfruAsgnPK.class, daoEnviSfruAsgn, daoDispSfruAsgn, assembler.getAssemblerSfruAsgn(), "sendSfruRecords",
				client);
		// Invoker for SfvhDataDia
		ReplyServiceImpl<EnviSfvhDataDia, EnviSfvhDataDiaPK, SfvhDataDia, SfvhDataDiaPK, SfvhDataDiaDTO> serviceSfvhDataDia = new ReplyServiceImpl<>(
				SfvhDataDiaPK.class, daoEnviSfvhDataDia, daoDispSfvhDataDia, assembler.getAssemblerSfvhDataDia(),
				"sendSfvhRecords", client);
		// Invoker for SfmoHistReceNave
		ReplyServiceImpl<EnviSfmoHistReceNave, EnviSfmoHistReceNavePK, SfmoHistReceNave, SfmoHistReceNavePK, SfmoHistReceNaveDTO> serviceSfmoHistReceNave = new ReplyServiceImpl<>(
				SfmoHistReceNavePK.class, daoEnviSfmoHistReceNave, daoDispSfmoHistReceNave,
				assembler.getAssemblerSfmoHistReceNave(), "sendSfmoRecords", client);
		// Invoker for CaupTran
		ReplyServiceImpl<EnviCaupTran, EnviCaupTranPK, CaupTran, CaupTranPK, CaupTranDTO> serviceCaupTran = new ReplyServiceImpl<>(
				CaupTranPK.class, daoEnviCaupTran, daoDispCaupTran, assembler.getAssemblerCaupTran(), "sendCauRecords",
				client);
		// Invoker for SbopContReol
		ReplyServiceImpl<EnviSbopContRepl, EnviSbopContReplPK, SbopContRepl, SbopContReplPK, SbopContReplDTO> serviceContRepl = new ReplyServiceImpl<>(
				SbopContReplPK.class, daoEnviSbopContRepl, daoDispSbopContRepl, assembler.getAssemblerContRepl(),
				"sendContReplRecords", client);
		mapReplyServices.put(ReplyOptions.SBOP_ACCE_SALI, serviceAcceSali);
		mapReplyServices.put(ReplyOptions.SBOP_TURN, serviceSbopTurn);
		mapReplyServices.put(ReplyOptions.SBOP_ASGN_TURN, serviceSbopAsgnTurn);
		mapReplyServices.put(ReplyOptions.SBOP_TRAN, serviceSbopTran);
		mapReplyServices.put(ReplyOptions.SBOP_TRAN_DIVI, serviceSbopTranDivi);
		mapReplyServices.put(ReplyOptions.SBOP_RECA, serviceSbopReca);
		mapReplyServices.put(ReplyOptions.SBOP_RECA_DIVI, serviceSbopRecaDivi);
		mapReplyServices.put(ReplyOptions.SBOP_CONT_ACCE, serviceSbopContAcce);
		mapReplyServices.put(ReplyOptions.SFOP_EQUI_ALAR, serviceSfopEquiAlar);
		mapReplyServices.put(ReplyOptions.SFOP_MSG_COND, serviceSfopMsgCond);
		mapReplyServices.put(ReplyOptions.SFRU_ASGN, serviceSfruAsgn);
		mapReplyServices.put(ReplyOptions.SFVH_DATA_DIA, serviceSfvhDataDia);
		mapReplyServices.put(ReplyOptions.SFMO_HIST, serviceSfmoHistReceNave);
		mapReplyServices.put(ReplyOptions.CAUP_TRAN, serviceCaupTran);
		mapReplyServices.put(ReplyOptions.SBOP_CONT_REPL, serviceContRepl);
	}

}
