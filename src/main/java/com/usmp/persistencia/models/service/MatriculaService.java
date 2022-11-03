package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.persistencia.models.dao.IMatriculaDAO;
import com.usmp.persistencia.models.entities.Matricula;



@Service
public class MatriculaService implements IMatriculaService {
	@Autowired
	private IMatriculaDAO matriculaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Matricula> findAll() {
		return (List<Matricula>) matriculaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Matricula control) {
		matriculaDao.save(control);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Matricula findOne(Long id) {
		return matriculaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		matriculaDao.deleteById(id);
		
	}
	
	

}
