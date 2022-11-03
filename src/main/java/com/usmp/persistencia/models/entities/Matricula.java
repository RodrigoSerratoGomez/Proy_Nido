package com.usmp.persistencia.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;


/**
 * The persistent class for the MATRICULA database table.
 * 
 */
@Entity
@NamedQuery(name="Matricula.findAll", query="SELECT m FROM Matricula m")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MATRICULA_IDMATRI_GENERATOR", sequenceName="SEQ_MATRICULA",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MATRICULA_IDMATRI_GENERATOR")
	private Long idmatri;
	
	
	private Timestamp fecmatri;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	private Alumno alumno;

	//bi-directional many-to-one association to Nivel
	@ManyToOne
	private Nivel nivel;

	public Matricula() {
	}
	
	//@NotEmpty(message = "El CAMPO es requerido")
	@Transient
	 private String fecnacTxt;


	public String getFecnacTxt() {
		return fecnacTxt;
	}

	public void setFecnacTxt(String fecnacTxt) {
		this.fecnacTxt = fecnacTxt;
	}
	
	public Long getIdmatri() {
		return this.idmatri;
	}

	public void setIdmatri(Long idmatri) {
		this.idmatri = idmatri;
	}

	public Timestamp getFecmatri() {
		return this.fecmatri;
	}

	public void setFecmatri(Timestamp fecmatri) {
		this.fecmatri = fecmatri;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

}