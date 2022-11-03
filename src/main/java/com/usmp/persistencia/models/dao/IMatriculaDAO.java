package com.usmp.persistencia.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.usmp.persistencia.models.entities.Matricula;

public interface IMatriculaDAO extends PagingAndSortingRepository<Matricula, Long> {
	//public List<Matricula> findByDni(String dni);
}
