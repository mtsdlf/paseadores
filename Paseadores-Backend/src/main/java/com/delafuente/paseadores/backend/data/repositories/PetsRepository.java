package com.delafuente.paseadores.backend.data.repositories;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.delafuente.paseadores.backend.data.obj.Pet;

public interface PetsRepository extends MongoRepository<Pet, Serializable> {
	
	public Pet findFirstByName(String name);

	public Pet findFirstBySize(String size);
}
