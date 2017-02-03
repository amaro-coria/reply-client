package com.teknei.persistence.entities.envi;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sbop_cont_repl database table.
 * 
 */
@Embeddable
public class EnviSbopContReplPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_cont_repl")
	private Integer idContRepl;

	@Column(name="id_equi")
	private Integer idEqui;

	public EnviSbopContReplPK() {
	}
	public Integer getIdContRepl() {
		return this.idContRepl;
	}
	public void setIdContRepl(Integer idContRepl) {
		this.idContRepl = idContRepl;
	}
	public Integer getIdEqui() {
		return this.idEqui;
	}
	public void setIdEqui(Integer idEqui) {
		this.idEqui = idEqui;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EnviSbopContReplPK)) {
			return false;
		}
		EnviSbopContReplPK castOther = (EnviSbopContReplPK)other;
		return 
			this.idContRepl.equals(castOther.idContRepl)
			&& this.idEqui.equals(castOther.idEqui);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idContRepl.hashCode();
		hash = hash * prime + this.idEqui.hashCode();
		
		return hash;
	}
}