/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.envi.EnviSbopContAcce;
import com.teknei.persistence.entities.envi.EnviSbopContAccePK;

/**
 * DAO Interface for SbopContAcce
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopContAcceEnviDAO extends CrudRepository<EnviSbopContAcce, EnviSbopContAccePK> {

	/**
	 * Finds first 50 records missing for reply process ordered by date ASC
	 * @param bolEnvi - should send false
	 * @return the records list
	 */
	public List<EnviSbopContAcce> findTop50ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);
	
}
