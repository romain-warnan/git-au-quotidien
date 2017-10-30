package fr.insee.bar.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.insee.bar.dao.ClientDao;
import fr.insee.bar.model.Personne;

@Component
public class ClientConverter implements Converter<String, Personne> {

	@Autowired
	private ClientDao clientDao;

	@Override
	public Personne convert(String id) {
		Optional<Personne> personne = clientDao.find(Short.valueOf(id));
		return personne.orElse(Personne.EMPTY);
	}
}
