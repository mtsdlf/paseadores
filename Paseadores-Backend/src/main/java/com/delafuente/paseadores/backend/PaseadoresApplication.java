package com.delafuente.paseadores.backend;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.delafuente.paseadores.backend.data.obj.Pet;
import com.delafuente.paseadores.backend.data.repositories.CustomRepository;
import com.delafuente.paseadores.backend.data.repositories.PetsRepository;

@SpringBootApplication
public class PaseadoresApplication implements CommandLineRunner {

	@Autowired
	PetsRepository repository;
	
	@Autowired
	CustomRepository crepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PaseadoresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteAll();
		addSampleData();
		listAll();	
		findFirst();
		
	}

	private void deleteAll() {	repository.save(new Pet("",""));
		System.out.println("Deleting all records");
		repository.deleteAll();
	}
	
	@PostConstruct
	private void addSampleData() {
		System.out.println("Adding Sample Data");
		
		try {
			repository.save(new Pet("Vichenzo","mediano"));
			
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			
		}
		repository.save(new Pet("Aaron Yoda","pequeño"));
		repository.save(new Pet("chester","grande"));
		repository.save(new Pet("Elune","pequeño"));
		repository.save(new Pet("Nikita","enorme"));
		

	}		

	private void findFirst() {
		Pet u = repository.findFirstByName("pepe");
		System.out.println(u);
	}
	private void listAll() {
		repository.findAll().forEach(p -> System.out.println(p.toString()));
		
	}



}
