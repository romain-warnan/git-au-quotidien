package fr.insee.bar.service;

import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import fr.insee.bar.exception.BarDroitException;
import fr.insee.bar.model.Salarie;
import fr.insee.bar.model.Role;

@Service
public class EmployeService {

	private static final Short RESPONSABLE = Short.valueOf("2");

	public boolean estResponsable(Salarie salarie) {
		Role role = salarie.getRole();
		if (role == null) {
			return false;
		}
		return Objects.equal(role.getId(), RESPONSABLE);
	}

	public void verifierResponsable(Salarie salarie) throws BarDroitException {
		if (!this.estResponsable(salarie)) {
			throw new BarDroitException(salarie);
		}
	}
}
