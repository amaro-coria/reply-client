package com.teknei.persistence.entities.disp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the sfvh_data_dia database table.
 * 
 */
@Entity
@Table(name="sfvh_data_dia", schema="sitm_disp")
@Data
public class SfvhDataDia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SfvhDataDiaPK pk;

	@Column(name="dia_reg")
	private Timestamp diaReg;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="km_reco")
	private BigDecimal kmReco;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

	@Column(name="vel_prom")
	private BigDecimal velProm;


}