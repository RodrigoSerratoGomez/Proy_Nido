package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.persistencia.models.dao.ITipoteleDAO;
import com.usmp.persistencia.models.entities.Tipotele;

@Service
public class TipoteleService implements ITipoteleService {
	
	@Autowired
	private ITipoteleDAO tipoteleDao;

	@Override
	@Transactional(readOnly = true)
	public List<Tipotele> findAll() {
		return (List<Tipotele>) tipoteleDao.findAll();
	}

	@Override
	@Transactional
	public void save(Tipotele tipotele) {
		tipoteleDao.save(tipotele);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Tipotele findOne(Long id) {
		return tipoteleDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		tipoteleDao.deleteById(id);;
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tipotele> findByNomtipo(String nomtipo) {
		return tipoteleDao.findByNomtipo(nomtipo);
	}
	
	

}
