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
 * The persistent class for the sbop_asgn_turn database table.
 * 
 */
@Entity
@Table(name="sbop_asgn_turn",schema="sitm_disp")
@Data
public class SbopAsgnTurn implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SbopAsgnTurnPK pk;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_con_sis")
	private Integer idConSis;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_lin_est")
	private Integer idLinEst;

	@Column(name="id_suc")
	private Integer idSuc;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_vehi")
	private Integer idVehi;

	@Column(name="no_econ")
	private String noEcon;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

}