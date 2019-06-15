package com.tamyres.ControleDeAnime.dto;

import java.io.Serializable;

import com.tamyres.ControleDeAnime.domain.ListaDesejo;

public class ListaDesejoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;


	public ListaDesejoDTO() {
	}

	public ListaDesejoDTO(ListaDesejo obj) {
		id = obj.getId();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}