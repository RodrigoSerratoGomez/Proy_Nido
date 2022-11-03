package com.usmp.persistencia.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.usmp.persistencia.models.entities.Parentesco;

public interface IParentescoDAO extends PagingAndSortingRepository<Parentesco, String>{
	//mismo tipo dato 
	//fk dniAlu y fk dniApon 
}
