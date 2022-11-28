package service;

import java.io.Serializable;

import javax.inject.Inject;

import com.model.Adress;
import com.repository.Adresses;
import util.Transactional;

public class AdressService implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Inject
	private Adresses adresses;
	
	@Transactional
	public void save(Adress adress) {
		adresses.save(adress);
	}
	
	@Transactional
	public void remove(Adress adress) {
		adresses.remove(adress);
	}
}
