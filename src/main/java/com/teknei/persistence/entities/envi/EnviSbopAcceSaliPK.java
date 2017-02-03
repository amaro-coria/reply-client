package com.teknei.persistence.entities.envi;

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
public class EnviSbopAcceSaliPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_acce_sali")
	private Integer idAcceSali;

	@Column(name="id_turn")
	private Integer idTurn;

	@Column(name="id_equi")
	private Integer idEqui;

}