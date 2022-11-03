package com.usmp.persistencia.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.usmp.persistencia.models.entities.Apoderado;
import com.usmp.persistencia.models.entities.Tipodisca;

public interface ITipodiscaDAO extends PagingAndSortingRepository<Tipodisca, Long>{

	public List<Tipodisca> findByNomdisca(String nomdisca);
	//se busca por nombre de la discapacidad 
}
