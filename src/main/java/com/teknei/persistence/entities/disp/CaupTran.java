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
 * The persistent class for the caup_tran database table.
 */
@Entity
@Table(name = "caup_tran", schema = "sitm_disp")
@Data
public class CaupTran implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CaupTranPK pk;

    @Column(name = "des_moti_sust")
    private String desMotiSust;

    @Column(name = "fch_crea")
    private Timestamp fchCrea;

    @Column(name = "fch_modi")
    private Timestamp fchModi;

    @Column(name = "fch_vig")
    private Timestamp fchVig;

    @Column(name = "id_emp")
    private Integer idEmp;

    @Column(name = "id_esta")
    private Integer idEsta;

    @Column(name = "id_esta_ope")
    private Integer idEstaOpe;

    @Column(name = "id_moti_sust")
    private Integer idMotiSust;

    @Column(name = "id_ope_cau")
    private Integer idOpeCau;

    @Column(name = "id_pers")
    private Integer idPers;

    @Column(name = "id_tipo")
    private Integer idTipo;

    @Column(name = "id_usua_pref")
    private Integer idUsuaPref;

    @Column(name = "impo_tarj_ant")
    private BigDecimal impoTarjAnt;

    @Column(name = "impo_tarj_nue")
    private BigDecimal impoTarjNue;

    private String tcre;

    @Column(name = "uid_tarj_ant")
    private String uidTarjAnt;

    @Column(name = "uid_tarj_nue")
    private String uidTarjNue;

    @Column(name = "usr_crea")
    private String usrCrea;

    @Column(name = "usr_modi")
    private String usrModi;

    @Column(name = "id_paq_diav")
    private Integer idPaqDiav;

    @Column(name = "id_traz")
    private Integer idTraz;


}