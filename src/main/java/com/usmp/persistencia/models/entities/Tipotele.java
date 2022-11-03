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
 * The persistent class for the TIPOTELE database table.
 * 
 */
@Entity
@NamedQuery(name="Tipotele.findAll", query="SELECT t FROM Tipotele t")
public class Tipotele implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPOTELE_IDTELE_GENERATOR", sequenceName="SEQ_TIPOTELE",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPOTELE_IDTELE_GENERATOR")
	private Long idtele;

	private String nomtipo;

	//bi-directional many-to-one association to Numero
	@OneToMany(mappedBy="tipotele")
	private List<Numero> numeros;

	public Tipotele() {
	}

	public Long getIdtele() {
		return this.idtele;
	}

	public void setIdtele(Long idtele) {
		this.idtele = idtele;
	}

	public String getNomtipo() {
		return this.nomtipo;
	}

	public void setNomtipo(String nomtipo) {
		this.nomtipo = nomtipo;
	}

	public List<Numero> getNumeros() {
		return this.numeros;
	}

	public void setNumeros(List<Numero> numeros) {
		this.numeros = numeros;
	}

	public Numero addNumero(Numero numero) {
		getNumeros().add(numero);
		numero.setTipotele(this);

		return numero;
	}

	public Numero removeNumero(Numero numero) {
		getNumeros().remove(numero);
		numero.setTipotele(null);

		return numero;
	}

}