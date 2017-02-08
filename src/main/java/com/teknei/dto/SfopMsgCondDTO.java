/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * DTO Class representation for SfopMsgCond
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 * 
 */
@Data
public class SfopMsgCondDTO implements Serializable{

	private Long id;
	private Integer idMsgCond;
	private Integer idVehi;
	private Timestamp fchCrea;
	private Timestamp fchModi;
	private Timestamp fchRegi;
	private Integer idEsta;
	private Integer idTipo;
	private String msg;
	private String usrCrea;
	private String usrModi;
}
