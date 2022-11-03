package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Parentesco;



public interface IParentescoService {
	
	public List<Parentesco> findAll();
	public void save(Parentesco parentesco);
	public Parentesco findOne(String id);
	public void delete (String id);
	//public List<Parentesco> findByDni(String dni);

}
