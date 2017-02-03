package com.teknei.persistence.entities.disp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sbop_cont_repl database table.
 * 
 */
@Embeddable
@Data
public class SbopContReplPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_cont_repl")
	private Integer idContRepl;

	@Column(name="id_equi")
	private Integer idEqui;

}