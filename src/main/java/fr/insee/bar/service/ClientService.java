package fr.insee.bar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import fr.insee.bar.dao.ClientDao;
import fr.insee.bar.model.Client;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;

	public boolean emailDejaUtilise(Client client) {
		Optional<Client> optional = clientDao.findByEmail(client.getEmail());
		if (optional.isPresent()) {
			Client autre = optional.get();
			return !Objects.equal(autre.getId(), client.getId());
		}
		return false;
	}
}
