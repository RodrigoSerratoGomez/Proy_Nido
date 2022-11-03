package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.persistencia.models.dao.INumeroDAO;
import com.usmp.persistencia.models.entities.Numero;
import com.usmp.persistencia.models.entities.NumeroPK;

@Service
public class NumeroService implements INumeroService{
	
	@Autowired
	private INumeroDAO numeroDao;
		
	@Override
	@Transactional(readOnly = true)
	public List<Numero> findAll() {
		return (List<Numero>) numeroDao.findAll();
	}

	@Override
	@Transactional
	public void save(Numero numero) {
		numeroDao.save(numero);		
	}

	@Override
	@Transactional(readOnly = true)
	public Numero findOne(NumeroPK id) {
		return numeroDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(NumeroPK id) {
		numeroDao.deleteById(id);
		
	}
	
	

}
