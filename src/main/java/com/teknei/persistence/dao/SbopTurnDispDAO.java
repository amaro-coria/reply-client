/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SbopTurn;
import com.teknei.persistence.entities.disp.SbopTurnPK;

/**
 * DAO Interface for SbopTurn
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopTurnDispDAO extends CrudRepository<SbopTurn, SbopTurnPK> {

}
