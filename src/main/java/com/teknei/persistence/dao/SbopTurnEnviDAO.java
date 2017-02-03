/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.teknei.persistence.entities.envi.EnviSbopTurn;
import com.teknei.persistence.entities.envi.EnviSbopTurnPK;

/**
 * DAO interface for EnviSbopTurn
 * @author Jorge Amaro
 * @since 1.0.0
 * @version 1.0.0
 *
 */
public interface SbopTurnEnviDAO extends CrudRepository<EnviSbopTurn, EnviSbopTurnPK> {

	/**
	 * Finds first 50 records missing for reply process ordered by date ASC
	 * @param bolEnvi - should send false
	 * @return the records list
	 */
	public List<EnviSbopTurn> findTop50ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);
	
}
