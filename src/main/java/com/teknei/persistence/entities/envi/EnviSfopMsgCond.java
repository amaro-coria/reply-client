package com.teknei.persistence.entities.envi;

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
@Table(name="sfop_msg_cond", schema="sitm_envi")
@Data
public class EnviSfopMsgCond implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EnviSfopMsgCondPK id;

	@Column(name="bol_envi")
	private Boolean bolEnvi;

	@Column(name="cod_envi")
	private String codEnvi;

	@Column(name="fch_envi")
	private Timestamp fchEnvi;

	@Column(name="id_envi")
	private Integer idEnvi;

}