package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.persistencia.models.dao.IReligionDAO;
import com.usmp.persistencia.models.entities.Religion;

@Service
public class ReligionService implements IReligionService{
	
	@Autowired
	private IReligionDAO religionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Religion> findAll() {
		return (List<Religion>) religionDao.findAll();
	}

	@Override
	@Transactional
	public void save(Religion religion) {
		religionDao.save(religion);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Religion findOne(Long id) {
		return religionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		religionDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Religion> findByNomreli(String nomreli) {
		return religionDao.findByNomreli(nomreli);
	}
	
	
	

}
