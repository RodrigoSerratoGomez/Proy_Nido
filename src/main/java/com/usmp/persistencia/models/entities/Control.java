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


/**
 * The persistent class for the CONTROL database table.
 * 
 */
@Entity
@NamedQuery(name="Control.findAll", query="SELECT c FROM Control c")
public class Control implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTROL_IDCONTROL_GENERATOR", sequenceName="SEQ_CONTROL",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTROL_IDCONTROL_GENERATOR")
	private Long idcontrol;

	private String alergias;

	private Timestamp fecha;
	
	private Double peso;

	private Double talla;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	private Alumno alumno;

	 @Transient
	 private String fecnacTxt;


	public String getFecnacTxt() {
		return fecnacTxt;
	}

	public void setFecnacTxt(String fecnacTxt) {
		this.fecnacTxt = fecnacTxt;
	}

	public Control() {
	}

	public Long getIdcontrol() {
		return this.idcontrol;
	}

	public void setIdcontrol(Long idcontrol) {
		this.idcontrol = idcontrol;
	}

	public String getAlergias() {
		return this.alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Double getPeso() {
		return this.peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getTalla() {
		return this.talla;
	}

	public void setTalla(Double talla) {
		this.talla = talla;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}