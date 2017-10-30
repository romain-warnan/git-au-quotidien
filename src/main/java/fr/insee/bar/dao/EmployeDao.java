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

import fr.insee.bar.model.Employe;
import fr.insee.bar.model.Role;

@Repository
public class EmployeDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EmployeRowMapper rowMapper;

	private NamedParameterJdbcTemplate template;

	private static final String SQL_FIND =
		"select e.id as eid, e.nom as nom, r.id as rid, r.libelle as libelle "
			+ "from employes e "
			+ "left join roles r "
			+ "on e.idrole = r.id "
			+ "where e.id = :id";
	private static final String SQL_FIND_ALL =
		"select e.id as eid, e.nom as nom, r.id as rid, r.libelle as libelle "
			+ "from employes e "
			+ "left join roles r "
			+ "on e.idrole = r.id";

	@PostConstruct
	private void postConstruct() {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	public Optional<Employe> find(Short id) {
		try {
			Employe employe = template.queryForObject(SQL_FIND, ImmutableMap.of("id", id), rowMapper);
			return Optional.of(employe);

		}
		catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	public List<Employe> findAll() {
		return template.query(SQL_FIND_ALL, rowMapper);
	}

	@Component
	public class EmployeRowMapper implements RowMapper<Employe> {

		@Override
		public Employe mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role role = new Role();
			role.setId(rs.getShort("rid"));
			role.setLibelle(rs.getString("libelle"));
			Employe employe = new Employe();
			employe.setId(rs.getShort("eid"));
			employe.setNom(rs.getString("nom"));
			employe.setRole(role);
			return employe;
		}

	}
}
