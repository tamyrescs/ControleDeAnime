package com.tamyres.ControleDeAnime.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Filme extends Midia {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name ="sequencia_id")
	private Sequencia sequencia;
	
	
	public Filme(Integer id, String nomeMidia, String qualidade, String legenda, String direcao, String elenco,
			Date dataLancamento, Usuario usuario, Avaliacao avaliacao) {
		super(id, nomeMidia, qualidade, legenda, direcao, elenco, dataLancamento, usuario, avaliacao);
		// TODO Auto-generated constructor stub
	}


	public Sequencia getSequencia() {
		return sequencia;
	}


	public void setSequencia(Sequencia sequencia) {
		this.sequencia = sequencia;
	}
	
	
	
}
