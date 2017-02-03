package com.teknei.persistence.entities.disp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sbop_cont_acce database table.
 * 
 */
@Embeddable
@Data
public class SbopContAccePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_cont_acce")
	private Integer idContAcce;

	@Column(name="id_turn", insertable=false, updatable=false)
	private Long idTurn;

	@Column(name="id_equi", insertable=false, updatable=false)
	private Integer idEqui;

}