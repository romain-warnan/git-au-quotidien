package fr.insee.bar.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@PropertySource("classpath:application.properties")
public class AccueilController {

	@Value("${name}")
	private String name;

	@RequestMapping("/")
	public View welcome(RedirectView view) {
		view.setUrl("/accueil");
		view.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
		return view;
	}

	@RequestMapping("/accueil")
	public String hello(Model model) {
		model.addAttribute("message", this.message());
		return "accueil";
	}

	private String message() {
		return "Hello world " + name;
	}
}
