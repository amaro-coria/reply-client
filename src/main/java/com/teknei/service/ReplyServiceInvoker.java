/**
 * Teknei 2016
 */
package com.teknei.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknei.dto.SbopAcceSaliDTO;
import com.teknei.dto.SbopAsgnTurnDTO;
import com.teknei.dto.SbopTurnDTO;
import com.teknei.persistence.dao.SbopAcceSaliDispDAO;
import com.teknei.persistence.dao.SbopAcceSaliEnviDAO;
import com.teknei.persistence.dao.SbopAsgnTurnDispDAO;
import com.teknei.persistence.dao.SbopAsgnTurnEnviDAO;
import com.teknei.persistence.dao.SbopTurnDispDAO;
import com.teknei.persistence.dao.SbopTurnEnviDAO;
import com.teknei.persistence.entities.disp.SbopAcceSali;
import com.teknei.persistence.entities.disp.SbopAcceSaliPK;
import com.teknei.persistence.entities.disp.SbopAsgnTurn;
import com.teknei.persistence.entities.disp.SbopAsgnTurnPK;
import com.teknei.persistence.entities.disp.SbopTurn;
import com.teknei.persistence.entities.disp.SbopTurnPK;
import com.teknei.persistence.entities.envi.EnviSbopAcceSali;
import com.teknei.persistence.entities.envi.EnviSbopAcceSaliPK;
import com.teknei.persistence.entities.envi.EnviSbopAsgnTurn;
import com.teknei.persistence.entities.envi.EnviSbopAsgnTurnPK;
import com.teknei.persistence.entities.envi.EnviSbopTurn;
import com.teknei.persistence.entities.envi.EnviSbopTurnPK;
import com.teknei.service.assembler.TKNAssembler;
import com.teknei.service.client.ApiClient;
import com.teknei.util.ReplyOptions;

/**
 * Generic invoker for business calls
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service
public class ReplyServiceInvoker {
	/*
	 * Injected elements
	 * */
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
	/* Access map for store services */
	private Map<ReplyOptions, ReplyServiceImpl> mapReplyServices;
	
	/**
	 * Map that contains services for reply business data. Access is through {@code ReplyOptions} values
	 * @return the service associated with the given value
	 */
	public Map<ReplyOptions, ReplyServiceImpl> getMapReplyServices() {
		return mapReplyServices;
	}

	/**
	 * Constructs the actual services
	 */
	@PostConstruct
	private void postConstruct(){
		mapReplyServices = new HashMap<>();
		ReplyServiceImpl<EnviSbopAcceSali, EnviSbopAcceSaliPK, SbopAcceSali, SbopAcceSaliPK, SbopAcceSaliDTO> serviceAcceSali = new ReplyServiceImpl<>(
				SbopAcceSaliPK.class, daoEnviAcceSali, daoDispAcceSali, assembler.getAssemblerSbopAcceSali(), "sendAcceRecords",
				client);
		ReplyServiceImpl<EnviSbopTurn, EnviSbopTurnPK, SbopTurn, SbopTurnPK, SbopTurnDTO> serviceSbopTurn = new ReplyServiceImpl<>(
				SbopTurnPK.class, daoEnviSbopTurn, daoDispSbopTurn, assembler.getAssemblerSbopTurn(), "sendTurnRecords",
				client);
		ReplyServiceImpl<EnviSbopAsgnTurn, EnviSbopAsgnTurnPK, SbopAsgnTurn, SbopAsgnTurnPK, SbopAsgnTurnDTO> serviceSbopAsgnTurn = new ReplyServiceImpl<>(
				SbopAsgnTurnPK.class, daoEnviSbopAsgnTurn, daoDispSbopAsgnTurn, assembler.getAssemblerSbopAsgnTurn(), "sendAsgnTurnRecords",
				client);
		mapReplyServices.put(ReplyOptions.SBOP_ACCE_SALI, serviceAcceSali);
		mapReplyServices.put(ReplyOptions.SBOP_TURN, serviceSbopTurn);
		mapReplyServices.put(ReplyOptions.SBOP_ASGN_TURN, serviceSbopAsgnTurn);
		
	}
	
}
