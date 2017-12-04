package fr.insee.bar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.insee.bar.model.Salarie;

@Controller
@RequestMapping("/commande")
public class CommandeController {

	@GetMapping
	public String commande(Salarie salarie, Model model) {
		model.addAttribute("employe", salarie);
		return "commande";
	}
}