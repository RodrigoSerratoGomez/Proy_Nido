package com.usmp.persistencia.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.usmp.persistencia.models.entities.entitiesBORRAR.Control;
import com.usmp.persistencia.models.entities.entitiesBORRAR.Detalledi;
import com.usmp.persistencia.models.entities.entitiesBORRAR.Matricula;
import com.usmp.persistencia.models.entities.entitiesBORRAR.Pai;
import com.usmp.persistencia.models.entities.entitiesBORRAR.Parentesco;
import com.usmp.persistencia.models.entities.entitiesBORRAR.Religion;


/**
 * The persistent class for the ALUMNO database table.
 * 
 */
@Entity
@NamedQuery(name="Alumno.findAll", query="SELECT a FROM Alumno a")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty(message = "El DNI es requerido")
	@Size(min = 8, max = 8, message = "El DNI del debe tener 8 caracteres")
	@Digits(fraction = 0, integer = 8, message = "Solo se aceptan numeros")
	private String dnialu;

	@NotEmpty(message = "El APELLIDO del es requerido")
	private String apealu;

	@NotEmpty(message = "El CAMPO es requerido")
	private String asegurado;

	@NotEmpty(message = "La DIRECCION del es requerido")
	private String direcalu;

	private Timestamp fecnac;

	@NotEmpty(message = "El CAMPO es requerido")
	private String lenguamater;
	@NotEmpty(message = "El CAMPO es requerido")
	private String lugarnac;

	private String lugarseguro;
	
	@NotEmpty(message = "El NOMBRE es requerido")
	private String nomalu;

	private Double numherma;

	private String segunlengua;

	@NotEmpty(message = "El SEXO del es requerido")
	@Size(min = 1, max = 1, message = "El SEXO es F o M")
	private String sexo;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="PAIS_IDPAIS")
	private Pai pai;

	//bi-directional many-to-one association to Religion
	@ManyToOne
	private Religion religion;

	//bi-directional many-to-one association to Control
	@OneToMany(mappedBy="alumno")
	private List<Control> controls;

	//bi-directional many-to-one association to Detalledi
	@OneToMany(mappedBy="alumno")
	private List<Detalledi> detalledis;

	//bi-directional many-to-one association to Matricula
	@OneToMany(mappedBy="alumno")
	private List<Matricula> matriculas;

	//bi-directional many-to-one association to Parentesco
	@OneToMany(mappedBy="alumno")
	private List<Parentesco> parentescos;

	@Transient
	private String fecnacTxt;
	 
	public Alumno() {
	}

	public String getDnialu() {
		return this.dnialu;
	}

	public void setDnialu(String dnialu) {
		this.dnialu = dnialu;
	}

	public String getApealu() {
		return this.apealu;
	}

	public void setApealu(String apealu) {
		this.apealu = apealu;
	}

	public String getAsegurado() {
		return this.asegurado;
	}

	public void setAsegurado(String asegurado) {
		this.asegurado = asegurado;
	}

	public String getDirecalu() {
		return this.direcalu;
	}

	public void setDirecalu(String direcalu) {
		this.direcalu = direcalu;
	}

	public Timestamp getFecnac() {
		return this.fecnac;
	}

	public void setFecnac(Timestamp fecnac) {
		this.fecnac = fecnac;
	}

	public String getLenguamater() {
		return this.lenguamater;
	}

	public void setLenguamater(String lenguamater) {
		this.lenguamater = lenguamater;
	}

	public String getLugarnac() {
		return this.lugarnac;
	}

	public void setLugarnac(String lugarnac) {
		this.lugarnac = lugarnac;
	}

	public String getLugarseguro() {
		return this.lugarseguro;
	}

	public void setLugarseguro(String lugarseguro) {
		this.lugarseguro = lugarseguro;
	}

	public String getNomalu() {
		return this.nomalu;
	}

	public void setNomalu(String nomalu) {
		this.nomalu = nomalu;
	}

	public Double getNumherma() {
		return this.numherma;
	}

	public void setNumherma(Double numherma) {
		this.numherma = numherma;
	}

	public String getSegunlengua() {
		return this.segunlengua;
	}

	public void setSegunlengua(String segunlengua) {
		this.segunlengua = segunlengua;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Pai getPai() {
		return this.pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}

	public Religion getReligion() {
		return this.religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public List<Control> getControls() {
		return this.controls;
	}

	public void setControls(List<Control> controls) {
		this.controls = controls;
	}

	public Control addControl(Control control) {
		getControls().add(control);
		control.setAlumno(this);

		return control;
	}

	public Control removeControl(Control control) {
		getControls().remove(control);
		control.setAlumno(null);

		return control;
	}

	public List<Detalledi> getDetalledis() {
		return this.detalledis;
	}

	public void setDetalledis(List<Detalledi> detalledis) {
		this.detalledis = detalledis;
	}

	public Detalledi addDetalledi(Detalledi detalledi) {
		getDetalledis().add(detalledi);
		detalledi.setAlumno(this);

		return detalledi;
	}

	public Detalledi removeDetalledi(Detalledi detalledi) {
		getDetalledis().remove(detalledi);
		detalledi.setAlumno(null);

		return detalledi;
	}

	public List<Matricula> getMatriculas() {
		return this.matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Matricula addMatricula(Matricula matricula) {
		getMatriculas().add(matricula);
		matricula.setAlumno(this);

		return matricula;
	}

	public Matricula removeMatricula(Matricula matricula) {
		getMatriculas().remove(matricula);
		matricula.setAlumno(null);

		return matricula;
	}

	public List<Parentesco> getParentescos() {
		return this.parentescos;
	}

	public void setParentescos(List<Parentesco> parentescos) {
		this.parentescos = parentescos;
	}

	public Parentesco addParentesco(Parentesco parentesco) {
		getParentescos().add(parentesco);
		parentesco.setAlumno(this);

		return parentesco;
	}

	public Parentesco removeParentesco(Parentesco parentesco) {
		getParentescos().remove(parentesco);
		parentesco.setAlumno(null);

		return parentesco;
	}

	public String getFecnacTxt() {
		return fecnacTxt;
	}

	public void setFecnacTxt(String fecnacTxt) {
		this.fecnacTxt = fecnacTxt;
	}

}