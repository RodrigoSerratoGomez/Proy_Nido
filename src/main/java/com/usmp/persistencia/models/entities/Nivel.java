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
 * The persistent class for the NIVEL database table.
 * 
 */
@Entity
@NamedQuery(name="Nivel.findAll", query="SELECT n FROM Nivel n")
public class Nivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NIVEL_IDNIVEL_GENERATOR", sequenceName="SEQ_NIVEL",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NIVEL_IDNIVEL_GENERATOR")
	private Long idnivel;

	private String nomnivel;

	//bi-directional many-to-one association to Matricula
	@OneToMany(mappedBy="nivel")
	private List<Matricula> matriculas;

	public Nivel() {
	}

	public Long getIdnivel() {
		return this.idnivel;
	}

	public void setIdnivel(Long idnivel) {
		this.idnivel = idnivel;
	}

	public String getNomnivel() {
		return this.nomnivel;
	}

	public void setNomnivel(String nomnivel) {
		this.nomnivel = nomnivel;
	}

	public List<Matricula> getMatriculas() {
		return this.matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Matricula addMatricula(Matricula matricula) {
		getMatriculas().add(matricula);
		matricula.setNivel(this);

		return matricula;
	}

	public Matricula removeMatricula(Matricula matricula) {
		getMatriculas().remove(matricula);
		matricula.setNivel(null);

		return matricula;
	}

}