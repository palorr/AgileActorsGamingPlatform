package com.agile.model.enums;

public enum OperationEnum {
	
	ADDED("added"),
	MODIFIED("modified"),
	REMOVED("removed");

	private String description;
	
	OperationEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
