package com.usmp.persistencia.models.dao;

import java.util.List;

import com.usmp.persistencia.models.entities.entitiesBORRAR.ReporteMatriculados;

public interface CustomIAlumnoDao {
	
	//colocamos en el Custom la lista a retornar
	public List<ReporteMatriculados> listaParaReporte();
	
}