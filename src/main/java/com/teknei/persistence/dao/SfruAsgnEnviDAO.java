/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.envi.EnviSfruAsgn;
import com.teknei.persistence.entities.envi.EnviSfruAsgnPK;

/**
 * DAO Interface for SfruAsgn
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SfruAsgnEnviDAO extends CrudRepository<EnviSfruAsgn, EnviSfruAsgnPK> {

	/**
	 * Finds first 50 records missing for reply process ordered by date ASC
	 * @param bolEnvi - should send false
	 * @return - the list of records
	 */
	public List<EnviSfruAsgn> findTop50ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);
}
