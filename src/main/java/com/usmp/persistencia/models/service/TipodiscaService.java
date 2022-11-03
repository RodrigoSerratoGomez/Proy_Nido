package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.persistencia.models.dao.ITipodiscaDAO;
import com.usmp.persistencia.models.entities.Tipodisca;

@Service
public class TipodiscaService implements ITipodiscaService{
	
	@Autowired
	private ITipodiscaDAO tipodiscaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Tipodisca> findAll() {
		return (List<Tipodisca>) tipodiscaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Tipodisca tipodisca) {
		tipodiscaDao.save(tipodisca);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Tipodisca findOne(Long id) {
		return tipodiscaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		tipodiscaDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tipodisca> findByNomdisca(String nomdisca) {
		return tipodiscaDao.findByNomdisca(nomdisca);
	}
	
	

}
