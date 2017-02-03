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
 * The persistent class for the sbop_host database table.
 * 
 */
@Entity
@Table(name="sbop_host",schema="sitm_disp")
@Data
public class SbopHost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_host")
	private Integer idHost;

	private String afil;

	@Column(name="dir_ip_cde")
	private String dirIpCde;

	@Column(name="dir_ip_disp")
	private String dirIpDisp;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_est")
	private Integer idEst;

	@Column(name="id_host_cde")
	private Integer idHostCde;

	@Column(name="id_lin")
	private Integer idLin;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_tipo_disp")
	private Integer idTipoDisp;

	private String semi;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

	//uni-directional many-to-one association to CctmCata
	@ManyToOne
	@JoinColumn(name="id_esta")
	private CctmCata cctmCata;

	//uni-directional many-to-one association to SbeqEqui
	@ManyToOne
	@JoinColumn(name="id_equi")
	private SbeqEqui sbeqEqui;


}