/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.envi.EnviSbopReca;
import com.teknei.persistence.entities.envi.EnviSbopRecaPK;

/**
 * DAO Interface for SbopReca
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopRecaEnviDAO extends CrudRepository<EnviSbopReca, EnviSbopRecaPK> {

	/**
	 * Finds first 50 records missing for reply process ordered by date ASC
	 * @param bolEnvi - should send false
	 * @return the records list
	 */
	public List<EnviSbopReca> findTop50ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);
}
