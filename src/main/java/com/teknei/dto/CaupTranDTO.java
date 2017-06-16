/**
 * Teknei 2016
 */
package com.teknei.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DTO Class representation for CaupTran
 *
 * @author Jorge Amaro
 * @version 1.0.1
 * @since 1.0.0
 */
@Data
public class CaupTranDTO implements Serializable {

    private Long id;
    private Integer idCaupTran;
    private Integer idEqui;
    private Integer idTurn;
    private String desMotiSust;
    private Timestamp fchCrea;
    private Timestamp fchModi;
    private Timestamp fchVig;
    private Integer idEmp;
    private Integer idEsta;
    private Integer idEstaOpe;
    private Integer idMotiSust;
    private Integer idOpeCau;
    private Integer idPers;
    private Integer idTipo;
    private Integer idUsuaPref;
    private BigDecimal impoTarjAnt;
    private BigDecimal impoTarjNue;
    private String tcre;
    private String uidTarjAnt;
    private String uidTarjNue;
    private String usrCrea;
    private String usrModi;
    private Integer idPaqDiav;
    private Integer idTraz;

}
