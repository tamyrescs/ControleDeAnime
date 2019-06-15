package com.tamyres.ControleDeAnime.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sequencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private Integer numFilme;
	private Integer qtdFilmes;
	
	@OneToMany(mappedBy="sequencia")
	private List<Filme> filmes = new ArrayList<>();
	
	public Sequencia() {}

	public Sequencia(Integer id, Integer numFilme, Integer qtdFilmes) {
		super();
		this.id = id;
		this.numFilme = numFilme;
		this.qtdFilmes = qtdFilmes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumFilme() {
		return numFilme;
	}

	public void setNumFilme(Integer numFilme) {
		this.numFilme = numFilme;
	}

	public Integer getQtdFilmes() {
		return qtdFilmes;
	}

	public void setQtdFilmes(Integer qtdFilmes) {
		this.qtdFilmes = qtdFilmes;
	}

	
	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
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
		Sequencia other = (Sequencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
