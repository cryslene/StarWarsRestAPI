package com.apisw.starwars.plan;

import java.util.List;

//Classe para os dados que serão obtidos da API pública do Star Wars
//encontrada em (https://swapi.dev/about)

public class MappingSw {

	private String name;
	private List<String> films;
	
	public MappingSw() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
}
