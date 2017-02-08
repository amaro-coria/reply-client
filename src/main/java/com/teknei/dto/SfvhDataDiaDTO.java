/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

/**
 * DTO class representation for SfvhDataDia
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Data
public class SfvhDataDiaDTO implements Serializable {

	private Long id;
	private Integer idDataDia;
	private Integer idVehi;
	private Timestamp diaReg;
	private Timestamp fchCrea;
	private Timestamp fchModi;
	private Integer idEsta;
	private Integer idTipo;
	private BigDecimal kmReco;
	private String usrCrea;
	private String usrModi;
	private BigDecimal velProm;

}
