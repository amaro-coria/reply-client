/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

/**
 * DTO representation class for SbopTurn
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Data
public class SbopTurnDTO implements Serializable {

	private Long id;
	private Timestamp fchCrea;
	private Timestamp fchFinTurn;
	private Timestamp fchIniTurn;
	private Timestamp fchModi;
	private Integer idConSis;
	private Integer idEdoSes;
	private Integer idEsta;
	private Integer idTarj;
	private Integer idTipo;
	private Integer montCanc;
	private BigDecimal montTurn;
	private Integer tarjExis;
	private Integer tarjVend;
	private String uidTarj;
	private String usrCrea;
	private String usrModi;
	private Long idTurn;
	private Integer idEqui;
}
