package com.usmp.persistencia.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.usmp.persistencia.models.entities.Alumno;

public interface IAlumnoDao extends PagingAndSortingRepository<Alumno, String> , CustomIAlumnoDao {
	//CustomIAlumnoDao extendemos el dao para poder ejecutar el query
	public List<Alumno> findByDnialu(String dnialu);
	
}
