package com.usmp.persistencia.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usmp.persistencia.models.dao.IAlumnoDao;
import com.usmp.persistencia.models.entities.Alumno;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoService  implements IAlumnoService{
	@Autowired
	private IAlumnoDao alumnoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		return (List<Alumno>) alumnoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Alumno alumno) {
		alumnoDao.save(alumno);
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findOne(String id) {
		return alumnoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(String id) {
		alumnoDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByDnialu(String dni) {
		return alumnoDao.findByDnialu(dni);
	}
	

}
