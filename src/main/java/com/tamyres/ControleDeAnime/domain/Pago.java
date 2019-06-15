package com.tamyres.ControleDeAnime.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pago extends Download {

	private static final long serialVersionUID = 1L;
	private Double valorPago;

	@ManyToOne
	@JoinColumn(name = "loja_id")
	private Loja loja;

	public Pago() {
	}

	public Pago(Integer id, Date dataDownload, Double tamanho, String urlSite, Double valorPago, Loja loja) {
		super(id, dataDownload, tamanho, urlSite);
		this.valorPago = valorPago;
		this.loja = loja;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}
