package com.usmp.persistencia.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.usmp.persistencia.models.entities.Control;

public interface IControlDAO extends PagingAndSortingRepository<Control, Long>{
	//public List<Apoderado> findByDni(String dni);

}
