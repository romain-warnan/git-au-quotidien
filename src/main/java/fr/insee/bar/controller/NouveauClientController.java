package fr.insee.bar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.insee.bar.model.Employe;
import fr.insee.bar.service.EmployeService;

@Controller
public class NouveauClientController {

	@Autowired
	private EmployeService employeService;

	@RequestMapping(value = "/nouveau-client", method = RequestMethod.GET)
	public String nouveauClient(Employe employe) {
		if (employeService.estResponsable(employe)) {
			return "nouveau-client";
		}
		return "redirect:/clients";
	}
}
