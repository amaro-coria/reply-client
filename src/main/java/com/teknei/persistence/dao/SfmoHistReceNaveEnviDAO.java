/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.envi.EnviSfmoHistReceNave;
import com.teknei.persistence.entities.envi.EnviSfmoHistReceNavePK;

public interface SfmoHistReceNaveEnviDAO extends CrudRepository<EnviSfmoHistReceNave, EnviSfmoHistReceNavePK> {

	/**
	 * Finds first 50 records missing for reply process ordered by date ASC
	 * @param bolEnvi - should send false
	 * @return - the list of records
	 */
	public List<EnviSfmoHistReceNave> findTop50ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);
	
}
