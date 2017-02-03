package com.teknei.persistence.entities.envi;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sbop_tran database table.
 * 
 */
@Embeddable
@Data
public class EnviSbopTranPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_tran")
	private Integer idTran;

	@Column(name="id_turn")
	private Integer idTurn;

	@Column(name="id_equi")
	private Integer idEqui;

}