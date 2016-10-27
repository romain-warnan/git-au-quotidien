package fr.insee.bar.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Role {

	private Short id;
	private String libelle;

	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.id);
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || !(object instanceof Role)) {
			return false;
		}
		Role other = (Role) object;
		return Objects.equal(this.id, other.id);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", id)
			.add("libelle", libelle)
			.toString();
	}
}
