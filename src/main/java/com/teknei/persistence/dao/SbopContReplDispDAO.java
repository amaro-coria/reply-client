/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SbopContRepl;
import com.teknei.persistence.entities.disp.SbopContReplPK;

/**
 * DAO Interface for SbopContRepl
 * 
 * @author Jorge Amaro Coria
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SbopContReplDispDAO extends CrudRepository<SbopContRepl, SbopContReplPK> {

}
