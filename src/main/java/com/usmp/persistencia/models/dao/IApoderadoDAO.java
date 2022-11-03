package com.usmp.persistencia.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.usmp.persistencia.models.entities.Apoderado;



public interface IApoderadoDAO extends PagingAndSortingRepository<Apoderado, String>{
	public List<Apoderado> findByDniapon(String dniapon);
}
