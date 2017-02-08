package com.teknei.persistence.entities.disp;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the sfop_msg_cond database table.
 * 
 */
@Entity
@Table(name="sfop_msg_cond",schema="sitm_disp")
@Data
public class SfopMsgCond implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SfopMsgCondPK pk;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="fch_regi")
	private Timestamp fchRegi;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_tipo")
	private Integer idTipo;

	private String msg;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

}