package com.usmp.persistencia.models.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**
 * The persistent class for the NUMERO database table.
 * 
 */
@Entity
@NamedQuery(name="Numero.findAll", query="SELECT n FROM Numero n")
public class Numero implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NumeroPK id;
	
	@NotEmpty(message = "El NUMERO es requerido")
	@Size(min = 9, max = 9, message = "El NUMERO del debe tener 9 caracteres")
	@Digits(fraction = 0, integer = 9, message = "Solo se aceptan numeros")
	
	private String numero;

	private String operador;

	//bi-directional many-to-one association to Apoderado
	@ManyToOne
	@JoinColumn(name="APODERADO_DNIAPON", insertable=false, updatable=false)
	private Apoderado apoderado;

	//bi-directional many-to-one association to Tipotele
	@ManyToOne
	@JoinColumn(name="TIPOTELE_IDTELE", insertable=false, updatable=false)
	private Tipotele tipotele;

	public Numero() {
	}

	public NumeroPK getId() {
		return this.id;
	}

	public void setId(NumeroPK id) {
		this.id = id;
	}

	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOperador() {
		return this.operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public Apoderado getApoderado() {
		return this.apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}

	public Tipotele getTipotele() {
		return this.tipotele;
	}

	public void setTipotele(Tipotele tipotele) {
		this.tipotele = tipotele;
	}

}