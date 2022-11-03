package com.usmp.persistencia.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.usmp.persistencia.models.entities.Tipotele;

public interface ITipoteleDAO extends PagingAndSortingRepository<Tipotele, Long> {
	
	public List<Tipotele>  findByNomtipo(String nomtipo);
}
