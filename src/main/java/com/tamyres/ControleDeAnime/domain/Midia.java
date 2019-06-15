package com.tamyres.ControleDeAnime.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Midia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeMidia;
	private String qualidade;
	private String legenda;
	private String direcao;
	private String elenco;
	
	@JsonFormat (pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataLancamento;
	
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy="midia")
	private List<ListaDesejo> listaDesejo = new ArrayList<>();
	
	
	@ManyToOne
	@JoinColumn(name="avaliacao_id")
	private Avaliacao avaliacao;
	
	//@OneToMany(mappedBy="midia")
	//private List<Avaliacao> avaliacoes = new ArrayList<>();
	
	

	public Midia() {
	}

	

	public Midia(Integer id, String nomeMidia, String qualidade, String legenda, String direcao, String elenco,
			Date dataLancamento, Usuario usuario, Avaliacao avaliacao ) {
		super();
		this.id = id;
		this.nomeMidia = nomeMidia;
		this.qualidade = qualidade;
		this.legenda = legenda;
		this.direcao = direcao;
		this.elenco = elenco;
		this.dataLancamento = dataLancamento;
		this.usuario= usuario;
		this.avaliacao = avaliacao;
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

	public String getQualidade() {
		return qualidade;
	}

	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public String getElenco() {
		return elenco;
	}

	public void setElenco(String elenco) {
		this.elenco = elenco;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ListaDesejo> getListaDesejo() {
		return listaDesejo;
	}

	public void setListaDesejo(List<ListaDesejo> listaDesejo) {
		this.listaDesejo = listaDesejo;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
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
		Midia other = (Midia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
