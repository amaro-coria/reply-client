/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SbopAcceSali;
import com.teknei.persistence.entities.disp.SbopAcceSaliPK;

/**
 * DAO Interface for SbopAcceSali
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopAcceSaliDispDAO extends CrudRepository<SbopAcceSali, SbopAcceSaliPK> {

}
