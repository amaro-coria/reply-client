/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SbopReca;
import com.teknei.persistence.entities.disp.SbopRecaPK;

/**
 * DAO Interface for SbopReca
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopRecaDispDAO extends CrudRepository<SbopReca, SbopRecaPK> {

}
