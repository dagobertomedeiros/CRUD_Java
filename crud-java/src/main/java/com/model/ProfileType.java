package com.model;

public enum ProfileType {
	
	ADM("Usuário administrador"),
	USER("Usuário comum");
	
	private String description;
	
	ProfileType(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
