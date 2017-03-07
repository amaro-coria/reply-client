package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.persistence.entities.disp.SbeqEqui;

public interface SbeqEquiDispDAO extends CrudRepository<SbeqEqui, Integer> {

	public SbeqEqui findTopByIdEstaOrderByIdEquiAsc(Integer idEsta);
	
}
