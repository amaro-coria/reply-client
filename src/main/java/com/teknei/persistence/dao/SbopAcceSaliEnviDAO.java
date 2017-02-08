/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.envi.EnviSbopAcceSali;
import com.teknei.persistence.entities.envi.EnviSbopAcceSaliPK;

/**
 * DAO Interface for SbopAccesali
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopAcceSaliEnviDAO extends CrudRepository<EnviSbopAcceSali, EnviSbopAcceSaliPK> {

	/**
	 * Finds first 50 records missing for reply process ordered by date ASC
	 * @param bolEnvi - should send false
	 * @return - the list of records
	 */
	public List<EnviSbopAcceSali> findTop50ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);
	
}
