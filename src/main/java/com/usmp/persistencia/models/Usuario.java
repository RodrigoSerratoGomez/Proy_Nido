package com.usmp.persistencia.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="USUARIO_IDUSU_GENERATOR", sequenceName="SEQ_USUARIO",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_IDUSU_GENERATOR")
	private Long IDUSU;
	private String NOMUSU;
	private String CONUSU;
	
	public Usuario() {
	}

	public Long getIDUSU() {
		return IDUSU;
	}

	public void setIDUSU(Long iDUSU) {
		IDUSU = iDUSU;
	}

	public String getNOMUSU() {
		return NOMUSU;
	}

	public void setNOMUSU(String nOMUSU) {
		NOMUSU = nOMUSU;
	}

	public String getCONUSU() {
		return CONUSU;
	}

	public void setCONUSU(String cONUSU) {
		CONUSU = cONUSU;
	}
		
}