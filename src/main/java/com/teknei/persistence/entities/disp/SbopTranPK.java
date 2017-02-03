package com.teknei.persistence.entities.disp;

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
public class SbopTranPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_tran")
	private Integer idTran;

	@Column(name="id_turn", insertable=false, updatable=false)
	private Integer idTurn;

	@Column(name="id_equi", insertable=false, updatable=false)
	private Integer idEqui;

}