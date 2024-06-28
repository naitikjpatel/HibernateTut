package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.mavenproject.Student;



public class SecondCacheExample {
	public static void main(String[] args) {
		//secondlevel Cache ma problem ave che ->first level jevu excute thay che  
		
//		EhCacheRegionFactory=>packge name leva mate lakhyu hatu
//		EhcacheRegionFactory
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session s1=factory.openSession();
		//first
		Student stu1=s1.get(Student.class,4321);
		System.out.println(stu1);
		s1.close();
		
		
		Session s2=factory.openSession();
		//second
		Student stu2=s2.get(Student.class,4321);
		System.out.println(stu2);
		s2.close();
		
		
//		factory.close();
	}
}
