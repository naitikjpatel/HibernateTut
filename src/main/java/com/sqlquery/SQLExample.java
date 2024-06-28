package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.mavenproject.Student;

public class SQLExample {
	public static void main(String[] args) {
		SessionFactory f=new Configuration().configure().buildSessionFactory();
		Session s=f.openSession();
		
//		THis is SQL Query
		String q="select * from student";
		NativeQuery nq = s.createSQLQuery(q); //ctrl+1 ->NativeQuery ni place ma Query lakho to pan chale
		
		System.out.println("No data");
	List<Object []>list=nq.list();
	for(Object[] st:list) {
//		System.out.println(Arrays.toString(st));
		System.out.println(st[4]+" : "+st[3]);
	}
		
		s.close();
		f.close();
	}
}
