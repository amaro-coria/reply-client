package com.teknei.persistence.entities.disp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sbop_acce_sali database table.
 * 
 */
@Embeddable
@Data
public class SbopAcceSaliPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_acce_sali")
	private Integer idAcceSali;

	@Column(name="id_turn", insertable=false, updatable=false)
	private Integer idTurn;

	@Column(name="id_equi", insertable=false, updatable=false)
	private Integer idEqui;

}