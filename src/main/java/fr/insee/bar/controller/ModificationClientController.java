package fr.insee.bar.controller;

import fr.insee.bar.dao.ClientDao;
import fr.insee.bar.exception.BarDroitException;
import fr.insee.bar.model.Personne;
import fr.insee.bar.model.Employe;
import fr.insee.bar.service.EmployeService;
import fr.insee.bar.validator.ClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/client")
public class ModificationClientController {

	@Autowired
	private ClientDao clientDao;

	@Autowired
	private ClientValidator clientValidator;

	@Autowired
	private EmployeService employeService;

	@GetMapping("/modification/{client}")
	public String modificationClient(@PathVariable("client") Personne personne, Employe employe, Model model) throws BarDroitException {
		employeService.verifierResponsable(employe);
		model.addAttribute("client", personne);
		return "modification-client";
	}

	@PostMapping("/modification/{client}")
	public String modificationClientPost(@Valid Personne personne, BindingResult result, RedirectAttributes attributes) {
		clientValidator.validate(personne, result);
		if (result.hasErrors()) {
			return "modification-client";
		}
		clientDao.update(personne);
		attributes.addFlashAttribute("modification", true);
		attributes.addAttribute("id", personne.getId());
		return "redirect:/client/{id}";
	}
}
