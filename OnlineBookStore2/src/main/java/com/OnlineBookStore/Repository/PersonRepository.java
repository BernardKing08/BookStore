package com.OnlineBookStore.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.OnlineBookStore.Model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

	Optional<Person> findByEmail(String email);

	//return a person object 
	Person readByEmail(String email);

	//default method to find by name
	Optional<Person> findByName(String name);

}
