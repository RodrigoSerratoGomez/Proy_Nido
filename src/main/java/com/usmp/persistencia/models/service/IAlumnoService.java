package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Alumno;

public interface IAlumnoService {
	
	public List<Alumno> findAll();
	public void save(Alumno alumno);
	public Alumno findOne(String id);
	public void delete (String id);
	public List<Alumno> findByDnialu(String dni);
	//public Page<HotelEntity> findAll(Pageable pageable);
	

}
