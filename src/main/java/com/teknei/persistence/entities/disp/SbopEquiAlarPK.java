package com.teknei.persistence.entities.disp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sbop_equi_alar database table.
 * 
 */
@Embeddable
@Data
public class SbopEquiAlarPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_equi_alar")
	private Integer idEquiAlar;

	@Column(name="id_equi", insertable=false, updatable=false)
	private Integer idEqui;

}