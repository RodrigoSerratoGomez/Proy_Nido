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
import javax.persistence.Table;


/**
 * The persistent class for the PAIS database table.
 * 
 */
@Entity
@Table(name="PAIS")
@NamedQuery(name="Pai.findAll", query="SELECT p FROM Pai p")
public class Pai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAIS_IDPAIS_GENERATOR", sequenceName="SEQ_PAIS",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAIS_IDPAIS_GENERATOR")
	private Long idpais;

	private String nompais;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="pai")
	private List<Alumno> alumnos;

	public Pai() {
	}

	public Long getIdpais() {
		return this.idpais;
	}

	public void setIdpais(Long idpais) {
		this.idpais = idpais;
	}

	public String getNompais() {
		return this.nompais;
	}

	public void setNompais(String nompais) {
		this.nompais = nompais;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno addAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
		alumno.setPai(this);

		return alumno;
	}

	public Alumno removeAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
		alumno.setPai(null);

		return alumno;
	}

}