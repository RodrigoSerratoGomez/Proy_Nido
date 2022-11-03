package com.usmp.persistencia.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.usmp.persistencia.models.entities.Pai;

public interface IPaisDAO extends PagingAndSortingRepository<Pai, Long> {
	public List<Pai> findByNompais(String nompais);
}
