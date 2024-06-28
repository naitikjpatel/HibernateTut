package com.oneTomany;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		
		//create a sessionFactory
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session session=sf.openSession();
		
		Question q =new Question();
		
		
		Answer a=new Answer();
		a.setId(1);
		a.setAnsName("jay shree ram");
		
		Answer a1=new Answer();
		a.setId(2);
		a.setAnsName("Ganpati dada");
		
		ArrayList<Answer> list1=new ArrayList<Answer>();
		list1.add(a);
		list1.add(a1);
		
		q.setId(1);
		q.setQname("About God");
		q.setAnswers(list1);
		
		session.save(q);
		session.save(a);
		session.save(a1);
		
		Transaction tx=session.beginTransaction();
		tx.commit();
		
		session.close();
		
	
		
	}
}
