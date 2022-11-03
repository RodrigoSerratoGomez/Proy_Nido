package com.usmp.persistencia.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the PARENTESCO database table.
 * 
 */
@Embeddable
public class ParentescoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ALUMNO_DNIALU", insertable=false, updatable=false)
	private String alumnoDnialu;

	@Column(name="APODERADO_DNIAPON", insertable=false, updatable=false)
	private String apoderadoDniapon;

	public ParentescoPK() {
	}
	public String getAlumnoDnialu() {
		return this.alumnoDnialu;
	}
	public void setAlumnoDnialu(String alumnoDnialu) {
		this.alumnoDnialu = alumnoDnialu;
	}
	public String getApoderadoDniapon() {
		return this.apoderadoDniapon;
	}
	public void setApoderadoDniapon(String apoderadoDniapon) {
		this.apoderadoDniapon = apoderadoDniapon;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ParentescoPK)) {
			return false;
		}
		ParentescoPK castOther = (ParentescoPK)other;
		return 
			this.alumnoDnialu.equals(castOther.alumnoDnialu)
			&& this.apoderadoDniapon.equals(castOther.apoderadoDniapon);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.alumnoDnialu.hashCode();
		hash = hash * prime + this.apoderadoDniapon.hashCode();
		
		return hash;
	}
}