package com.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.model.ProfileType;
import com.model.Registry;
import com.repository.Registrions;

import util.FacesMessages;

@Named
@ViewScoped
public class RegistrionsBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Registrions registrions;
	private List<Registry> listRegistry;
	private String nameSearch;
	private String cpfSearch;
	private String emailSearch;
	@Inject
	private FacesMessages msg;
	
	public void search() {
		listRegistry = registrions.search(nameSearch, cpfSearch);
		if (listRegistry.isEmpty()) {
			msg.message("Sem registros.");
		}
	}
	
	public void insert(Registry registry) {
		registrions.save(registry);
	}
	
	public void remove(Registry registry) {
		registrions.remove(registry);
	}
	
	public List<Registry> getRegistrions(){
		return listRegistry;
	}
	
	public ProfileType[] getType() {
		return ProfileType.values();
	}
	
	public String getNameSearch() {
		return nameSearch;
	}


	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}


	public String getCpfSearch() {
		return cpfSearch;
	}


	public void setCpfSearch(String cpfSearch) {
		this.cpfSearch = cpfSearch;
	}
	
	public String getEmailSearch() {
		return emailSearch;
	}
	
	public void setEmailSearch(String emailSearch) {
		this.emailSearch = emailSearch;
	}
	
}
