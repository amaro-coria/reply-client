package com.teknei.persistence.entities.disp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sbop_asgn_turn database table.
 * 
 */
@Embeddable
@Data
public class SbopAsgnTurnPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_asgn_turn")
	private Long idAsgnTurn;

	@Column(name="id_turn")
	private Long idTurn;

	@Column(name="id_equi")
	private Integer idEqui;

}