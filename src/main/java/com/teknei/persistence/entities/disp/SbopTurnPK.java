package com.teknei.persistence.entities.disp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sbop_turn database table.
 * 
 */
@Embeddable
@Data
public class SbopTurnPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_turn")
	private Long idTurn;

	@Column(name="id_equi", insertable=false, updatable=false)
	private Integer idEqui;

}