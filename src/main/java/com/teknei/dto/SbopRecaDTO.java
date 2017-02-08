/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * DTO Class representation for SbopReca
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Data
public class SbopRecaDTO implements Serializable {

	private Integer idReca;
	private Integer idEqui;
	private Timestamp fchCrea;
	private Timestamp fchModi;
	private Timestamp fchReca;
	private Integer idEsta;
	private Integer idTarj;
	private Integer idTipo;
	private Integer totBill;
	private Integer totMone;
	private String uidTarj;
	private String usrCrea;
	private String usrModi;
}
