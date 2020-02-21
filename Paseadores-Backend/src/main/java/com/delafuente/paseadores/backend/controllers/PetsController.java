package com.delafuente.paseadores.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delafuente.paseadores.backend.data.obj.Pet;
import com.delafuente.paseadores.backend.data.repositories.CustomRepository;
import com.delafuente.paseadores.backend.data.repositories.PetsRepository;


@RestController
@RequestMapping("/pets")
public class PetsController {
	@Autowired
	PetsRepository repository;

	@Autowired
	CustomRepository crepo;

	@RequestMapping(value="/", method= RequestMethod.GET)
	List<Pet>getAllPets(){
		System.out.println("as");
		return 	repository.findAll();
		
		
	}

}
