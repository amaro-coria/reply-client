package com.teknei.persistence.entities.envi;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sfop_msg_cond database table.
 * 
 */
@Embeddable
@Data
public class EnviSfopMsgCondPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_msg_cond")
	private Integer idMsgCond;

	@Column(name="id_vehi")
	private Integer idVehi;

}