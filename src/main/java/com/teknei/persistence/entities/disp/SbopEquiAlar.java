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
 * The persistent class for the sbop_equi_alar database table.
 * 
 */
@Entity
@Table(name="sbop_equi_alar",schema="sitm_disp")
@Data
public class SbopEquiAlar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SbopEquiAlarPK id;

	@Column(name="esta_equi")
	private String estaEqui;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_fin")
	private Timestamp fchFin;

	@Column(name="fch_ini")
	private Timestamp fchIni;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_alar")
	private Integer idAlar;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_tarj")
	private Integer idTarj;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="uid_tarj")
	private String uidTarj;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;


}