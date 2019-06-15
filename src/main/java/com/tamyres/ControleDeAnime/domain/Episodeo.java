package com.tamyres.ControleDeAnime.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Episodeo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeEpisodeo;
	private String descricao;
	private Integer numEpisodeo;
	private Double duracao;
	
	
	@ManyToOne
	@JoinColumn(name="temporada_id")
	private Temporada temporada;
	
	

	public Episodeo() {	}

	public Episodeo(String nomeEpisodeo, String descricao, Integer numEpisodeo, Double duracao, Integer id) {
		super();
		this.nomeEpisodeo = nomeEpisodeo;
		this.descricao = descricao;
		this.numEpisodeo = numEpisodeo;
		this.duracao = duracao;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEpisodeo() {
		return nomeEpisodeo;
	}

	public void setNomeEpisodeo(String nomeEpisodeo) {
		this.nomeEpisodeo = nomeEpisodeo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNumEpisodeo() {
		return numEpisodeo;
	}

	public void setNumEpisodeo(Integer numEpisodeo) {
		this.numEpisodeo = numEpisodeo;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}
	

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
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
		Episodeo other = (Episodeo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
