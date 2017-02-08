/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * DTO Class representation for SbopTranDivi
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Data
public class SbopTranDiviDTO implements Serializable{

	private Long id;
	private Integer idTranDivi;
	private Integer idTran;
	private Integer idTurn;
	private Integer idEqui;
	private Integer cant;
	private Timestamp fchCrea;
	private Timestamp fchModi;
	private Integer idDivi;
	private Integer idEsta;
	private Integer idTipo;
	private String usrCrea;
	private String usrModi;
}
