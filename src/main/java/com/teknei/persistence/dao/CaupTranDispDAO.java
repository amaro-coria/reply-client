/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.CaupTran;
import com.teknei.persistence.entities.disp.CaupTranPK;

/**
 * DAO Interface for CaupTran
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface CaupTranDispDAO extends CrudRepository<CaupTran, CaupTranPK> {

}
