package fr.insee.bar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableMap;

import fr.insee.bar.model.Personne;
import fr.insee.bar.model.Personne.Titre;

@Repository
public class ClientDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private ClientRowMapper rowMapper;

	private NamedParameterJdbcTemplate template;

	private static final String SQL_FIND = "select * from clients where id = :id";
	private static final String SQL_FIND_BY_EMAIL = "select * from clients where email = :email";
	private static final String SQL_FIND_ALL = "select * from clients";
	private static final String SQL_INSERT = "insert into clients (id, nom, email, date_naissance, titre) values (next value for seq, :nom, :email, :dateNaissance, :titre)";
	private static final String SQL_UPDATE = "update clients set nom = :nom, email = :email, date_naissance = :dateNaissance, titre = :titre where id = :id";

	@PostConstruct
	private void postConstruct() {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	public Optional<Personne> find(Short id) {
		try {
			Personne personne = template.queryForObject(SQL_FIND, ImmutableMap.of("id", id), rowMapper);
			return Optional.of(personne);

		}
		catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	public Optional<Personne> findByEmail(String email) {
		try {
			Personne personne = template.queryForObject(SQL_FIND_BY_EMAIL, ImmutableMap.of("email", email), rowMapper);
			return Optional.of(personne);

		}
		catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	public List<Personne> findAll() {
		return template.query(SQL_FIND_ALL, rowMapper);
	}

	public Personne insert(Personne personne) {
		template.update(SQL_INSERT, ImmutableMap.of(
			"nom", personne.getNom(),
			"email", personne.getEmail(),
			"dateNaissance", personne.getDateNaissance(),
			"titre", personne.getTitre().getCode()));
		return this.findByEmail(personne.getEmail()).get();
	}

	public Personne update(Personne personne) {
		template.update(SQL_UPDATE, ImmutableMap.of(
			"nom", personne.getNom(),
			"email", personne.getEmail(),
			"dateNaissance", personne.getDateNaissance(),
			"titre", personne.getTitre().getCode(),
			"id", personne.getId()));
		return personne;
	}

	@Component
	public class ClientRowMapper implements RowMapper<Personne> {

		@Override
		public Personne mapRow(ResultSet rs, int rowNum) throws SQLException {
			Personne personne = new Personne();
			personne.setId(rs.getShort("id"));
			personne.setNom(rs.getString("nom"));
			personne.setEmail(rs.getString("email"));
			personne.setDateNaissance(rs.getDate("date_naissance"));
			personne.setTitre(Titre.of(rs.getShort("titre")));
			return personne;
		}

	}
}
