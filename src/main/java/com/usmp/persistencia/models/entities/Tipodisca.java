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
 * The persistent class for the TIPODISCA database table.
 * 
 */
@Entity
@NamedQuery(name="Tipodisca.findAll", query="SELECT t FROM Tipodisca t")
public class Tipodisca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPODISCA_IDTIPODIS_GENERATOR", sequenceName="SEQ_TIPODISCA",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPODISCA_IDTIPODIS_GENERATOR")
	private Long idtipodis;

	private String nomdisca;

	//bi-directional many-to-one association to Detalledi
	@OneToMany(mappedBy="tipodisca")
	private List<Detalledi> detalledis;

	public Tipodisca() {
	}

	public Long getIdtipodis() {
		return this.idtipodis;
	}

	public void setIdtipodis(Long idtipodis) {
		this.idtipodis = idtipodis;
	}

	public String getNomdisca() {
		return this.nomdisca;
	}

	public void setNomdisca(String nomdisca) {
		this.nomdisca = nomdisca;
	}

	public List<Detalledi> getDetalledis() {
		return this.detalledis;
	}

	public void setDetalledis(List<Detalledi> detalledis) {
		this.detalledis = detalledis;
	}

	public Detalledi addDetalledi(Detalledi detalledi) {
		getDetalledis().add(detalledi);
		detalledi.setTipodisca(this);

		return detalledi;
	}

	public Detalledi removeDetalledi(Detalledi detalledi) {
		getDetalledis().remove(detalledi);
		detalledi.setTipodisca(null);

		return detalledi;
	}

}