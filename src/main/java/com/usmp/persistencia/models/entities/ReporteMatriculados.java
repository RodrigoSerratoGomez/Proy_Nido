package com.usmp.persistencia.models.entities;

public class ReporteMatriculados {

	private String anio;
	private String nomNivel;
	private Integer cantidadMatriculados;
	
	public ReporteMatriculados() {
		super();
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getNomNivel() {
		return nomNivel;
	}

	public void setNomNivel(String nomNivel) {
		this.nomNivel = nomNivel;
	}

	public Integer getCantidadMatriculados() {
		return cantidadMatriculados;
	}

	public void setCantidadMatriculados(Integer cantidadMatriculados) {
		this.cantidadMatriculados = cantidadMatriculados;
	}

	
}