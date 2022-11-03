package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Tipodisca;



public interface ITipodiscaService {
	public List<Tipodisca> findAll();
	public void save(Tipodisca tipodisca);
	public Tipodisca findOne(Long id);
	public void delete (Long id);
	
	public List<Tipodisca> findByNomdisca(String nomdisca);
}
