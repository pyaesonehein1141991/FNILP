package org.ace.insurance.common;

public enum LifeProductType {
	PUBLIC_LIFE("Public Life"),
	GROUP_LIFE("Group Life"),
	SNAKE_BITE("Snake Bite"),
	SPORT_MAN("SportMan");

	private String label;

	private LifeProductType (String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
