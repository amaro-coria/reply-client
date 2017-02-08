/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SfopEquiAlar;
import com.teknei.persistence.entities.disp.SfopEquiAlarPK;

/**
 * DAO Inteface for SfopEquiAlar
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SfopEquiAlarDispDAO extends CrudRepository<SfopEquiAlar, SfopEquiAlarPK>{

}
