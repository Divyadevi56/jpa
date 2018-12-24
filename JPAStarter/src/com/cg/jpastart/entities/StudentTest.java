package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentTest {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = new Student();
		student.setName("Divya");
		
		em.persist(student);
		
		
		System.out.println("Added one student to database.");
		
		/*Student stu = em.find(Student.class, 1);
		System.out.println("Stu id = "+stu.getStudentId());
		System.out.println("Stu name = "+stu.getName());
		
		stu.setName("Ritu");
		em.merge(stu);*/
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
