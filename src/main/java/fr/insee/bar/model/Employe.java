package fr.insee.bar.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Employe {

	private Short id;
	private String nom;
	private Role role;

	public Short getId() {
		return id;
	} 

	public void setId(Short id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof Employe)) {
			return false;
		}
		Employe other = (Employe) object;
		return Objects.equal(this.id, other.id);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", id)
			.add("nom", nom)
			.add("role", role)
			.toString();
	}
}
