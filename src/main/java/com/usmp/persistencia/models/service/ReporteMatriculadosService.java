package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usmp.persistencia.models.dao.IAlumnoDao;
import com.usmp.persistencia.models.entities.ReporteMatriculados;

@Service
public class ReporteMatriculadosService implements IReporteMatriculadosService {

	@Autowired
	private IAlumnoDao alumnoDao;
 
	@Override
	public List<ReporteMatriculados> listaParaReporte() {
		return alumnoDao.listaParaReporte();
	}
		
}
