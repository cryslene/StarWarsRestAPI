package com.apisw.starwars.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apisw.starwars.plan.Planeta;
import com.apisw.starwars.services.PlanetaService;

// Funcionalidades da RestApi Star Wars

@RestController
@RequestMapping(path = "/api/planetas")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;
	
	//Adicionar um planeta (com nome, clima e terreno)
	@PostMapping
	public ResponseEntity<Planeta> adicionarPlaneta(@Valid @RequestBody Planeta planeta) {
		return ResponseEntity.ok(this.planetaService.adicionarPlaneta(planeta));
	}
	
	//Listar todos os planetas
	@GetMapping
	public ResponseEntity<List<Planeta>> buscarTodos() {
		return ResponseEntity.ok(this.planetaService.buscarTodos());
	}
	
	//Buscar um planeta por nome
	@GetMapping(path = "/")
	public ResponseEntity<Planeta> buscarPorNome(@RequestParam("nome") String nome) {
		return ResponseEntity.ok(this.planetaService.buscarPorNome(nome));
	}
	
	//Buscar um planeta pelo ID
	@GetMapping(path = "/{id}")
	public ResponseEntity<Planeta> buscarPorID(@PathVariable("id") String id) {
		return ResponseEntity.ok(this.planetaService.buscarPorID(id));
	}
	
	//Remover um planeta
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> removerPlaneta(@PathVariable("id") String id) {
		this.planetaService.removerPlaneta(id);
		return ResponseEntity.ok("PLANETA EXCLUÍDO COM SUCESSO!");
	}
	
}
