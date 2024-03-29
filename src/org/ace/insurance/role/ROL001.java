package org.ace.insurance.role;

import java.io.Serializable;

public class ROL001 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public ROL001(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public ROL001(Role role) {
		this.id = role.getId();
		this.name = role.getName();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ROL001 other = (ROL001) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
