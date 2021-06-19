package com.usf.swing.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = 
			Persistence.createEntityManagerFactory("swing");
	
	public static EntityManager getEntityManager() {
		return ENTITY_MANAGER_FACTORY.createEntityManager();
	}
	
	public static void closeEntityManager(EntityManager entityManager) {
		entityManager.close();
	}
}
