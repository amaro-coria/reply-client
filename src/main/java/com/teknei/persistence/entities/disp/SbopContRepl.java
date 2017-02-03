package com.teknei.persistence.entities.disp;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the sbop_cont_repl database table.
 * 
 */
@Entity
@Table(name="sbop_cont_repl", schema="sitm_disp")
@Data
public class SbopContRepl implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SbopContReplPK id;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="fch_oper")
	private Timestamp fchOper;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_tipo_repl")
	private Integer idTipoRepl;

	@Column(name="id_vehi")
	private Integer idVehi;

	@Column(name="reg_disp_tot")
	private Integer regDispTot;

	@Column(name="reg_envi_tot")
	private Integer regEnviTot;

	@Column(name="reg_pend_envi")
	private Integer regPendEnvi;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

}