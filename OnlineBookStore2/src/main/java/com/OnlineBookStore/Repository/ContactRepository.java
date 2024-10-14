package com.OnlineBookStore.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.OnlineBookStore.Model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

	List<Contact> findByStatus(String open);

}
