package fr.insee.bar.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.insee.bar.model.Personne;
import fr.insee.bar.service.ClientService;

@Component
public class ClientValidator implements Validator {

	@Autowired
	private ClientService clientService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Personne.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Personne personne = (Personne) target;
		if (clientService.emailDejaUtilise(personne)) {
			errors.rejectValue("email", "client.email.unique");
		}
	}

}
