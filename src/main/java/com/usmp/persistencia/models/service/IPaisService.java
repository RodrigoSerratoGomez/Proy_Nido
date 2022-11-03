package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Pai;



public interface IPaisService {
	public List<Pai> findAll();
	public void save(Pai pais);
	public Pai findOne(Long id);
	public void delete (Long id);
	
	public List<Pai> findByNompais(String nompais);
}
