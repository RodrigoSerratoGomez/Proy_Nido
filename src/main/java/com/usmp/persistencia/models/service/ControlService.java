package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.persistencia.models.dao.IControlDAO;

import com.usmp.persistencia.models.entities.Control;



@Service
public class ControlService implements IControlService {
	
	@Autowired
	private IControlDAO controlDao;

	@Override
	@Transactional(readOnly = true)
	public List<Control> findAll() {
		return (List<Control>) controlDao.findAll();
	}

	@Override
	@Transactional
	public void save(Control control) {
		controlDao.save(control);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Control findOne(Long id) {
		return controlDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		controlDao.deleteById(id);
		
	}
	
	

}
