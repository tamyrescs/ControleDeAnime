package com.tamyres.ControleDeAnime.dto;

import java.io.Serializable;

import com.tamyres.ControleDeAnime.domain.Midia;

public class MidiaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nomeMidia;

	private String legenda;

	public MidiaDTO() {
	}

	public MidiaDTO(Midia obj) {
		id = obj.getId();
		nomeMidia = obj.getNomeMidia();
		legenda = obj.getLegenda();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeMidia() {
		return nomeMidia;
	}

	public void setNomeMidia(String nomeMidia) {
		this.nomeMidia = nomeMidia;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

}
