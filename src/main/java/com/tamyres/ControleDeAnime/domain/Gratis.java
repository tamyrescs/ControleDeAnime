package com.tamyres.ControleDeAnime.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Gratis extends Download{

	private static final long serialVersionUID = 1L;
	private String nomeSite;
	

	public Gratis() {
	}

	public Gratis(Integer id, Date dataDownload, Double tamanho, String urlSite, String nomeSite) {
		super(id, dataDownload, tamanho, urlSite);
		this.nomeSite = nomeSite;
	}

	public String getNomeSite() {
		return nomeSite;
	}

	public void setNomeSite(String nomeSite) {
		this.nomeSite = nomeSite;
	}
	
	
}
