/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.envi.EnviSfopEquiAlar;
import com.teknei.persistence.entities.envi.EnviSfopEquiAlarPK;

/**
 * DAO Interface for SfopEquiAlar
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SfopEquiAlarEnviDAO extends CrudRepository<EnviSfopEquiAlar, EnviSfopEquiAlarPK> {

	/**
	 * Finds first 50 records missing for reply process ordered by date ASC
	 * @param bolEnvi - should send false
	 * @return - the list of records
	 */
	public List<EnviSfopEquiAlar> findTop50ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);
	
}
