package com.usmp.persistencia.models.service;

import java.util.List;

import com.usmp.persistencia.models.entities.Numero;
import com.usmp.persistencia.models.entities.NumeroPK;



public interface INumeroService {
	public List<Numero> findAll();
	public void save(Numero numero);
	//numero tiene pk compuesta fk dniAponderado y fk idTele
	public Numero findOne(NumeroPK id);
	public void delete (NumeroPK id);
}
