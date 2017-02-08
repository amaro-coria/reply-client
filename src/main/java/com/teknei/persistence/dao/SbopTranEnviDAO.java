/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.envi.EnviSbopTran;
import com.teknei.persistence.entities.envi.EnviSbopTranPK;

/**
 * DAO Interface for SbopTran
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopTranEnviDAO extends CrudRepository<EnviSbopTran, EnviSbopTranPK> {

	/**
	 * Finds first 50 records missing for reply process ordered by date ASC
	 * @param bolEnvi - should send false
	 * @return the records list
	 */
	public List<EnviSbopTran> findTop50ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);
	
}
