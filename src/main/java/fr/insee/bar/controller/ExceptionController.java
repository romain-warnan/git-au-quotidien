package fr.insee.bar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import fr.insee.bar.exception.BarDroitException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(BarDroitException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ModelAndView handleDroitException(BarDroitException e) {
		return modelAndView(e);
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
