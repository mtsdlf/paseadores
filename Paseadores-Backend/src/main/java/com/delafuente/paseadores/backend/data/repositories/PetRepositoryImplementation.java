package com.delafuente.paseadores.backend.data.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.delafuente.paseadores.backend.data.obj.Pet;
import com.mongodb.client.result.UpdateResult;

@Component
public class PetRepositoryImplementation implements CustomRepository {
 
	@Autowired
	MongoTemplate mongoTemplate;
	@Override
	public long updatePet(String name, String size) {
		Query query = new Query(Criteria.where("name").is(name));
		Update update = new Update();
		update.set("size", size);
		
		UpdateResult result = mongoTemplate.updateFirst(query, update, Pet.class);
		
		if (result !=null) 
		return result.getModifiedCount();
		else 
		return 0;
	}
}
