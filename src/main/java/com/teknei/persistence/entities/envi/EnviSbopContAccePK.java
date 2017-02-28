package com.teknei.persistence.entities.envi;
// Generated 4/08/2015 05:20:32 PM by Hibernate Tools 4.3.1

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
public class EnviSbopContAccePK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "id_cont_acce")
	private Integer idContAcce;

	@Column(name = "id_equi")
	private Integer idEqui;
	
	@Column(name = "id_turn")
	private Integer idTurn;

}
