package com.usf.swing.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.usf.swing.model.Beer;

public class BeerDAO {

	public void save(Beer beer) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(beer);
		entityManager.getTransaction().commit();
		JPAUtil.closeEntityManager(entityManager);
	}
	
	public void deleteBySku(String sku) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.createQuery("DELETE FROM Beer b WHERE b.sku = :sku")
			.setParameter("sku", sku)
			.executeUpdate();
		entityManager.getTransaction().commit();
		JPAUtil.closeEntityManager(entityManager);
	}
	
	public List<Beer> findAll() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		List<Beer> beers = entityManager.createQuery("SELECT b FROM Beer b ORDER BY b.id DESC", Beer.class)
				.getResultList();
		JPAUtil.closeEntityManager(entityManager);
		return beers;
	}
}
