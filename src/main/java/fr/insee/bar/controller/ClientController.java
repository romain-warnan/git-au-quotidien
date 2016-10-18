package fr.insee.bar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.insee.bar.model.Client;

@Controller
public class ClientController {

	@RequestMapping("/client/{id}")
	public String client(Model model, @PathVariable("id") Client client) {
		model.addAttribute("client", client);
		return "client";
	}
}
