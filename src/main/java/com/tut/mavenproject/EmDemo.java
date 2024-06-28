package com.tut.mavenproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Student student1=new Student();
		student1.setId(14134);
		student1.setName("Nj Patel");
		student1.setCity("Mahesana");
		
		Certificate certificate=new Certificate();
		certificate.setCourse("CSE");
		certificate.setDuration("4years");
		
		student1.setCerti(certificate);
		
//		student 2
		Student student2=new Student();
		student2.setId(1212);
		student2.setName("jn Patel");
		student2.setCity("Ghandhinagar");
		
		Certificate certificate1=new Certificate();
		certificate1.setCourse("Data Science");
		certificate1.setDuration("2years");
		
		student2.setCerti(certificate1);
		
//		session
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
//		save object
		session.save(student1);
		session.save(student2);
		tx.commit();
		
		session.close();
		
		factory.close();
	}
}
