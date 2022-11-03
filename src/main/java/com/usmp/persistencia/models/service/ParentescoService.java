package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.persistencia.models.dao.IParentescoDAO;
import com.usmp.persistencia.models.entities.Parentesco;


@Service
public class ParentescoService implements IParentescoService {
	@Autowired
	private IParentescoDAO parentescoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Parentesco> findAll() {
		return (List<Parentesco>) parentescoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Parentesco parentesco) {
		parentescoDao.save(parentesco);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Parentesco findOne(String id) {
		return parentescoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String id) {
		parentescoDao.deleteById(id);
		
	}
	
	

}
