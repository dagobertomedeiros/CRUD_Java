package com.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.model.Adress;
import com.repository.Adresses;

@Named
@ViewScoped
public class AdressesBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Adresses adresses;
	private List<Adress> listAdress;
	private Integer idSearch;
	
	public void search() {
		listAdress = adresses.searchCriteria(idSearch);
	}
	
	public List<Adress> getAdresses(){
		return listAdress;
	}
	
	public void insert(Adress adress) {
		adresses.save(adress);
	}
	
	public void remove(Adress adress) {
		adresses.remove(adress);
	}
	
	
	
}
