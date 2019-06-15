package com.tamyres.ControleDeAnime.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Avaliacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String comentario;
	private Integer qtdEstrelas;

	@OneToMany(mappedBy="avaliacao")
	private Midia midia;
	
	
	/*@ManyToOne
	@JoinColumn(name = "midia_id")
	private Midia midia;*/
	
	

	public Avaliacao() {
	}

	public Avaliacao(Integer id, String comentario, Integer qtdEstrelas) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.qtdEstrelas = qtdEstrelas;
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

	public Midia getMidia() {
		return midia;
	}

	public void setMidia(Midia midia) {
		this.midia = midia;
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
		Avaliacao other = (Avaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
