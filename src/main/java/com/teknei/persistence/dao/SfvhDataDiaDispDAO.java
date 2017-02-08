/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SfvhDataDia;
import com.teknei.persistence.entities.disp.SfvhDataDiaPK;

/**
 * DAO Interface for SfvhDataDia
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SfvhDataDiaDispDAO extends CrudRepository<SfvhDataDia, SfvhDataDiaPK> {

}
