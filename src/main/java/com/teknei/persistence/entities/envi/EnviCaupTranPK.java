package com.teknei.persistence.entities.envi;

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
public class EnviCaupTranPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_caup_tran")
	private Integer idCaupTran;

	@Column(name="id_equi")
	private Integer idEqui;

	@Column(name="id_turn")
	private Integer idTurn;
}