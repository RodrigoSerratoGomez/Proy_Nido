package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Control;



public interface IControlService {
	public List<Control> findAll();
	public void save(Control control);
	public Control findOne(Long id);
	public void delete (Long id);
}
