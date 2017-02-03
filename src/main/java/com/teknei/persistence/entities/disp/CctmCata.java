package com.teknei.persistence.entities.disp;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the cctm_cata database table.
 * 
 */
@Entity
@Table(name="cctm_cata",schema="sitm_disp")
@Data
public class CctmCata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cata")
	private Integer idCata;

	@Column(name="cod_cata")
	private String codCata;

	@Column(name="cod_comp")
	private String codComp;

	@Column(name="cod_cort")
	private String codCort;

	@Column(name="des_comp")
	private String desComp;

	@Column(name="des_cort")
	private String desCort;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_ecat")
	private Integer idEcat;

	@Column(name="id_idio")
	private Integer idIdio;

	@Column(name="id_tcat")
	private Integer idTcat;

	@Column(name="orde_cata")
	private Integer ordeCata;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

}