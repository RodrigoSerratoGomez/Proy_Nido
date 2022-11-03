package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usmp.persistencia.models.dao.IDetalledisDAO;
import com.usmp.persistencia.models.entities.Detalledi;
import com.usmp.persistencia.models.entities.DetallediPK;

@Service
public class DetalledisService implements IDetalledisService {

	@Autowired
	private IDetalledisDAO detalledisDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Detalledi> findAll() {
		return (List<Detalledi>) detalledisDao.findAll();
		
	}

	@Override
	@Transactional
	public void save(Detalledi detalledis) {
		detalledisDao.save(detalledis);
	}

	@Override
	@Transactional(readOnly = true)
	public Detalledi findOne(DetallediPK id) {
		return detalledisDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(DetallediPK id) {
		detalledisDao.deleteById(id);		
	}
	
	

}
