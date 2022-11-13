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
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("project started");

		Configuration config = new Configuration();
//      config.configure();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();

//		Creating Student
		Student student = new Student();
		student.setId(102);
		student.setName("Christal");
		student.setCity("Mangalore");
		System.out.println(student);

//		Creating Address
		Address address = new Address();
		address.setStreet("Street 1");
		address.setCity("Delhi");
		address.setOpen(true);
		address.setAddedDate(new Date());
		address.setX(1234.1234);

//		Reading image
		FileInputStream fis = new FileInputStream("src/main/java/tree.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		address.setImage(data);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(student);
		session.save(address);

		tx.commit();
		session.close();

		System.out.println("Done...!!!");

//		System.out.println(sessionFactory);
//		System.out.println(sessionFactory.isClosed());
	}
}
