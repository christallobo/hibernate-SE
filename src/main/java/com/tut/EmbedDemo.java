package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();

//		Creating Student
		Student student = new Student();
		student.setId(110);
		student.setName("Tiwari");
		student.setCity("Lucknow");

		Certificate certificate = new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 months");
		student.setCertificate(certificate);

		Student student1 = new Student();
		student1.setId(118);
		student1.setName("Ravi");
		student1.setCity("Jaipur");

		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Java");
		certificate1.setDuration("3 months");
		student1.setCertificate(certificate1);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

//		Object save
		session.save(student);
		session.save(student1);
		
		tx.commit();

		session.close();
		sessionFactory.close();
	}

}
