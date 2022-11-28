package com.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.model.Adress;

public class Adresses implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Adresses() {
		
	}
	
	public Adresses(EntityManager manager) {
		this.manager = manager;
	}
	
	public Adress forId(Integer id) {
		return manager.find(Adress.class, id);
	}
	
	public List<Adress> searchCriteria(Integer id){
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Adress> criteriaQuery = criteriaBuilder.createQuery(Adress.class);
		Root<Adress> root = criteriaQuery.from(Adress.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("id"), id + "%"));
		TypedQuery<Adress> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
		}
	
	public Adress save(Adress adress) {
		return manager.merge(adress);
	}
	
	public void remove(Adress adress) {
		adress = forId(adress.getId());
		manager.remove(adress);
	}
}
