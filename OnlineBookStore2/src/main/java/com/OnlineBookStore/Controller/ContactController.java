package com.OnlineBookStore.Controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OnlineBookStore.Model.Contact;
import com.OnlineBookStore.Service.ContactService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContactController {

	@Autowired
	private final ContactService contactService;
	
	ContactController(ContactService contactService){
		this.contactService = contactService;
	}
	
	@RequestMapping("/contact")
	public String displayContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact";
	}
	
	//Performs validation on the user contact inputs and returns the error message if necessary
	@RequestMapping(value = "/saveMsg", method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
        if(errors.hasErrors()){
            log.error("Contact form validation failed due to : " + errors.toString());
            return "contact";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }
	
	@RequestMapping("/closeMsg/{id}")
	public String UpdateMessageStatus(@PathVariable int id) {
		contactService.UpdateMessageStatus(id);
		return "redirect:/displayMessages";
		
	}
}
