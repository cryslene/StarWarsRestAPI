package com.apisw.starwars.plan;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;


// Classe para os dados que serão obtidos do banco de dados MongoDB da aplicação
// Dados: nome, clima, terreno e ostra da quantidade de aparições
// em filmes (obtidas da API pública do Star Wars: https://swapi.dev/about)

@Document
public class Planeta {

	@Id
	private String id;
	
	@NotEmpty(message = "Nome não pode ser vazio!")
	private String nome;
	
	@NotEmpty(message = "Clima não pode ser vazio!")
	private String clima;
	
	@NotEmpty(message = "Terreno não pode ser vazio!")
	private String terreno;
	
	private Integer quantidadeDeAparicoes;

	public Planeta() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getquantidadeDeAparicoes() {
		return quantidadeDeAparicoes;
	}

	public void setquantidadeDeAparicoes(Integer quantidadeDeAparicoes) {
		this.quantidadeDeAparicoes = quantidadeDeAparicoes;
	}
}
