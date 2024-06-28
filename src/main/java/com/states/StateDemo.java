package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.tut.mavenproject.*;

public class StateDemo {
	public static void main(String[] args) {
		//practical of hibernate object states:
		//1)Transient state
		//2)Persistent state
		//3)Detached state
		//4)Remove state
		
		System.out.println("Example:");
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Creating Student object
		Student student=new Student();
		student.setId(1414);
		student.setName("peater");
		student.setCity("Abcd");
		student.setCerti(new Certificate("Java Hibernate","2 months"));
//		student :Transoent
		
//		save karishu tyre persistent ma jashe
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		s.save(student); 
//		persistent ma automatic update thai jay che
		student.setName("John");
		//persistent state->assoicated with database and session both
		tx.commit();
		
		s.close();
//		Datched state
//		student :Datched
		student.setName("Sachin");//avu kavathi database ma change thashe nahi and session ma object hashe nahi
		System.out.println(student);
		factory.close();
	}
}
