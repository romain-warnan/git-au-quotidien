package fr.insee.bar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.insee.bar.dao.ClientDao;
import fr.insee.bar.model.Client;

@Controller
public class ClientsController {

	@Autowired
	private ClientDao clientDao;

	@GetMapping("/clients")
	public String clients(Model model) {
		List<Client> clients = clientDao.findAll();
		model.addAttribute("clients", clients);
		return "clients";
	}
}
