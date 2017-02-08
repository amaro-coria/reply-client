/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SbopRecaDivi;
import com.teknei.persistence.entities.disp.SbopRecaDiviPK;

/**
 * DAO Interface for SbopRecaDivi
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopRecaDiviDispDAO extends CrudRepository<SbopRecaDivi, SbopRecaDiviPK> {

}
