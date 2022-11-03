package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Apoderado;



public interface IApoderadoService {
	public List<Apoderado> findAll();
	public void save(Apoderado apoderado);
	public Apoderado findOne(String id);
	public void delete (String id);
	public List<Apoderado> findByDniapon(String dni);

}
