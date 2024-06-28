package com.maping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		
//		new Person
		Person p=new Person(223,"Ram","Delhi","5434");
		
		s.save(p);
		
		tx.commit();
		s.close();
		f.close();
	}

}
