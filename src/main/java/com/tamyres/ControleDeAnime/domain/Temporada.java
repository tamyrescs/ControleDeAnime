package com.tamyres.ControleDeAnime.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Temporada implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numTemporada;
	
	@JsonFormat (pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataLancamentoTemp;
	
	@ManyToOne
	@JoinColumn(name="serie_id")
	private Serie serie;
	
	@OneToMany(mappedBy="temporada")
	private List<Episodeo> episodeos = new ArrayList<>();
	
	public Temporada() {}

	public Temporada(Integer id, Integer numTemporada, Date dataLancamentoTemp) {
		super();
		this.id = id;
		this.numTemporada = numTemporada;
		this.dataLancamentoTemp = dataLancamentoTemp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumTemporada() {
		return numTemporada;
	}

	public void setNumTemporada(Integer numTemporada) {
		this.numTemporada = numTemporada;
	}

	public Date getDataLancamentoTemp() {
		return dataLancamentoTemp;
	}

	public void setDataLancamentoTemp(Date dataLancamentoTemp) {
		this.dataLancamentoTemp = dataLancamentoTemp;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public List<Episodeo> getEpisodeos() {
		return episodeos;
	}

	public void setEpisodeos(List<Episodeo> episodeos) {
		this.episodeos = episodeos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temporada other = (Temporada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
