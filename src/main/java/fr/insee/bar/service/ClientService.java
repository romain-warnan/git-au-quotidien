package fr.insee.bar.service;

import com.google.common.base.Objects;
import fr.insee.bar.dao.ClientDao;
import fr.insee.bar.exception.BarClientException;
import fr.insee.bar.model.Personne;
import fr.insee.bar.model.Personne.Titre;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;

	public boolean emailDejaUtilise(Personne personne) {
		Optional<Personne> optional = clientDao.findByEmail(personne.getEmail());
		if (optional.isPresent()) {
			Personne autre = optional.get();
			return !Objects.equal(autre.getId(), personne.getId());
		}
		return false;
	}

	private boolean emailDejaUtilise(String email) {
		Optional<Personne> optional = clientDao.findByEmail(email);
		return optional.isPresent();
	}

	public long chargement(MultipartFile multipartFile) {
		File file = new File("clients.txt");
		try {
			multipartFile.transferTo(file);
			return FileUtils
				.readLines(file, "UTF-8")
				.stream()
				.map(this::personne)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.map(clientDao::insert)
				.count();
		}
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return 0;
	}

	public File fichier() {
		File file = new File("clients.txt");
		try {
			FileUtils.writeLines(file, "UTF-8", clientDao
				.findAll()
				.stream()
				.map(this::string)
				.collect(Collectors.toList()));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return file;
	}

	private String string(Personne personne) {
		StringBuilder builder = new StringBuilder();
		builder
			.append(personne.getTitre().getCode())
			.append(";")
			.append(personne.getNom())
			.append(";")
			.append(personne.getEmail())
			.append(";")
			.append(this.string(personne.getDateNaissance()))

		;
		return builder.toString();
	}

	private String string(Date date) {
		return DateTimeFormatter
			.ofPattern("dd/MM/yyyy")
			.format(Instant
				.ofEpochMilli(date.getTime())
				.atZone(ZoneId.systemDefault())
				.toLocalDate());
	}

	private Optional<Personne> personne(String ligne) {
		try {
			return this.clientException(ligne);
		}
		catch (BarClientException e) {
			System.err.println(e.getMessage());
		}
		return Optional.empty();
	}

	private Personne personne(String[] tokens) throws BarClientException, NumberFormatException, DateTimeParseException {
		if (tokens.length != 4) {
			throw new BarClientException(String.format("Il y a %d éléments au lieu de 4.", tokens.length));
		}
		if (this.emailDejaUtilise(tokens[2])) {
			throw new BarClientException(String.format("L’email %s est déjà utilisé.", tokens[2]));
		}
		Personne personne = new Personne();
		personne.setTitre(Titre.of(Short.valueOf(tokens[0])));
		personne.setNom(tokens[1]);
		personne.setEmail(tokens[2]);
		personne.setDateNaissance(this.date(tokens[3]));
		return personne;
	}

	private Date date(String string) throws DateTimeParseException {
		Instant instant = LocalDate
			.parse(string, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
			.atStartOfDay()
			.atZone(ZoneId.systemDefault())
			.toInstant();
		return Date.from(instant);

	}

	public List<Personne> personnes() {
		return clientDao.findAll();
	}

	private Optional<Personne> clientException(String ligne) throws BarClientException {
		if (StringUtils.isNotBlank(ligne)) {
			String[] tokens = ligne.split(";");
			try {
				return Optional.of(this.personne(tokens));
			}
			catch (NumberFormatException e) {
				throw new BarClientException(String.format("La ligne [%s] est invalide. %s n’est pas un nombre valide.", ligne, tokens[0]));
			}
			catch (DateTimeParseException e) {
				throw new BarClientException(String.format("La ligne [%s] est invalide. La date %s n’est pas au format dd/mm/yyyy", ligne, tokens[3]));
			}
			catch (BarClientException e) {
				throw new BarClientException(String.format("La ligne [%s] est invalide. %s", ligne, e.getMessage()));
			}
		}
		return Optional.empty();
	}
}
