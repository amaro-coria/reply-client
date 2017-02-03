package com.teknei.persistence.entities.disp;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the sbop_reca_divi database table.
 * 
 */
@Entity
@Table(name="sbop_reca_divi",schema="sitm_disp")
@Data
public class SbopRecaDivi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SbopRecaDiviPK id;

	private Integer cant;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_divi")
	private Integer idDivi;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

}