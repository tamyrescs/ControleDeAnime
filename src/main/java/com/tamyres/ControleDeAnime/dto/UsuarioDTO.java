package com.tamyres.ControleDeAnime.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.tamyres.ControleDeAnime.domain.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 15, message = "O tamanho deve ser entre 5 e 15 caracteres")
	private String login;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 8, message = "O tamanho deve ser entre 5 e 8 caracteres")
	private String senha;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		login = obj.getLogin();
		senha = obj.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

}
