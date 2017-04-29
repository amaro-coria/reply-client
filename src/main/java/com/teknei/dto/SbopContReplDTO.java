package com.teknei.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class SbopContReplDTO implements Serializable{

	private Long id;
	private Timestamp fchCrea;
	private Timestamp fchModi;
	private Timestamp fchOper;
	private Integer idContRepl;
	private Integer idEqui;
	private Integer idEsta;
	private Integer idTipo;
	private Integer idTipoRepl;
	private Integer idVehi;
	private Integer regDispTot;
	private Integer regEnviTot;
	private Integer regPendEnvi;
	private String usrCrea;
	private String usrModi;
	private Integer actuPendEnvi;
	private String detaTipoRepl;
    private String obsContRepl;
	
}
