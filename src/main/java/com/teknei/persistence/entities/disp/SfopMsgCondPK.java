package com.teknei.persistence.entities.disp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sfru_asgn database table.
 * 
 */
@Embeddable
@Data
public class SfopMsgCondPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_msg_cond")
	private Integer idMsgCond;

	@Column(name="id_vehi")
	private Integer idVehi;
}