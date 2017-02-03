/**
 * Teknei 2016
 */
package com.teknei.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.teknei.dto.ResponseDTO;
import com.teknei.dto.SbopTurnDTO;
import com.teknei.persistence.dao.SbopTurnDispDAO;
import com.teknei.persistence.dao.SbopTurnEnviDAO;
import com.teknei.persistence.entities.disp.SbopTurn;
import com.teknei.persistence.entities.disp.SbopTurnPK;
import com.teknei.persistence.entities.envi.EnviSbopTurn;
import com.teknei.persistence.entities.envi.EnviSbopTurnPK;
import com.teknei.service.assembler.Assembler;
import com.teknei.service.assembler.TKNAssembler;
import com.teknei.service.client.ApiClient;
import com.teknei.util.UtilConstants;

/**
 * Implementation business class for SbopTurn
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service
@Qualifier(UtilConstants.REPLY_SERVICE_QUALIFIER_TURN)
public class SbopTurnService implements ReplyService{
	
	/*
	 * Injected values
	 * */
	@Autowired
	private SbopTurnEnviDAO daoEnvi;
	@Autowired
	private SbopTurnDispDAO daoDisp;
	@Autowired
	private ApiClient client;
	@Autowired
	private TKNAssembler assembler;

	/* (non-Javadoc)
	 * @see com.teknei.service.ReplyService#replyData()
	 */
	public ResponseDTO replyData() {
		List<EnviSbopTurnPK> listEnviPK = new ArrayList<>();
		List<SbopTurn> listToSend = daoEnvi.findTop50ByBolEnviOrderByFchEnviAsc(false).stream().map(e -> {
			EnviSbopTurnPK pke = e.getId();
			listEnviPK.add(pke);
			SbopTurnPK pk = new SbopTurnPK();
			pk.setIdEqui(pke.getIdEqui());
			pk.setIdTurn(pke.getIdTurn());
			SbopTurn turn = daoDisp.findOne(pk);
			return turn;
		}).collect(Collectors.toList());
		List<SbopTurnDTO> listDTO = listToSend.stream().map(d -> assembler.getAssemblerSbopTurn().getDTO(d))
				.collect(Collectors.toList());
		ResponseDTO d = client.sendTurnRecords(listDTO);
		if (d != null && d.getStatusCode().equals(UtilConstants.STATUS_OK)) {
			listEnviPK.forEach(s -> {
				EnviSbopTurn t = daoEnvi.findOne(s);
				t.setBolEnvi(true);
				t.setCodEnvi(UtilConstants.STATUS_OK);
				daoEnvi.save(t);
			});
		}
		return d;
	}

}
