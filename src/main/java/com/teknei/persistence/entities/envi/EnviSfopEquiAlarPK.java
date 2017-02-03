package com.teknei.persistence.entities.envi;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sfop_equi_alar database table.
 * 
 */
@Embeddable
@Data
public class EnviSfopEquiAlarPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_opeq_alar")
	private Integer idOpeqAlar;

	@Column(name="id_vehi")
	private Integer idVehi;

}