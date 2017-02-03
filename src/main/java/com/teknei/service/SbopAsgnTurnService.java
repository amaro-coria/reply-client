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
import com.teknei.dto.SbopAsgnTurnDTO;
import com.teknei.persistence.dao.SbopAsgnTurnDispDAO;
import com.teknei.persistence.dao.SbopAsgnTurnEnviDAO;
import com.teknei.persistence.entities.disp.SbopAsgnTurn;
import com.teknei.persistence.entities.disp.SbopAsgnTurnPK;
import com.teknei.persistence.entities.envi.EnviSbopAsgnTurn;
import com.teknei.persistence.entities.envi.EnviSbopAsgnTurnPK;
import com.teknei.service.assembler.TKNAssembler;
import com.teknei.service.client.ApiClient;
import com.teknei.util.UtilConstants;

/**
 * Implementation class for SbopAsgnTurn business
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Service
@Qualifier(UtilConstants.REPLY_SERVICE_QUALIFIER_ASGN_TURN)
public class SbopAsgnTurnService implements ReplyService {

	/*
	 * Injected values
	 * */
	@Autowired
	private ApiClient client;
	@Autowired
	private TKNAssembler assembler;
	@Autowired
	private SbopAsgnTurnDispDAO daoDisp;
	@Autowired
	private SbopAsgnTurnEnviDAO daoEnvi;
	
	/* (non-Javadoc)
	 * @see com.teknei.service.ReplyService#replyData()
	 */
	public ResponseDTO replyData() {
		List<EnviSbopAsgnTurnPK> listEnviPK = new ArrayList<>();
		List<SbopAsgnTurn> listToSend = daoEnvi.findTop50ByBolEnviOrderByFchEnviAsc(false).stream().map(e -> {
			EnviSbopAsgnTurnPK pke = e.getId();
			listEnviPK.add(pke);
			SbopAsgnTurnPK pk = new SbopAsgnTurnPK();
			pk.setIdEqui(pke.getIdEqui());
			pk.setIdTurn(pke.getIdTurn());
			pk.setIdAsgnTurn(pke.getIdAsgnTurn());
			SbopAsgnTurn turn = daoDisp.findOne(pk);
			return turn;
		}).collect(Collectors.toList());
		List<SbopAsgnTurnDTO> listDTO = listToSend.stream().map(d -> assembler.getAssemblerSbopAsgnTurn().getDTO(d))
				.collect(Collectors.toList());
		ResponseDTO d = client.sendAsgnTurnRecords(listDTO);
		if (d != null && d.getStatusCode().equals(UtilConstants.STATUS_OK)) {
			listEnviPK.forEach(s -> {
				EnviSbopAsgnTurn t = daoEnvi.findOne(s);
				t.setBolEnvi(true);
				t.setCodEnvi(UtilConstants.STATUS_OK);
				daoEnvi.save(t);
			});
		}
		return d;
	}
}
