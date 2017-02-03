package com.teknei.persistence.entities.disp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * The primary key class for the sfmo_hist_rece_nave database table.
 * 
 */
@Embeddable
@Data
public class SfmoHistReceNavePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_reco_nave")
	private Integer idRecoNave;

	@Column(name="id_vehi", insertable=false, updatable=false)
	private Integer idVehi;

}