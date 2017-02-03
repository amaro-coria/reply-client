package com.teknei.persistence.entities.disp;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the sfmo_hist_rece_nave database table.
 * 
 */
@Entity
@Table(name="sfmo_hist_rece_nave", schema="sitm_disp")
@Data
public class SfmoHistReceNave implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SfmoHistReceNavePK id;

	@Column(name="dist_reco_rece_nave")
	private double distRecoReceNave;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="fch_rece_nave")
	private Timestamp fchReceNave;

	@Column(name="hora_gps_rece_nave")
	private Timestamp horaGpsReceNave;

	@Column(name="hora_sist_rece_nave")
	private Timestamp horaSistReceNave;

	@Column(name="id_con_sis")
	private Integer idConSis;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="lati_rece_nave")
	private double latiReceNave;

	@Column(name="long_rece_nave")
	private double longReceNave;

	@Column(name="mode_rece_nave")
	private String modeReceNave;

	@Column(name="num_seri_reco_nave")
	private String numSeriRecoNave;

	@Column(name="time_reco_rece_nave")
	private double timeRecoReceNave;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

	@Column(name="velo_rece_nave")
	private double veloReceNave;

}