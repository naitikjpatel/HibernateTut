package com.cascade;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.map.*;

public class CascadeExample {
	public static void main(String[] args) {
		SessionFactory f=new Configuration().configure().buildSessionFactory();
		Session s=f.openSession();
		
//		oneToMany
		Question q1=new Question();
		q1.setQuestionId(567);
		q1.setQuestion("What is Cascading.?");
		
		Answer a1=new Answer(23423,"In hibernate it is important concept");
		Answer a2=new Answer(255,"second ans");
		Answer a3=new Answer(35,"third ans");
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		
		Transaction tx=s.beginTransaction();
		/*
//		 * aa na karvu pade tena mate apre cascade karishu
		s.save(q1);
		s.save(a1);
		s.save(a2);
		s.save(a3);
		*/
		s.save(q1);
//		ahi cascade kari didhu apre have answer ne save karva padshe nahi
		tx.commit();
		
		
		s.close();
		f.close();
	}

}
