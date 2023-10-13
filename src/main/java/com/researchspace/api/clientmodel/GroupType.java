package com.researchspace.api.clientmodel;

public enum GroupType {
    
	LAB_GROUP("Lab Group"),
	COLLABORATION_GROUP("Collaboration Group"),
	PROJECT_GROUP("Project Group");

	private final String label;

	GroupType(String label){
		this.label = label;
	};

	public String getLabel(){
		return label;
	}
}
