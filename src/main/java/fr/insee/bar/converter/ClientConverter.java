package fr.insee.bar.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.insee.bar.dao.ClientDao;
import fr.insee.bar.model.Client;

@Component
public class ClientConverter implements Converter<String, Client> {

	@Autowired
	private ClientDao clientDao;

	@Override
	public Client convert(String id) {
		Optional<Client> client = clientDao.find(Short.valueOf(id));
		return client.orElse(Client.EMPTY);
	}
}
