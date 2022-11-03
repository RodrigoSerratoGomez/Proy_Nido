package com.usmp.persistencia.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.usmp.persistencia.models.entities.Religion;

public interface IReligionDAO extends PagingAndSortingRepository<Religion, Long> {
	public List<Religion> findByNomreli(String nomreli);
}
