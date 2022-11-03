package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Detalledi;
import com.usmp.persistencia.models.entities.DetallediPK;



public interface IDetalledisService {
	public List<Detalledi> findAll();
	public void save(Detalledi detalledis);
	public Detalledi findOne(DetallediPK id);
	public void delete (DetallediPK id);
	
}
