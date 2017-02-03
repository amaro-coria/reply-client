package com.teknei.persistence.entities.disp;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the sbop_reca database table.
 * 
 */
@Entity
@Table(name="sbop_reca",schema="sitm_disp")
@Data
public class SbopReca implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SbopRecaPK id;

	@Column(name="fch_crea")
	private Timestamp fchCrea;

	@Column(name="fch_modi")
	private Timestamp fchModi;

	@Column(name="fch_reca")
	private Timestamp fchReca;

	@Column(name="id_esta")
	private Integer idEsta;

	@Column(name="id_tarj")
	private Integer idTarj;

	@Column(name="id_tipo")
	private Integer idTipo;

	@Column(name="tot_bill")
	private Integer totBill;

	@Column(name="tot_mone")
	private Integer totMone;

	@Column(name="uid_tarj")
	private String uidTarj;

	@Column(name="usr_crea")
	private String usrCrea;

	@Column(name="usr_modi")
	private String usrModi;

}