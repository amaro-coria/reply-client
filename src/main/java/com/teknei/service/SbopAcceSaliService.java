/**
 * Teknei 2016
 */
package com.teknei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknei.dto.ResponseDTO;
import com.teknei.dto.SbopAcceSaliDTO;
import com.teknei.persistence.dao.SbopAcceSaliDispDAO;
import com.teknei.persistence.dao.SbopAcceSaliEnviDAO;
import com.teknei.persistence.entities.disp.SbopAcceSali;
import com.teknei.persistence.entities.disp.SbopAcceSaliPK;
import com.teknei.persistence.entities.envi.EnviSbopAcceSali;
import com.teknei.persistence.entities.envi.EnviSbopAcceSaliPK;
import com.teknei.service.assembler.TKNAssembler;
import com.teknei.service.client.ApiClient;

/**
 * Implementation business class for SbopAcceSali
 * 
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service
public class SbopAcceSaliService implements ReplyService {

	@Autowired
	private ApiClient client;
	@Autowired
	private TKNAssembler assembler;
	@Autowired
	private SbopAcceSaliEnviDAO daoEnvi;
	@Autowired
	private SbopAcceSaliDispDAO daoDisp;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.teknei.service.ReplyService#replyData()
	 */
	@Override
	public ResponseDTO replyData() {
		ReplyServiceImpl<EnviSbopAcceSali, EnviSbopAcceSaliPK, SbopAcceSali, SbopAcceSaliPK, SbopAcceSaliDTO> service = new ReplyServiceImpl<>(
				SbopAcceSaliPK.class, daoEnvi, daoDisp, assembler.getAssemblerSbopAcceSali(), "sendAcceRecords",
				client);
		ResponseDTO d = service.replyData();
		return null;
	}

}
