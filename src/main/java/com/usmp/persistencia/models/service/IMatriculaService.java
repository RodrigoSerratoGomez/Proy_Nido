package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Matricula;



public interface IMatriculaService {
	public List<Matricula> findAll();
	public void save(Matricula control);
	public Matricula findOne(Long id);
	public void delete (Long id);

}
