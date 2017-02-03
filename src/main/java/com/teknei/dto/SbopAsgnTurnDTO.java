/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * DTO representation class for SbopAsgnTurn
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Data
public class SbopAsgnTurnDTO implements Serializable{
	
	private Long idAsgnTurn;
	private Long idTurn;
	private Integer idEqui;
	private Timestamp fchCrea;
	private Timestamp fchModi;
	private Integer idConSis;
	private Integer idEsta;
	private Integer idLinEst;
	private Integer idSuc;
	private Integer idTipo;
	private Integer idVehi;
	private String noEcon;
	private String usrCrea;
	private String usrModi;
}
