package fr.insee.bar.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import fr.insee.bar.exception.BarAjaxException;
import fr.insee.bar.exception.BarCommandeException;
import fr.insee.bar.exception.BarDroitException;
import fr.insee.bar.exception.BarHttpException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(BarDroitException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ModelAndView handleDroitException(BarDroitException e) {
		return modelAndView(e);
	}

	@ExceptionHandler(BarCommandeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public HttpEntity<String> handleCommandeException(BarCommandeException e) {
		return new HttpEntity<String>(e.getMessage());
	}

	@ExceptionHandler(BarHttpException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleHttpException(BarHttpException e) {
		return modelAndView(e);
	}

	@ExceptionHandler(BarAjaxException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public HttpEntity<String> handleAjaxException(BarAjaxException e) {
		return new HttpEntity<String>(e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView handleUnexpectedException(Exception e) {
		return modelAndView(e);
	}

	private static ModelAndView modelAndView(Exception e) {
		ModelAndView modelAndView = new ModelAndView("exception");
		modelAndView.addObject("message", e.getMessage());
		return modelAndView;
	}
}
