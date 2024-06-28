package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.mavenproject.Student;

public class CriteriaExample {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();

		Criteria c = s.createCriteria(Student.class);
/*
//		all data mali jashe
		List<Student>students=c.list();
		for(Student st:students) {
			System.out.println(st);
		}
	*/
//		now we learn about the restriction
	/*
//		filter data
		c.add(Restrictions.eq("certi.course", "Android"));
*/
		
		c.add(Restrictions.gt("id",24));
		c.add(Restrictions.lt("id",24));
		c.add(Restrictions.like("certi.course","java%"));
		List<Student>students=c.list();
		for(Student st:students) {
			System.out.println(st);
		}
		s.close();
	}
}
