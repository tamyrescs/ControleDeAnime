package com.tamyres.ControleDeAnime.dto;

import java.io.Serializable;

import com.tamyres.ControleDeAnime.domain.Avaliacao;

public class AvaliacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String comentario;
	private Integer qtdEstrelas;

	public AvaliacaoDTO() {
	}

	public AvaliacaoDTO(Avaliacao obj) {
		id= obj.getId();
		comentario = obj.getComentario();
		qtdEstrelas = obj.getQtdEstrelas();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Integer getQtdEstrelas() {
		return qtdEstrelas;
	}

	public void setQtdEstrelas(Integer qtdEstrelas) {
		this.qtdEstrelas = qtdEstrelas;
	}

	
}
