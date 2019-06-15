package com.tamyres.ControleDeAnime.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Serie extends Midia{
	
	
	private static final long serialVersionUID = 1L;
	private Integer qtdTemporadas;
	
	@OneToMany(mappedBy="serie")
	private List<Temporada> temporadas = new ArrayList<>();
	
	public Serie() {}
	
	public Serie(Integer id, String nomeMidia, String qualidade, String legenda, String direcao, String elenco,
			Date dataLancamento, Integer qtdTemporadas, Usuario usuario, Avaliacao avaliacao) {
		super(id, nomeMidia, qualidade, legenda, direcao, elenco, dataLancamento, usuario, avaliacao); 
		this.qtdTemporadas = qtdTemporadas;
	}
	
	public Integer getQtdTemporadas() {
		return qtdTemporadas;
	}
	public void setQtdTemporadas(Integer qtdTemporadas) {
		this.qtdTemporadas = qtdTemporadas;
	}

	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}
	
	
}
