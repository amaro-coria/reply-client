package com.teknei.persistence.entities.disp;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the sbop_acce_sali database table.
 */
@Entity
@Table(name = "sbop_acce_sali", schema = "sitm_disp")
@Data
public class SbopAcceSali implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SbopAcceSaliPK pk;

    @Column(name = "cost_viaj")
    private BigDecimal costViaj;

    @Column(name = "fch_acce_sali")
    private Timestamp fchAcceSali;

    @Column(name = "fch_crea")
    private Timestamp fchCrea;

    @Column(name = "fch_modi")
    private Timestamp fchModi;

    @Column(name = "id_con_sis")
    private Integer idConSis;

    @Column(name = "id_empr_tarj")
    private Integer idEmprTarj;

    @Column(name = "id_esta")
    private Integer idEsta;

    @Column(name = "id_tarj")
    private Integer idTarj;

    @Column(name = "id_tipo")
    private Integer idTipo;

    @Column(name = "id_tipo_acce")
    private Integer idTipoAcce;

    @Column(name = "sald_ini")
    private BigDecimal saldIni;

    @Column(name = "sald_tarj")
    private BigDecimal saldTarj;

    private String tcre;

    @Column(name = "uid_tarj")
    private String uidTarj;

    @Column(name = "usr_crea")
    private String usrCrea;

    @Column(name = "usr_modi")
    private String usrModi;

    @Column(name = "id_paq_diav")
    private Integer idPaqDiav;

    @Column(name = "id_traz")
    private Integer idTraz;


}