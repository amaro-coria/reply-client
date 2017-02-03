/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SbopAsgnTurn;
import com.teknei.persistence.entities.disp.SbopAsgnTurnPK;

/**
 * DAO Interface for SbopAsgnTurn
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopAsgnTurnDispDAO extends CrudRepository<SbopAsgnTurn, SbopAsgnTurnPK> {

}
