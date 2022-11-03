package com.usmp.persistencia.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the NUMERO database table.
 * 
 */
@Embeddable
public class NumeroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="APODERADO_DNIAPON", insertable=false, updatable=false)
	private String apoderadoDniapon;

	@Column(name="TIPOTELE_IDTELE", insertable=false, updatable=false)
	private Long tipoteleIdtele;

	public NumeroPK() {
	}
	public String getApoderadoDniapon() {
		return this.apoderadoDniapon;
	}
	public void setApoderadoDniapon(String apoderadoDniapon) {
		this.apoderadoDniapon = apoderadoDniapon;
	}
	public Long getTipoteleIdtele() {
		return this.tipoteleIdtele;
	}
	public void setTipoteleIdtele(Long tipoteleIdtele) {
		this.tipoteleIdtele = tipoteleIdtele;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NumeroPK)) {
			return false;
		}
		NumeroPK castOther = (NumeroPK)other;
		return 
			this.apoderadoDniapon.equals(castOther.apoderadoDniapon)
			&& (this.tipoteleIdtele == castOther.tipoteleIdtele);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.apoderadoDniapon.hashCode();
		hash = hash * prime + ((int) (this.tipoteleIdtele ^ (this.tipoteleIdtele >>> 32)));
		
		return hash;
	}
}