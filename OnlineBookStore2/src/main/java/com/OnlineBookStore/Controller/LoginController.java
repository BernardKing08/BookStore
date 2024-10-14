package com.OnlineBookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.OnlineBookStore.Model.Person;
import com.OnlineBookStore.Service.PersonService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(@RequestParam(value = "logout", required = false) String logout,
    					@RequestParam(value = "error", required = false) String error, 
    					@RequestParam(value = "register", required = false) String register, Model model) {
		
		String errorMessage = null;
		
		if (error != null) {
		    errorMessage = "Username or password is incorrect";
		}
		if(logout != null) {
			errorMessage = "You have successfully logged out";
		}
		if(register != null) {
			errorMessage = "New User successfully Registered";
		}
		
		model.addAttribute("errorMessage", errorMessage);
				
        return "login";
    }
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout=true";
	}
	
	//signin controller
	@RequestMapping(value="/signin", method = {RequestMethod.GET})
	public String signIn(Model model) {
		model.addAttribute("person", new Person());
		return "signIn";
	}
	
	///register?
	@RequestMapping(value = "/register", method = { RequestMethod.POST})
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors) {
        if(errors.hasErrors()){
            return "signIn";
        }
        boolean isSaved = personService.createNewPerson(person);
        if(isSaved){
            return "redirect:/login?register=true";
        }else {
            return "signIn";
        }
    }

	
	
}
