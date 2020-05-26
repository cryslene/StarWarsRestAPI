package com.apisw.starwars.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.apisw.starwars.plan.Planeta;


public interface PlanetaRepositorio extends MongoRepository<Planeta, String> {

	Planeta findByNome(String nome);
}
