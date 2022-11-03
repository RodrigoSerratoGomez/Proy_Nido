package com.usmp.persistencia.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.usmp.persistencia.models.entities.Numero;
import com.usmp.persistencia.models.entities.NumeroPK;

public interface INumeroDAO extends PagingAndSortingRepository<Numero, NumeroPK>{
	//numero tiene pk compuesta fk dniAponderado y fk idTele
}

