package com.usmp.persistencia.models.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotEmpty;


/**
 * The persistent class for the PARENTESCO database table.
 * 
 */
@Entity
@NamedQuery(name="Parentesco.findAll", query="SELECT p FROM Parentesco p")
public class Parentesco implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ParentescoPK id;
	
	//@NotEmpty(message = "El CAMPO es requerido")
	private String relacion;

	private String vivealu;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="ALUMNO_DNIALU", insertable=false, updatable=false)
	private Alumno alumno;

	//bi-directional many-to-one association to Apoderado
	@ManyToOne
	@JoinColumn(name="APODERADO_DNIAPON", insertable=false, updatable=false)
	private Apoderado apoderado;

	public Parentesco() {
	}

	public ParentescoPK getId() {
		return this.id;
	}

	public void setId(ParentescoPK id) {
		this.id = id;
	}

	public String getRelacion() {
		return this.relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public String getVivealu() {
		return this.vivealu;
	}

	public void setVivealu(String vivealu) {
		this.vivealu = vivealu;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Apoderado getApoderado() {
		return this.apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}

}