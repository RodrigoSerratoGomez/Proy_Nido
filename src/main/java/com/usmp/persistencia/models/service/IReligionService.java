package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Religion;



public interface IReligionService {
	
	public List<Religion> findAll();
	public void save(Religion religion);
	public Religion findOne(Long id);
	public void delete (Long id);
	
	public List<Religion> findByNomreli(String nomreli);

}
