/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.envi.EnviSbopAsgnTurn;
import com.teknei.persistence.entities.envi.EnviSbopAsgnTurnPK;

/**
 * DAO Interface for EnviSbopAsgnTurn
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopAsgnTurnEnviDAO extends CrudRepository<EnviSbopAsgnTurn, EnviSbopAsgnTurnPK> {

	/**
	 * Finds first 50 records missing for reply process ordered by date ASC
	 * @param bolEnvi - should send false
	 * @return - the list of records
	 */
	public List<EnviSbopAsgnTurn> findTop50ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);
}
