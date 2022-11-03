package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Nivel;

public interface INivelService {
	public List<Nivel> findAll();
	public void save(Nivel nivel);
	public Nivel findOne(Long id);
	public void delete (Long id);
	
	public List<Nivel> findByNomnivel(String nomnivel);
	
}
