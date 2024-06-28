package com.firstlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.tut.mavenproject.*;

public class FirstDemo {
	public static void main(String[] args) {
		SessionFactory f=new Configuration().configure().buildSessionFactory();
		Session s=f.openSession();
		
//		Firstlevel cache by default enable hoy
		Student student=s.get(Student.class,1234);
		System.out.println(student);
		System.out.println("working someting..");
		
		Student student1=s.get(Student.class,1234);
		System.out.println(student1);
		
		System.out.println(s.contains(student1));
		s.close();
		f.close();
	}

}
