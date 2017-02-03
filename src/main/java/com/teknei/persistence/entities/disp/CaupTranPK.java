package com.teknei.persistence.entities.disp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the caup_tran database table.
 * 
 */
@Embeddable
@Data
public class CaupTranPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_caup_tran")
	private Integer idCaupTran;

	@Column(name="id_equi", insertable=false, updatable=false)
	private Integer idEqui;

	@Column(name="id_turn", insertable=false, updatable=false)
	private Integer idTurn;

}