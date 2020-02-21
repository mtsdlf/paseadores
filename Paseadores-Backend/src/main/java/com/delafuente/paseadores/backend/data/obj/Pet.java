package com.delafuente.paseadores.backend.data.obj;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pets")
public class Pet {
	@Id
	private String id;
	private String name;
	private String size;
	
	//constructor publico para testing sobre application-- fijarse q onda
	public Pet(String name, String size) {
		this.name = name;
		this.size = size;
	}

	String getName() {
		return this.name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getSize() {
		return this.size;
	}
	
	void setSize(String size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return name + " - " + size;
		
	}
}
