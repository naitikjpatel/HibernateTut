package com.oneTomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//  now we fetch the data from the database 
public class FetchD {

	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Question q=(Question)session.get(Question.class, 1);
		q.toString();
		System.out.println(q.getId());
		System.out.println(q.getQname());
		session.close();
		sf.close();
		
	}
}
