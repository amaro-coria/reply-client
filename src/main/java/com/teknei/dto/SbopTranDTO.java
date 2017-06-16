/**
 * Teknei 2016
 */
package com.teknei.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * DTO Class representation for SbopTran
 *
 * @author Jorge Amaro Coria
 * @version 1.0.1
 * @since 1.0.0
 */
@Data
public class SbopTranDTO implements Serializable {

    private Long id;
    private Integer idTran;
    private Integer idTurn;
    private Integer idEqui;
    private String canc;
    private Timestamp fchCrea;
    private Timestamp fchModi;
    private Timestamp fchTran;
    private Integer idConSis;
    private Integer idEmprTarj;
    private Integer idEsta;
    private Integer idLbla;
    private Integer idMotCanc;
    private Integer idTarj;
    private Integer idTipo;
    private BigDecimal impoTran;
    private BigDecimal impoWeb;
    private BigDecimal montChcr;
    private BigDecimal saldIni;
    private BigDecimal saldTarj;
    private String tcre;
    private String tipoTran;
    private String uidTarj;
    private String usrCrea;
    private String usrModi;
    private Integer idPaqDiav;
    private Integer idTraz;

}
