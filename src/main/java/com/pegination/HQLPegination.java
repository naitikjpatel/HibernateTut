package com.pegination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.mavenproject.Student;

public class HQLPegination {
	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Session s=factory.openSession();
		
//		Query<Student> query =s.createQuery("from Student ",Student.class);
		
		Query query=s.createQuery("from Student");
		
//		implementing pegination using hibernate
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		List<Student> list=query.list();
		for(Student student:list) {
			System.out.println(student.getId()+" : "+student.getName()+" : "+student.getCity());
		}
		
		s.close();
		factory.close();
		
	}
}
