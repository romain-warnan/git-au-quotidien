package fr.insee.bar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.insee.bar.dao.CocktailDao;
import fr.insee.bar.model.Employe;

@Controller
@RequestMapping("/commande")
public class CommandeController {

	@Autowired
	private CocktailDao cocktailDao;

	@GetMapping
	public String commande(Employe employe, Model model) {
		model.addAttribute("employe", employe);
		return "commande";
	}
}
