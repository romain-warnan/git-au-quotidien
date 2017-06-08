package fr.insee.bar.controller;

import fr.insee.bar.exception.BarAjaxException;
import fr.insee.bar.exception.BarCommandeException;
import fr.insee.bar.exception.BarDroitException;
import fr.insee.bar.exception.BarHttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(BarDroitException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public String handleDroitException(BarDroitException e, Model model) {
		return httpException(e, model);
	}

	@ExceptionHandler(BarCommandeException.class)
	public ResponseEntity<String> handleCommandeException(BarCommandeException e) {
		return ResponseEntity
            .badRequest()
            .body(e.getMessage());
	}

	@ExceptionHandler(BarHttpException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleHttpException(BarHttpException e, Model model) {
		return httpException(e, model);
	}

	@ExceptionHandler(BarAjaxException.class)
	public ResponseEntity<String> handleAjaxException(BarAjaxException e) {
		return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(e.getMessage());
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleResourceNotFoundException(Model model) {
		return httpException("La page que vous cherchez n’existe pas.", model);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleUnexpectedException(Exception e) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(e.getMessage());
	}

	private static String httpException(String message, Model model) {
		model.addAttribute("message", message);
		return "exception";
	}

	private static String httpException(Exception e, Model model) {
		model.addAttribute("message", e.getMessage());
		return "exception";
	}
}
