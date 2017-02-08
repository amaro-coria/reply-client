/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * DTO Class representation for SfmoHistReceNave
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Data
public class SfmoHistReceNaveDTO implements Serializable{

	private Long id;
	private Integer idRecoNave;
	private Integer idVehi;
	private Double distRecoReceNave;
	private Timestamp fchCrea;
	private Timestamp fchModi;
	private Timestamp fchReceNave;
	private Timestamp horaGpsReceNave;
	private Timestamp horaSistReceNave;
	private Integer idConSis;
	private Integer idEsta;
	private Integer idTipo;
	private Double latiReceNave;
	private Double longReceNave;
	private String modeReceNave;
	private String numSeriRecoNave;
	private Double timeRecoReceNave;
	private String usrCrea;
	private String usrModi;
	private Double veloReceNave;
}
