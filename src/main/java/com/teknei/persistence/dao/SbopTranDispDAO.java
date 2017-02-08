/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SbopTran;
import com.teknei.persistence.entities.disp.SbopTranPK;

/**
 * DAO Interface for SbopTran
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopTranDispDAO extends CrudRepository<SbopTran, SbopTranPK> {

}
