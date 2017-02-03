/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

/**
 * DTO class representation for SbopAcceSali
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Data
public class SbopAcceSaliDTO implements Serializable{
	
	private Integer idAcceSali;
	private Integer idTurn;
	private Integer idEqui;
	private BigDecimal costViaj;
	private Timestamp fchAcceSali;
	private Timestamp fchCrea;
	private Timestamp fchModi;
	private Integer idConSis;
	private Integer idEmprTarj;
	private Integer idEsta;
	private Integer idTarj;
	private Integer idTipo;
	private Integer idTipoAcce;
	private BigDecimal saldIni;
	private BigDecimal saldTarj;
	private String tcre;
	private String uidTarj;
	private String usrCrea;
	private String usrModi;
	
}
