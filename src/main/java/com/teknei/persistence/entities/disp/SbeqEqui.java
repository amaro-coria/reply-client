package com.teknei.persistence.entities.disp;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the sbeq_equi database table.
 * 
 */
@Entity
@Table(name="sbeq_equi",schema="sitm_disp")
@Data
public class SbeqEqui implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_equi")
	private Integer idEqui;

	@Column(name="dir_ip")
	private String dirIp;

	@Column(name="fch_alta")
	private Timestamp fchAlta;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_inv")
	private Integer idInv;

	@Column(name="id_lin_est")
	private Integer idLinEst;

	@Column(name="id_suc")
	private Integer idSuc;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_vehi")
	private Integer idVehi;

	@Column(name="no_afil")
	private Integer noAfil;

	@Column(name="no_econ")
	private String noEcon;

	@Column(name="nume_seri")
	private String numeSeri;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

	//uni-directional many-to-one association to CctmCata
	@ManyToOne
	@JoinColumn(name="id_edo_equi")
	private CctmCata cctmCata1;

	//uni-directional many-to-one association to CctmCata
	@ManyToOne
	@JoinColumn(name="id_esta")
	private CctmCata cctmCata2;

	//uni-directional many-to-one association to CctmCata
	@ManyToOne
	@JoinColumn(name="id_mod")
	private CctmCata cctmCata3;

}