package com.usmp.persistencia.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * The persistent class for the APODERADO database table.
 * 
 */
@Entity
@NamedQuery(name="Apoderado.findAll", query="SELECT a FROM Apoderado a")
public class Apoderado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@NotEmpty(message = "El DNI es requerido")
	@Size(min = 8, max = 8, message = "El DNI del debe tener 8 caracteres")
	@Digits(fraction = 0, integer = 8, message = "Solo se aceptan numeros")
	private String dniapon;

	@NotEmpty(message = "El APELLIDO del es requerido")
	private String apeapon;

	@NotEmpty(message = "El CAMPO es requerido")
	private String correo;

	@NotEmpty(message = "El CAMPO es requerido")
	private String direccion;

	private Timestamp fecnacapon;
	
	 @Transient
	    private String fecnacTxt;

	private String gradoinstruc;

	@NotEmpty(message = "El NOMBRE es requerido")
	private String nomapon;

	@NotEmpty(message = "El CAMPO es requerido")
	private String ocupacion;

	@NotEmpty(message = "El SEXO del es requerido")
	@Size(min = 1, max = 1, message = "El SEXO es F o M")
	private String sexo;
	
	//@NotEmpty(message = "El CAMPO es requerido")
	private Double sueldomen;

	//bi-directional many-to-one association to Religion
	@ManyToOne
	private Religion religion;

	//bi-directional many-to-one association to Numero
	@OneToMany(mappedBy="apoderado")
	private List<Numero> numeros;

	//bi-directional many-to-one association to Parentesco
	@OneToMany(mappedBy="apoderado")
	private List<Parentesco> parentescos;

	public Apoderado() {
	}

	public String getDniapon() {
		return this.dniapon;
	}

	public void setDniapon(String dniapon) {
		this.dniapon = dniapon;
	}

	public String getApeapon() {
		return this.apeapon;
	}

	public void setApeapon(String apeapon) {
		this.apeapon = apeapon;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Timestamp getFecnacapon() {
		return this.fecnacapon;
	}

	public void setFecnacapon(Timestamp fecnacapon) {
		this.fecnacapon = fecnacapon;
	}

	public String getGradoinstruc() {
		return this.gradoinstruc;
	}

	public void setGradoinstruc(String gradoinstruc) {
		this.gradoinstruc = gradoinstruc;
	}

	public String getNomapon() {
		return this.nomapon;
	}

	public void setNomapon(String nomapon) {
		this.nomapon = nomapon;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Double getSueldomen() {
		return this.sueldomen;
	}

	public void setSueldomen(Double sueldomen) {
		this.sueldomen = sueldomen;
	}

	public Religion getReligion() {
		return this.religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public List<Numero> getNumeros() {
		return this.numeros;
	}

	public void setNumeros(List<Numero> numeros) {
		this.numeros = numeros;
	}

	public Numero addNumero(Numero numero) {
		getNumeros().add(numero);
		numero.setApoderado(this);

		return numero;
	}

	public Numero removeNumero(Numero numero) {
		getNumeros().remove(numero);
		numero.setApoderado(null);

		return numero;
	}

	public List<Parentesco> getParentescos() {
		return this.parentescos;
	}

	public void setParentescos(List<Parentesco> parentescos) {
		this.parentescos = parentescos;
	}

	public Parentesco addParentesco(Parentesco parentesco) {
		getParentescos().add(parentesco);
		parentesco.setApoderado(this);

		return parentesco;
	}

	public Parentesco removeParentesco(Parentesco parentesco) {
		getParentescos().remove(parentesco);
		parentesco.setApoderado(null);

		return parentesco;
	}

	public String getFecnacTxt() {
		return fecnacTxt;
	}

	public void setFecnacTxt(String fecnacTxt) {
		this.fecnacTxt = fecnacTxt;
	}

}