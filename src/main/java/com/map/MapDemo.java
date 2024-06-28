package com.map;

import org.hibernate.Session;
import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
//		Session s=factory.openSession();
	
//		creating question
		Question q1=new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java?");
//		creating answer object
		Answer answer=new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is Programming language");
		answer.setQuestion(q1);
		
		Answer answer1=new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("with the help of java we can create the software");
		answer1.setQuestion(q1);
		
		Answer answer2=new Answer();
		answer2.setAnswerId(346);
		answer2.setAnswer("Java has different type of framework");
		answer2.setQuestion(q1);
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		q1.setAnswers(list);
		
//		q1.setAnswers(answer);
		
		/*
//		creating question
		Question q2=new Question();
		q2.setQuestionId(242);
		q2.setQuestion("what is collection framwork?");
//		creating answer object
		Answer answer11=new Answer();
		answer11.setAnswerId(344);
		answer11.setAnswer("Api to work with Object in Java");
		answer11.setQuestion(q2);
		
		q2.setAnswers(answer11);
		*/
		
		
//		session
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
//		s.save(q1);
//		s.save(q2);
//		s.save(answer);
//		s.save(answer11);
//		tx.commit();
		
		
		s.save(q1);
		s.save(answer);
		s.save(answer1);
		s.save(answer2);
//		fetching data
//		Question newQ=(Question)s.get(Question.class,1212);
//		System.out.println(newQ.getQuestion());
//		System.out.println(newQ.getAnswer().getAnswer());
//		tx.commit();
		/*
//		fetch data
//		one question na all answer
		Question q=(Question)s.get(Question.class, 1212);
		System.out.println(q.getQuestion());
		for (Answer a :q.getAnswers()) {
			System.out.println(a.getAnswer());
		}
		*/
		
//		fetch data using lazy and eager
		Question q=(Question)s.get(Question.class, 1212);
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		//lazy loading
//		System.out.println(q.getAnswers().size());
//		tx.commit();
		s.flush();
		s.close();
		factory.close();
	}
}
