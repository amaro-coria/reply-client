package com.teknei.persistence.entities.disp;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the sfop_equi_alar database table.
 * 
 */
@Entity
@Table(name="sfop_equi_alar",schema="sitm_disp")
@Data
public class SfopEquiAlar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SfopEquiAlarPK pk;

	@Column(name="desc_opeq_alar")
	private String descOpeqAlar;

	@Column(name="esta_anti")
	private Integer estaAnti;

	@Column(name="esta_equi")
	private String estaEqui;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_fin")
	private Timestamp fchFin;

	@Column(name="fch_inic")
	private Timestamp fchInic;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_alar")
	private Integer idAlar;

	@Column(name="id_est")
	private Integer idEst;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="lati_alar")
	private double latiAlar;

	@Column(name="lont_alar")
	private double lontAlar;

	@Column(name="stat_alar")
	private Integer statAlar;

	@Column(name="tram_gps")
	private double tramGps;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

}