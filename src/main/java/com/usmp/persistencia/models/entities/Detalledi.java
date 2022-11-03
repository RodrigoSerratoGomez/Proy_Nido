package com.usmp.persistencia.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the DETALLEDIS database table.
 * 
 */
@Entity
@Table(name="DETALLEDIS")
@NamedQuery(name="Detalledi.findAll", query="SELECT d FROM Detalledi d")
public class Detalledi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallediPK id;

	private String observaciones;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="ALUMNO_DNIALU", insertable=false, updatable=false)
	private Alumno alumno;

	//bi-directional many-to-one association to Tipodisca
	@ManyToOne
	@JoinColumn(name="TIPODISCA_IDTIPODIS", insertable=false, updatable=false)
	private Tipodisca tipodisca;

	public Detalledi() {
	}

	public DetallediPK getId() {
		return this.id;
	}

	public void setId(DetallediPK id) {
		this.id = id;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Tipodisca getTipodisca() {
		return this.tipodisca;
	}

	public void setTipodisca(Tipodisca tipodisca) {
		this.tipodisca = tipodisca;
	}

}