package fr.insee.bar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.insee.bar.model.Client;

@Controller
public class DroitsController {

	@GetMapping("/us142")
	public String us142() {
		Client client = new Client();
		client.setEmail("us142@email.com");
		return "us142";
	}
}
