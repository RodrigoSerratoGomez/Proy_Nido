package com.usmp.persistencia.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.usmp.persistencia.models.entities.Nivel;

public interface INivelDAO extends PagingAndSortingRepository<Nivel, Long>{
	public List<Nivel> findByNomnivel(String nomnivel);
}
