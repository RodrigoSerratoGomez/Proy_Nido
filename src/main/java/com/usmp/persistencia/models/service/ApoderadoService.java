package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.usmp.persistencia.models.dao.IApoderadoDAO;

import com.usmp.persistencia.models.entities.Apoderado;


@Service
public class ApoderadoService implements IApoderadoService{
	@Autowired
	private IApoderadoDAO apoderadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Apoderado> findAll() {
		return (List<Apoderado>) apoderadoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Apoderado apoderado) {
		apoderadoDao.save(apoderado);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Apoderado findOne(String id) {
		return apoderadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String id) {
		apoderadoDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Apoderado> findByDniapon(String dni) {
		return apoderadoDao.findByDniapon(dni);
	}

	
	
	

}
