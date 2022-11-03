package com.usmp.persistencia.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Subselect;

//@Entity
//@Subselect("SELECT  TO_CHAR(M.FECMATRI,'YYYY') AS AÑO, N.NOMNIVEL,  COUNT (TO_CHAR(M.FECMATRI,'YYYY')) AS \"CANTIDAD MATRICULADOS\" FROM MATRICULA M, NIVEL N WHERE M.NIVEL_IDNIVEL = N.IDNIVEL GROUP BY N.NOMNIVEL, TO_CHAR(M.FECMATRI,'YYYY') ORDER BY TO_CHAR(M.FECMATRI,'YYYY')")
public class REPORTE_MATRICULADOS {
	//@Id
	//@Column(insertable = false, updatable = false)
	private String anio;
	
//	private String nomnivel;
//		@OneToOne
//		@JoinColumn(name = "matricula", insertable = false, updatable = false)
	private Matricula matricula;
	
	/*«insertable» y «updatable» a false, ya que en
	teoría es una vista y no tendremos que insertar ni 
	actualizar nada en ella.
	 */
//		@OneToOne
//		@JoinColumn(name = "nivel", insertable = false, updatable = false)
	private Nivel nivel;
	
//		@Column(insertable = false, updatable = false)
	private Integer cantidad_matriculados;
	
	public REPORTE_MATRICULADOS() {
		super();
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Integer getCantidad_matriculados() {
		return cantidad_matriculados;
	}

	public void setCantidad_matriculados(Integer cantidad_matriculados) {
		this.cantidad_matriculados = cantidad_matriculados;
	}

	
	
	
	
}
