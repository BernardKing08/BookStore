package com.OnlineBookStore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.OnlineBookStore.Model.Roles;
import com.OnlineBookStore.Model.Person;
import com.OnlineBookStore.Repository.PersonRepository;
import com.OnlineBookStore.Repository.RolesRepository;
import com.OnlineBookStore.constants.OnlineBookStoreConstants;

import jakarta.validation.Valid;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private RolesRepository rolesRepository; 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	public boolean createNewPerson(Person person) {
		boolean isSaved = false;
		
		Roles role = rolesRepository.getByRoleName(OnlineBookStoreConstants.STUDENT_ROLE);
		person.setRoles(role);
		
		person.setPwd(passwordEncoder.encode(person.getPwd()));
		
		person = personRepository.save(person);
		
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
		
		
	}
	 
}
