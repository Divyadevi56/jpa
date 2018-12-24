package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = 
				factory.createEntityManager();
		Student obj = em.find(Student.class, 1);
		System.out.println("id = "+obj.getStudentId());
		System.out.println("name ="+obj.getName());
		obj.setName("Bharati");
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		em.close();
	}

}
