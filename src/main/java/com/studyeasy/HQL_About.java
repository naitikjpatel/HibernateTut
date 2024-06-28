package com.studyeasy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQL_About {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration() 
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			//getting all the data from the users table
		List<Users>users=session.createQuery("from users").getResultList();
			
			//getting the data which full fill the condition : 1:with varible 2 without variable
//			int id=3;
//		List<Users>users=session.createQuery("from users where userId ="+id+"").getResultList();
		
//		List<Users>users=session.createQuery("from users where userId='1'").getResultList();
		
			//we can add multiple condition 
//			List<Users>users=session.createQuery("from users where userId='1' or username='username'").getResultList();
			for(Users temp:users) {
				System.out.println(temp);
			}
		
		
//		code for the Update Record:
			
		int i=session.createQuery("update users set password='nj098' where userId='6'").executeUpdate();
		if(i>0) {
			System.out.println("Update Successfully");
		}

		
		//code for the delete
		i=session.createQuery("delete from users where userId='5'").executeUpdate();
		if(i>0) {
			System.out.println("delete Done");
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			session.close();
			factory.close();
		}
								
	}
}
