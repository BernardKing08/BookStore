package com.OnlineBookStore.Repository;

import org.springframework.data.repository.CrudRepository;

import com.OnlineBookStore.Model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {

	Person readByEmail(String email);

}
