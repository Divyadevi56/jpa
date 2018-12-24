package com.cg.jpastart.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JPQLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		String sql = "SELECT stu FROM Student stu WHERE stu.studentId=1";
		TypedQuery<Student> query = (TypedQuery<Student>) em.createQuery(sql);
		//List<Student> list = query.getResultList();
		/*for(Student obj : list)
		{
			System.out.println("id = "+obj.getStudentId());
			System.out.println("name = "+obj.getName());
		}*/
		Student stu = (Student) query.getSingleResult();
		System.out.println("id = "+stu.getStudentId());
		System.out.println("name = "+stu.getName());
		em.getTransaction().begin();
		String sql1 = "UPDATE student stu SET stu.name=:sName WHERE stu.studentId=:id";
		Query query1 = em.createQuery(sql);
		query1.setParameter("sName", "Bharati");
		query1.setParameter("id", 4);
		int row = query1.executeUpdate();
		System.out.println(row);
		
	}

}
