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
	
	
	
	public String createNewPerson(Person person) {
		String isSaved = checkEmailAndName(person);
		
		//implementing email and name check
		if(isSaved != null) {
			return isSaved;
		}
		
		
		//assigns roles and and encodes the password
		Roles role = rolesRepository.getByRoleName(OnlineBookStoreConstants.STUDENT_ROLE);
		person.setRoles(role);
		
		person.setPwd(passwordEncoder.encode(person.getPwd()));
		
		person = personRepository.save(person);
		
        if (null != person && person.getPersonId() > 0)
        {
            return isSaved;
        }
        return isSaved;
		
	}
	
	public String checkEmailAndName(Person person) {
		
		if(personRepository.findByEmail(person.getEmail()).isPresent()) {
			return "Email";
		}
		if(personRepository.findByName(person.getName()).isPresent()) {
			return "Name";
		}
		
		return null;
	}
	
}
