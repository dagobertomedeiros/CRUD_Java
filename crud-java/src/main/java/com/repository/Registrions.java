package com.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.model.Registry;

public class Registrions implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Registrions() {
		
	}
	
	public Registrions(EntityManager manager) {
		this.manager = manager;
	}
	
	public Registry forId(Integer id) {
		return manager.find(Registry.class, id);
	}
	
	public List<Registry> search(String name, String cpf){
		//TypedQuery<Registry> query = manager.createQuery("from Registry where name like :name and cpf like :cpf ", Registry.class);
		TypedQuery<Registry> query = manager.createQuery("from Registry where name like" + name + "% and cpf like" + cpf +"%", Registry.class);
		//query.setParameter("name", name + "%", "cpf", cpf + "%");
		return query.getResultList();
	}
	
	public List<Registry> searchCriteria(String cpf){
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Registry> criteriaQuery = criteriaBuilder.createQuery(Registry.class);
		Root<Registry> root = criteriaQuery.from(Registry.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("cpf"), cpf + "%"));
		TypedQuery<Registry> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
		}
	
	public Registry save(Registry registry) {
		return manager.merge(registry);
	}
	
	public void remove(Registry registry) {
		registry = forId(registry.getId());
		manager.remove(registry);
	}
	
}
