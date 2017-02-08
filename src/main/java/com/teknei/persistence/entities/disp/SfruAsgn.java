package com.teknei.persistence.entities.disp;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the sfru_asgn database table.
 * 
 */
@Entity
@Table(name="sfru_asgn", schema="sitm_disp")
@Data
public class SfruAsgn implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SfruAsgnPK pk;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_lin")
	private Integer idLin;

	@Column(name="id_ruta")
	private Integer idRuta;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="id_tipo_usr")
	private Integer idTipoUsr;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

}