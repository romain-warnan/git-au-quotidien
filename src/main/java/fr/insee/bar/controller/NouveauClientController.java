package fr.insee.bar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.insee.bar.dao.ClientDao;
import fr.insee.bar.model.Client;
import fr.insee.bar.model.Client.Titre;

@Controller
@RequestMapping("/client")
public class NouveauClientController {

	@Autowired
	private ClientDao clientDao;

	@ModelAttribute("titres")
	private Titre[] titres() {
		return Titre.values();
	}

	@GetMapping("/nouveau")
	public String nouveauClient() {
		return "nouveau-client";
	}

	@PostMapping("/nouveau")
	public String nouveauClientPost(@ModelAttribute("client") Client client) {
		clientDao.insert(client);
		return "redirect:/clients";
	}
}
