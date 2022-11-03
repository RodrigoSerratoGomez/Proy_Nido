package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.persistencia.models.dao.INivelDAO;

import com.usmp.persistencia.models.entities.Nivel;

@Service
public class NivelService implements INivelService{
	@Autowired
	private INivelDAO nivelDao;

	@Override
	@Transactional(readOnly = true)
	public List<Nivel> findAll() {
		return (List<Nivel>) nivelDao.findAll();
	}

	@Override
	@Transactional
	public void save(Nivel nivel) {
		nivelDao.save(nivel);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Nivel findOne(Long id) {
		return nivelDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		nivelDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel> findByNomnivel(String nomnivel) {
		return nivelDao.findByNomnivel(nomnivel);
	}
	
	

}
