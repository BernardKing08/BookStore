package com.OnlineBookStore.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.OnlineBookStore.Model.Person;
import com.OnlineBookStore.Model.Roles;
import com.OnlineBookStore.Repository.PersonRepository;

@Component
public class BookStoreUserNamePwdAuthenticationProvider implements AuthenticationProvider {

	@Autowired 
	private PersonRepository personRepository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		
		Person person = personRepository.readByEmail(email);
		if (person != null && person.getPersonId() > 0) {
		    if (passwordEncoder.matches(pwd, person.getPwd())) {
		        return new UsernamePasswordAuthenticationToken(person.getName(), null, getGrantedAuthorities(person.getRoles()));
		    } else {
		        System.out.println("Password mismatch");
		        throw new BadCredentialsException("Invalid credentials");
		    }
		} else {
		    System.out.println("User not found or invalid ID");
		    throw new BadCredentialsException("Invalid credentials");
		}

		
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(Roles roles){
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roles.getRoleName()));
		return grantedAuthorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
