package com.forExam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sf.openSession();
		
		Employee e=new Employee();
		e.setId(101);
		e.setFirstname("nj");
		e.setLastname("patel");
		
		Transaction tx=session.beginTransaction();
		
		session.save(e);
		
		tx.commit();
		session.close();
	}
}
