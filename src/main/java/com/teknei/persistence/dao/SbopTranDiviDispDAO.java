/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SbopTranDivi;
import com.teknei.persistence.entities.disp.SbopTranDiviPK;

/**
 * DAO Interface for SbopTranDivi
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopTranDiviDispDAO extends CrudRepository<SbopTranDivi, SbopTranDiviPK> {

}
