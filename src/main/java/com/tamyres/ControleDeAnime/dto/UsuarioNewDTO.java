package com.tamyres.ControleDeAnime.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UsuarioNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 15, message = "O tamanho deve ser entre 5 e 15 caracteres")
	private String login;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 8, message = "O tamanho deve ser entre 5 e 8 caracteres")
	private String senha;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Email
	private String email;
	

	@NotEmpty(message="Preenchimento obrigatório")
	private String nomeMidia;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String legenda;
	
	private Integer avaliacaoId;
	
	
	private String qualidade;
	private String direcao;
	private String elenco;
	@NotEmpty(message="Preenchimento obrigatório")
	private Date dataLancamento;
	
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getQualidade() {
		return qualidade;
	}
	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
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
	public Integer getAvaliacaoId() {
		return avaliacaoId;
	}
	public void setAvaliacaoId(Integer avaliacaoId) {
		this.avaliacaoId = avaliacaoId;
	}
	
	
}
