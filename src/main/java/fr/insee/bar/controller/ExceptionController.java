package fr.insee.bar.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.insee.bar.exception.BarAjaxException;
import fr.insee.bar.exception.BarCommandeException;
import fr.insee.bar.exception.BarDroitException;
import fr.insee.bar.exception.BarHttpException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(BarDroitException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public String handleDroitException(BarDroitException e, Model model) {
		return httpException(e, model);
	}

	@ExceptionHandler(BarCommandeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public HttpEntity<String> handleCommandeException(BarCommandeException e) {
		return ajaxException(e);
	}

	@ExceptionHandler(BarHttpException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleHttpException(BarHttpException e, Model model) {
		return httpException(e, model);
	}

	@ExceptionHandler(BarAjaxException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public HttpEntity<String> handleAjaxException(BarAjaxException e) {
		return ajaxException(e);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public HttpEntity<String> handleUnexpectedException(Exception e) {
		return ajaxException(e);
	}

	private static String httpException(Exception e, Model model) {
		model.addAttribute("message", e.getMessage());
		return "exception";
	}

	private static HttpEntity<String> ajaxException(Exception e) {
		return new HttpEntity<String>(e.getMessage());
	}
}
