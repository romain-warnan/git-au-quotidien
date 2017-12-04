package fr.insee.bar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.insee.bar.model.Personne;

@Controller
public class ClientController {

	@GetMapping("/client/{id}")
	public String personne(Model model, @PathVariable("id") Personne personne) {
		model.addAttribute("client", personne);
		return "client";
	}
}
