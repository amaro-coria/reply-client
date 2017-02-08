/**
 * Teknei 2016
 */
package com.teknei.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO class representation for SfopEquiAlar
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class SfopEquiAlarDTO implements Serializable{

	private Long id;
	private Integer idOpeqAlar;
	private Integer idVehi;
	private String descOpeqAlar;
	private Integer estaAnti;
	private String estaEqui;
	private Timestamp fchCrea;
	private Timestamp fchFin;
	private Timestamp fchInic;
	private Timestamp fchModi;
	private Integer idAlar;
	private Integer idEst;
	private Integer idEsta;
	private Integer idTipo;
	private double latiAlar;
	private double lontAlar;
	private Integer statAlar;
	private double tramGps;
	private String usrCrea;
	private String usrModi;
	
	
}
