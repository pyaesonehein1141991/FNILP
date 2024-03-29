package org.ace.insurance.common;

public enum TransactionType {
	/* [warning] whenever edit label, plz also edit getSubLabel() */
	UNDERWRITING("Underwriting"), ENDORSEMENT("Endorsement"), RENEWAL("Renewal"), BILL_COLLECTION("Bill Collection");

	private String label;

	private TransactionType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public String getSubLabel() {
		String subLabel = "";
		switch (this) {
			case UNDERWRITING:
				subLabel = "U";
				break;
			case ENDORSEMENT:
				subLabel = "E";
				break;
			case RENEWAL:
				subLabel = "R";
				break;

			case BILL_COLLECTION:
				subLabel = "BC";
				break;
		}
		return subLabel;
	}
}
