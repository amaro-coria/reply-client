/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.envi.EnviSbopRecaDivi;
import com.teknei.persistence.entities.envi.EnviSbopRecaDiviPK;

/**
 * DAO Interface for SbopRecaDivi
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopRecaDiviEnviDAO extends CrudRepository<EnviSbopRecaDivi, EnviSbopRecaDiviPK> {

	/**
	 * Finds first 50 records missing for reply process ordered by date ASC
	 * @param bolEnvi - should send false
	 * @return the records list
	 */
	public List<EnviSbopRecaDivi> findTop50ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);
}
