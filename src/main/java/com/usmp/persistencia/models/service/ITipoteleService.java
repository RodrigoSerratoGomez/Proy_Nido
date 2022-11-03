package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Tipotele;



public interface ITipoteleService {
	public List<Tipotele> findAll();
	public void save(Tipotele tipotele);
	public Tipotele findOne(Long id);
	public void delete (Long id);
	
	public List<Tipotele>  findByNomtipo(String nomtipo);
}
