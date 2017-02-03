package com.teknei.persistence.entities.envi;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sbop_reca_divi database table.
 * 
 */
@Embeddable
@Data
public class EnviSbopRecaDiviPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_reca_divi")
	private Integer idRecaDivi;

	@Column(name="id_reca")
	private Integer idReca;

	@Column(name="id_equi")
	private Integer idEqui;

}