package com.usmp.persistencia.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the RELIGION database table.
 * 
 */
@Entity
@NamedQuery(name="Religion.findAll", query="SELECT r FROM Religion r")
public class Religion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RELIGION_IDRELI_GENERATOR", sequenceName="SEQ_RELIGION",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RELIGION_IDRELI_GENERATOR")
	private Long idreli;

	private String nomreli;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="religion")
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to Apoderado
	@OneToMany(mappedBy="religion")
	private List<Apoderado> apoderados;

	public Religion() {
	}

	public Long getIdreli() {
		return this.idreli;
	}

	public void setIdreli(Long idreli) {
		this.idreli = idreli;
	}

	public String getNomreli() {
		return this.nomreli;
	}

	public void setNomreli(String nomreli) {
		this.nomreli = nomreli;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno addAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
		alumno.setReligion(this);

		return alumno;
	}

	public Alumno removeAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
		alumno.setReligion(null);

		return alumno;
	}

	public List<Apoderado> getApoderados() {
		return this.apoderados;
	}

	public void setApoderados(List<Apoderado> apoderados) {
		this.apoderados = apoderados;
	}

	public Apoderado addApoderado(Apoderado apoderado) {
		getApoderados().add(apoderado);
		apoderado.setReligion(this);

		return apoderado;
	}

	public Apoderado removeApoderado(Apoderado apoderado) {
		getApoderados().remove(apoderado);
		apoderado.setReligion(null);

		return apoderado;
	}

}