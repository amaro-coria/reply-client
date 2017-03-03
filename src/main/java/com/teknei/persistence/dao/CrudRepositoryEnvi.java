/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interface for CRUD operations related to envi scheme classes
 * 
 * @author Jorge Amaro
 *
 * @param <T>
 *            - Envi scheme class
 * @param <ID>
 *            - ID primary key of the Envi scheme class
 */
@NoRepositoryBean
public interface CrudRepositoryEnvi<T, ID extends Serializable> extends CrudRepository<T, ID> {

	/**
	 * Finds first 50 records missing for reply process ordered by date ASC
	 * 
	 * @param bolEnvi
	 *            - should send false
	 * @return the records list
	 */
	public List<T> findTop50ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);

	/**
	 * Finds first 1000 records missing for reply process ordered by date ASC
	 * 
	 * @param bolEnvi
	 *            - should send false
	 * @return the records list
	 */
	public List<T> findTop1000ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);

	/**
	 * Finds first 2000 records missing for reply process ordered by date ASC
	 * 
	 * @param bolEnvi
	 *            - should send false
	 * @return the records list
	 */
	public List<T> findTop2000ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);

	/**
	 * Finds first 5000 records missing for reply process ordered by date ASC
	 * 
	 * @param bolEnvi
	 *            - should send false
	 * @return the records list
	 */
	public List<T> findTop5000ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);

	/**
	 * Finds first 10000 records missing for reply process ordered by date ASC
	 * 
	 * @param bolEnvi
	 *            - should send false
	 * @return the records list
	 */
	public List<T> findTop10000ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);

	/**
	 * Finds first 1000 records missing for reply process ordered by date DESC
	 * 
	 * @param bolEnvi
	 *            - should send false
	 * @return the records list
	 */
	public List<T> findTop1000ByBolEnviOrderByFchEnviDesc(boolean bolEnvi);

	/**
	 * Finds first 50000 records missing for reply process ordered by date ASC
	 * 
	 * @param bolEnvi
	 *            - should send false
	 * @return the records list
	 */
	public List<T> findTop50000ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);

	/**
	 * Finds first 500 records missing for reply process ordered by date ASC
	 * 
	 * @param bolEnvi
	 *            - should send false
	 * @return the records list
	 */
	public List<T> findTop500ByBolEnviOrderByFchEnviAsc(boolean bolEnvi);

	/**
	 * Counts the remaining records pending to send
	 * 
	 * @param bolEnvi
	 *            - should send false to count remaining
	 * @return the total
	 */
	public Long countByBolEnvi(boolean bolEnvi);

	public Long countByBolEnviAndFchEnviBetween(boolean bolEnvi, Date startDate, Date endDate);

}
