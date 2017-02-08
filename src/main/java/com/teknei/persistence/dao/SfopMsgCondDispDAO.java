/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SfopMsgCond;
import com.teknei.persistence.entities.disp.SfopMsgCondPK;

/**
 * DAO Interface for SfopMsgCond
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SfopMsgCondDispDAO extends CrudRepository<SfopMsgCond, SfopMsgCondPK> {

}
