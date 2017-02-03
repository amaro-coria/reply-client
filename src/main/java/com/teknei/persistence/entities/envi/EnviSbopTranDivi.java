package com.teknei.persistence.entities.envi;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the sbop_tran_divi database table.
 * 
 */
@Entity
@Table(name="sbop_tran_divi", schema="sitm_envi")
@Data
public class EnviSbopTranDivi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EnviSbopTranDiviPK id;

	@Column(name="bol_envi")
	private Boolean bolEnvi;

	@Column(name="cod_envi")
	private String codEnvi;

	@Column(name="fch_envi")
	private Timestamp fchEnvi;

	@Column(name="id_envi")
	private Integer idEnvi;


}