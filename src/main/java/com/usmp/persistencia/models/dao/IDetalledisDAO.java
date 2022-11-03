package com.usmp.persistencia.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.usmp.persistencia.models.entities.Detalledi;
import com.usmp.persistencia.models.entities.DetallediPK; 


public interface IDetalledisDAO extends PagingAndSortingRepository<Detalledi, DetallediPK>{

}
