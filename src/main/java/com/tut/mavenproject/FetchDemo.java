 package com.tut.mavenproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
//		Here we fetch the data from the database
//		get ,load  ->aa session ni method che
		
//		session Factory->factory connection mate
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		
		Session session=factory.openSession();
		//get- student tabel ma apnne student ni id khabar che
//		identify means primary key nakhvi
		Student student=(Student)session.get(Student.class,103);
		System.out.println(student); //toString() method call thashe
		
//		load method return the proxy object
//		if we call the object method then load method actully excute the select query -> object.getId()
		Student student1=(Student)session.load(Student.class,103);
		System.out.println(student1); //toString() method call thashe
		
		
//		now we print the data from the addess table
//		get method store the data in the cache -> if in the cache data is not found then  get method hit's the database 
//		in get method if we not found the data then it return null
	Address ad1=(Address)session.get(Address.class, 2);
	System.out.println(ad1.getStreet()+" : "+ad1.getCity());
		session.close();
		factory.close();
		
	}
}
