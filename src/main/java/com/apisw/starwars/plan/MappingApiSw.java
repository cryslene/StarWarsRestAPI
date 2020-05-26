package com.apisw.starwars.plan;

import java.util.List;

//Classe para os dados que serão obtidos da API pública do Star Wars
//encontrada em (https://swapi.dev/about)

public class MappingApiSw {

	private List<MappingSw> results;
		
		public MappingApiSw() {}
	
		public List<MappingSw> getResults() {
			return results;
		}
	
		public void setResults(List<MappingSw> results) {
			this.results = results;
		}
}
