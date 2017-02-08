/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * DTO class representation for SbopContAcce
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Data
public class SbopContAcceDTO implements Serializable{

	private Integer idContAcce;
	private Long idTurn;
	private Integer idEqui;
	private Timestamp fchContAcce;
	private Timestamp fchCrea;
	private Timestamp fchModi;
	private Integer idConSis;
	private Integer idEsta;
	private Integer idPosiCont;
	private Integer idTipo;
	private Integer idTipoFluj;
	private Integer idTipoPasa;
	private String usrCrea;
	private String usrModi;

}
