package com.OnlineBookStore.Controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.OnlineBookStore.Model.Contact;
import com.OnlineBookStore.Service.ContactService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class DashboardController {
	
	private final ContactService contactService;
	
	public DashboardController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@RequestMapping("/dashboard")
	public String displayDashboard(Model model, Authentication auth) {
		model.addAttribute("username", auth.getName());
		model.addAttribute("roles", auth.getAuthorities().toString());
		
		return "dashboard";
	}
	
	@RequestMapping("/displayMessages")
	public String displayMessages(Model model) {
		List<Contact> contactMsgs = contactService.getOpenMsg();
		model.addAttribute("contactMsgs", contactMsgs);
		return "messages";
	}
}
