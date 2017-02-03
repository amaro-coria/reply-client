package com.teknei.persistence.entities.envi;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sbop_cont_repl database table.
 * 
 */
@Entity
@Table(name="sbop_cont_repl", schema="sitm_envi")
public class EnviSbopContRepl implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EnviSbopContReplPK id;

	@Column(name="bol_envi")
	private Boolean bolEnvi;

	@Column(name="cod_envi")
	private String codEnvi;

	@Column(name="fch_envi")
	private Timestamp fchEnvi;

	@Column(name="id_envi")
	private Integer idEnvi;

	public EnviSbopContRepl() {
	}

	public EnviSbopContReplPK getId() {
		return this.id;
	}

	public void setId(EnviSbopContReplPK id) {
		this.id = id;
	}

	public Boolean getBolEnvi() {
		return this.bolEnvi;
	}

	public void setBolEnvi(Boolean bolEnvi) {
		this.bolEnvi = bolEnvi;
	}

	public String getCodEnvi() {
		return this.codEnvi;
	}

	public void setCodEnvi(String codEnvi) {
		this.codEnvi = codEnvi;
	}

	public Timestamp getFchEnvi() {
		return this.fchEnvi;
	}

	public void setFchEnvi(Timestamp fchEnvi) {
		this.fchEnvi = fchEnvi;
	}

	public Integer getIdEnvi() {
		return this.idEnvi;
	}

	public void setIdEnvi(Integer idEnvi) {
		this.idEnvi = idEnvi;
	}

}