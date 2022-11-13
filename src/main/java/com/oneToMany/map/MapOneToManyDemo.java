package com.oneToMany.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapOneToManyDemo {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();

//		Creating Question
		Question question = new Question();
		question.setQuestionId(1212);
		question.setQuestion("What is Java?");

		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is a Programming language");
		answer.setQuestion(question);
		question.setAnswer(answer);

//		Creating Question
		Question question1 = new Question();
		question1.setQuestionId(242);
		question1.setQuestion("What is collection framework?");

		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("API to work with group of objects");
		answer1.setQuestion(question1);
		question1.setAnswer(answer1);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

//		Save
		session.save(question);
		session.save(question1);
		session.save(answer);
		session.save(answer1);
		tx.commit();

//		fetching
		Question que = (Question) session.get(Question.class, 242);
		System.out.println(que.getQuestion());
		System.out.println(que.getAnswer().getAnswer());

		session.close();
		sessionFactory.close();
	}

}
