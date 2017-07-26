package com.researchspace.api.clientmodel;

public enum SearchOperator {
	AND("and"), OR("or");
	
	private String value;

	SearchOperator(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
