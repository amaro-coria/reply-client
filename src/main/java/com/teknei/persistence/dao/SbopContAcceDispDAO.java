/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SbopContAcce;
import com.teknei.persistence.entities.disp.SbopContAccePK;

/**
 * DAO Interface for SbopContAcce
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopContAcceDispDAO extends CrudRepository<SbopContAcce, SbopContAccePK> {

}
