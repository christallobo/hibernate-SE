package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class FetchDemo {
	public static void main(String[] args) throws IOException {

//		get, load
		Configuration config = new Configuration();
//      config.configure();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

//		load
		Student student = (Student) session.load(Student.class, 108);
		Student student1 = (Student) session.load(Student.class, 108);
		System.out.println(student.getName());
		System.out.println(student1.getName());

//		get
//		Address address = (Address) session.get(Address.class, 2);
//		System.out.println(address.getStreet() + " : " + address.getCity());
//		
//		Address address1 = (Address) session.get(Address.class, 2);
//		System.out.println(address1.getStreet() + " : " + address1.getCity());

		session.close();
		sessionFactory.close();
	}
}
