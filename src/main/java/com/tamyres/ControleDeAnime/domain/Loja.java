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
public class Loja  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeLoja;
	private Integer codLoja;
	private Double preco;
	
	@OneToMany(mappedBy="loja")
	private List<Pago> midiasPagas = new ArrayList<>();
	
	public Loja() {}
	
	public Loja(Integer id, String nomeLoja, Integer codLoja, Double preco) {
		super();
		this.id = id;
		this.nomeLoja = nomeLoja;
		this.codLoja = codLoja;
		this.preco = preco;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeLoja() {
		return nomeLoja;
	}
	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	public Integer getCodLoja() {
		return codLoja;
	}
	public void setCodLoja(Integer codLoja) {
		this.codLoja = codLoja;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public List<Pago> getMidiasPagas() {
		return midiasPagas;
	}

	public void setMidiasPagas(List<Pago> midiasPagas) {
		this.midiasPagas = midiasPagas;
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
		Loja other = (Loja) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
