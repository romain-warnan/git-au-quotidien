package fr.insee.bar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class NouveauClientController {

	@GetMapping("/nouveau")
	public String nouveauClient() {
		return "nouveau-client";
	}
}
