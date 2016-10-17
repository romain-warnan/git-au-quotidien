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

import fr.insee.bar.model.Client;

@Repository
public class ClientDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private ClientRowMapper rowMapper;

	private NamedParameterJdbcTemplate template;

	private static final String SQL_FIND = "select * from clients where id = :id";
	private static final String SQL_FIND_ALL = "select * from clients";

	@PostConstruct
	private void postConstruct() {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	public Optional<Client> find(Short id) {
		try {
			Client client = template.queryForObject(SQL_FIND, ImmutableMap.of("id", id), rowMapper);
			return Optional.of(client);

		}
		catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	public List<Client> findAll() {
		return template.query(SQL_FIND_ALL, rowMapper);
	}

	@Component
	public class ClientRowMapper implements RowMapper<Client> {

		@Override
		public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
			Client client = new Client();
			client.setId(rs.getShort("id"));
			client.setNom(rs.getString("nom"));
			client.setEmail(rs.getString("email"));
			client.setDateNaissance(rs.getDate("date_naissance"));
			return client;
		}

	}
}
