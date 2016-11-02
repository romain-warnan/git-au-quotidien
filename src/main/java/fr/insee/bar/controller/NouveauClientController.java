package fr.insee.bar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.insee.bar.dao.ClientDao;
import fr.insee.bar.model.Client;
import fr.insee.bar.model.Employe;
import fr.insee.bar.service.EmployeService;

@Controller
public class NouveauClientController {

	@Autowired
	private EmployeService employeService;

	@Autowired
	private ClientDao clientDao;

	@GetMapping("/nouveau-client")
	public String nouveauClient(Employe employe) {
		if (employeService.estResponsable(employe)) {
			return "nouveau-client";
		}
		return "redirect:/clients";
	}

	@PostMapping("/nouveau-client")
	public String creerClient(Employe employe, @ModelAttribute("client") Client client) {
		if (employeService.estResponsable(employe)) {
			clientDao.insert(client);
		}
		return "redirect:/clients";
	}
}
