package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			List<Student> students = session.createQuery("from Student").getResultList();

			displayStudents(students);
			students = session.createQuery("from Student s where s.lastName='Amrein'").getResultList();
			
			displayStudents(students);

			students = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Kevin'").getResultList();
			displayStudents(students);
			
			
			students = session.createQuery("from Student s where s.email LIKE '%demo.com'").getResultList();
			displayStudents(students);
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			session.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		students.forEach(s -> System.out.println(s));
	}
}
