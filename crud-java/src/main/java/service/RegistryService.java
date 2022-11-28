package service;

import java.io.Serializable;

import javax.inject.Inject;

import com.model.Registry;
import com.repository.Registrions;

import util.Transactional;

public class RegistryService implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Inject
	private Registrions registrions;
	
	@Transactional
	public void save(Registry registry) {
		registrions.save(registry);
	}
	
	@Transactional
	public void remove(Registry registry) {
		registrions.remove(registry);
	}
}
