package com.apisw.starwars.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apisw.starwars.exceptions.BadRequestPlanet;
import com.apisw.starwars.exceptions.ServiceError;
import com.apisw.starwars.plan.MappingApiSw;
import com.apisw.starwars.plan.Planeta;
import com.apisw.starwars.repositories.PlanetaRepositorio;

//Serviço de controle da RestApi Star Wars

@Service
public class PlanetaService {

	
	private PlanetaRepositorio planetaRepositorio;
	
	@Autowired
	private PlanetaServiceRepoApi planetaServiceRepoApi;
	
	@Autowired
	public PlanetaService(PlanetaRepositorio planetaRepositorio) {
		this.planetaRepositorio = planetaRepositorio;
	}
	
	public Planeta adicionarPlaneta(Planeta planeta) {
		verificacao(planeta);
		planeta.setId(null);
		MappingApiSw mappingApiSw = this.planetaServiceRepoApi.buscarPorNome(planeta.getNome());
		if (mappingApiSw.getResults().isEmpty()) {
			planeta.setquantidadeDeAparicoes(0);
		} else {
			planeta.setquantidadeDeAparicoes(mappingApiSw.getResults().get(0).getFilms().size());
		}
		return this.planetaRepositorio.save(planeta);
		}
	
	public List<Planeta> buscarTodos() {
		return this.planetaRepositorio.findAll();
		
	}
	
	public Planeta buscarPorNome(String nome) {
		Planeta listarPlaneta = this.planetaRepositorio.findByNome(nome);
		if (listarPlaneta == null) {
			throw new BadRequestPlanet("Nome não encontrado!");
		}
		return this.planetaRepositorio.findByNome(nome);
	}

	public Planeta buscarPorID(String id) {
		Optional<Planeta> planeta = planetaRepositorio.findById(id);
		return  planeta.orElseThrow(() -> new ServiceError("ID não encontrado!"));
	}
	
	public void removerPlaneta(String id) {
		this.planetaRepositorio.deleteById(id);
	}
	
	public Planeta verificacao(Planeta planeta) {
		try {	
			if(planeta.getNome().isEmpty() || planeta.getNome().equals(null)) {
				throw new ServiceError("Nome vazio!");
			}
			if(planeta.getClima().isEmpty()|| planeta.getClima().equals(null)) {
				throw new ServiceError("Clima vazio!");
			}
			if(planeta.getTerreno().isEmpty()|| planeta.getTerreno().equals(null)) {
				throw new ServiceError("Terreno vazio!");
			}
		}catch(Exception e) {
			
			throw new ServiceError("Erro ao inserir!");
		}
		return planeta;
	}

}
