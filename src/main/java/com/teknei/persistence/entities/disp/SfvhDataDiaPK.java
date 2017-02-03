package com.teknei.persistence.entities.disp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sfvh_data_dia database table.
 * 
 */
@Embeddable
@Data
public class SfvhDataDiaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_data_dia")
	private Integer idDataDia;

	@Column(name="id_vehi")
	private Integer idVehi;

}