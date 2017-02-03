package com.teknei.persistence.entities.disp;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the sbop_cont_acce database table.
 * 
 */
@Entity
@Table(name="sbop_cont_acce", schema="sitm_disp")
@Data
public class SbopContAcce implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SbopContAccePK id;

	@Column(name="fch_cont_acce")
	private Timestamp fchContAcce;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_con_sis")
	private Integer idConSis;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_posi_cont")
	private Integer idPosiCont;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_tipo_fluj")
	private Integer idTipoFluj;

	@Column(name="id_tipo_pasa")
	private Integer idTipoPasa;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

}