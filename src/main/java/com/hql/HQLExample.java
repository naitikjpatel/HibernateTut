package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.tut.mavenproject.*;

public class HQLExample {
	public static void main(String[] args) {
		
		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s=f.openSession();
//		HQL
//		syntax:
//		String query="from Student";
//		String query="from Student";
		//String query="from Student where city='Lucknow'"; //city e varible che student class no
		//String query="from Student where city=:x"; //dynamic city check karva mate
		
//		alias apava mate
		String query="from Student as s where s.city=:x and s.name=:  n";
		
//		query fire karavmate aa qury banavi pade
		Query q=s.createQuery(query);
		q.setParameter("x", "Lucknow");
		q.setParameter("n", "Peter");
		
//		query fire karva mate 2 way che 1)unique result 2)list result(multiple result)
		//single result(unique result)
//		q.uniqueResult();
		
		//multiple result
//		q.list();
		
		List<Student>list=q.list();
		for(Student student:list) {
			System.out.println(student.getName()+" : "+student.getCerti().getCourse());
		}
		
		System.out.println("---------------------------------------------------");
//		delete karva mate trnscation joie
		Transaction tx=s.beginTransaction();
		/*
		 //*Delete query
		Query q1=s.createQuery("delete from Student where city=:c");
		q1.setParameter("c", "Abcd");
		int r=q1.executeUpdate();
		System.out.println("Deleted Row :"+r);
		*/
		/*
//		 * error
//		update Query
		Query q2=s.createQuery("update Student set city=:c where name:=n");
		q2.setParameter("c","Delhi");
		q2.setParameter("n","Peter");
		
		int r=q2.executeUpdate();
		System.out.println("Total Updated Rows :"+r);
		
		*/
		tx.commit();
		
		//how to excute join query ->Question and ans no use karishu oneToMany
		Query q3=s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answers as a");
		List<Object []>list3=q3.getResultList();
		for(Object[] arr:list3) {
			System.out.println(Arrays.toString(arr));
		}
		s.close();
		
		f.close();
	}
}
