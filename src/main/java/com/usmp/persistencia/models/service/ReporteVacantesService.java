package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usmp.persistencia.models.dao.IAlumnoDao;
import com.usmp.persistencia.models.entities.ReporteVacantes;

@Service
public class ReporteVacantesService implements IReporteVacantesService {

	@Autowired
	private IAlumnoDao alumnoDao;
 
	@Override
	public List<ReporteVacantes> listaParaReporte1() {
		return alumnoDao.listaParaReporte1();
	}
		
}
