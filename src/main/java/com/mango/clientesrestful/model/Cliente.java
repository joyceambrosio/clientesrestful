package com.mango.clientesrestful.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public final class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	private String nome;
	private int idade;
	@NotNull
	private double renda = 0.0;
	private double limiteDeCredito = 0.0;
	private String classificacao;

	public Cliente() {

	}

	public Cliente(long id, String nome, int idade, double renda, double limiteDeCredito, String classificacao)
			throws Exception {

		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.renda = renda;
		this.limiteDeCredito = limiteDeCredito;
		this.classificacao = classificacao;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) throws Exception {
		this.nome = nome;
	}

	public void setIdade(int idade) throws Exception {
		this.idade = idade;
	}

	public void setRenda(double renda) throws Exception {
		this.renda = renda;
	}

	public void setLimiteDeCredito(double limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public double getRenda() {
		return renda;
	}

	public double getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public String getClassificacao() {
		return classificacao;
	}

}
