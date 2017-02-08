/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SfruAsgn;
import com.teknei.persistence.entities.disp.SfruAsgnPK;

/**
 * DAO Interface for SfruAsgn
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SfruAsgnDispDAO extends CrudRepository<SfruAsgn, SfruAsgnPK> {

}
