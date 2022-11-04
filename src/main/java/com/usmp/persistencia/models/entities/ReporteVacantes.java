package com.usmp.persistencia.models.entities;

public class ReporteVacantes {


	private String nomNivel;
	private Integer vacantesOfertadas;
	private Integer vacantesDisponibles;
	
	public ReporteVacantes() {
		super();
	}



	public String getNomNivel() {
		return nomNivel;
	}

	public void setNomNivel(String nomNivel) {
		this.nomNivel = nomNivel;
	}



	public Integer getVacantesOfertadas() {
		return vacantesOfertadas;
	}



	public void setVacantesOfertadas(Integer vacantesOfertadas) {
		this.vacantesOfertadas = 30;
	}


	public Integer getVacantesDisponibles() {
		return vacantesDisponibles;
	}



	public void setVacantesDisponibles(Integer vacantesDisponibles) {
		this.vacantesDisponibles = vacantesDisponibles;
	}

	
	
}