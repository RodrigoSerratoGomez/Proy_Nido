package com.usmp.persistencia.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the DETALLEDIS database table.
 * 
 */
@Embeddable
public class DetallediPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="TIPODISCA_IDTIPODIS", insertable=false, updatable=false)
	private Long tipodiscaIdtipodis;

	@Column(name="ALUMNO_DNIALU", insertable=false, updatable=false)
	private String alumnoDnialu;

	public DetallediPK() {
	}
	public Long getTipodiscaIdtipodis() {
		return this.tipodiscaIdtipodis;
	}
	public void setTipodiscaIdtipodis(Long tipodiscaIdtipodis) {
		this.tipodiscaIdtipodis = tipodiscaIdtipodis;
	}
	public String getAlumnoDnialu() {
		return this.alumnoDnialu;
	}
	public void setAlumnoDnialu(String alumnoDnialu) {
		this.alumnoDnialu = alumnoDnialu;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallediPK)) {
			return false;
		}
		DetallediPK castOther = (DetallediPK)other;
		return 
			(this.tipodiscaIdtipodis == castOther.tipodiscaIdtipodis)
			&& this.alumnoDnialu.equals(castOther.alumnoDnialu);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.tipodiscaIdtipodis ^ (this.tipodiscaIdtipodis >>> 32)));
		hash = hash * prime + this.alumnoDnialu.hashCode();
		
		return hash;
	}
}