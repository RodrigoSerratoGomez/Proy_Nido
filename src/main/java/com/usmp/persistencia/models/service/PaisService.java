package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.persistencia.models.dao.IPaisDAO;
import com.usmp.persistencia.models.entities.Pai;



@Service
public class PaisService implements IPaisService{
	@Autowired
	private IPaisDAO paisDao;

	@Override
	@Transactional(readOnly = true)
	public List<Pai> findAll() {
		return (List<Pai>) paisDao.findAll();
	}

	@Override
	@Transactional
	public void save(Pai pais) {
		paisDao.save(pais);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Pai findOne(Long id) {
		return paisDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		paisDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pai> findByNompais(String nompais) {
		return paisDao.findByNompais(nompais);
	}
	

}
