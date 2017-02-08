/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

/**
 * DTO class representation for SfruAsgn
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Data
public class SfruAsgnDTO implements Serializable{

	private Long id;
	private Integer idAsgn;
	private Integer idVehi;
	private Timestamp fchCrea;
	private Timestamp fchModi;
	private Integer idEsta;
	private Integer idLin;
	private Integer idRuta;
	private Integer idTipo;
	private Integer idTipoUsr;
	private String usrCrea;
	private String usrModi;
}
