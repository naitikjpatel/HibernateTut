package com.studyeasy;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;
public class App {

	public static void main(String[] args) {
		
		//when we intect with the database we need to use the sessionFactory to make the object of the session
		//using session we interect with the databases
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		App.insertMethod(session);
//		App.getData(session);
		
		/*
		//this code for the deletion
		try {
			
			//create object of entity class type
			//start transaction
			//perform operation
			//commit the transaction
			
			Users users=new Users();
			session.beginTransaction();
			users=session.get(Users.class, 1);
			//password update
			session.delete(users);
			session.getTransaction().commit();
			System.out.println("Record Delete Successfully");
			
		System.out.println(users);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
			factory.close();
		}
		
		
		*/
		
		/*
		//this code for the updatation
	try {
		
			//create object of entity class type
			//start transaction
			//perform operation
			//commit the transaction
			
			Users users=new Users();
			session.beginTransaction();
			users=session.get(Users.class, 1);
			//password update
			users.setPassword("njpatel1234");
			session.getTransaction().commit();
			
		System.out.println(users);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
			factory.close();
		}
		
		*/
		
		/*
		this code for the getData from the database
		try {
			
			//create object of entity class type
			//start transaction
			//perform operation
			//commit the transaction
			
			Users users=new Users();
			session.beginTransaction();
			users=session.get(Users.class, 2);
			
			session.getTransaction().commit();
			System.out.println(users.getFirstName());
			System.out.println(users.getLastName());
			System.out.println(users.getUsername());
		System.out.println(users);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
			factory.close();
		}
		*/
		
		
		
		
		
		/* Insert Code
		try {
			//create object of entity class type
			Users users=new Users("username","password","first_name","last_name");
			//start transaction
			session.beginTransaction();
			//perform operation
			session.save(users);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Row Added "+session);
		} catch (Exception e) {
			
		}
		finally {
			session.close();
			factory.close();
		}
		
		*/

	}
	
	
	public static void deleteRecord(Session session) {
		//this code for the deletion
				try {
					
					//create object of entity class type
					//start transaction
					//perform operation
					//commit the transaction
					
					Users users=new Users();
					session.beginTransaction();
					users=session.get(Users.class, 1);
					//password update
					session.delete(users);
					session.getTransaction().commit();
					System.out.println("Record Delete Successfully");
					
				System.out.println(users);
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					session.close();
				
				}
	}
	
	public static void updateRecord(Session session)
	{
		try {
			
			//create object of entity class type
			//start transaction
			//perform operation
			//commit the transaction
			
			Users users=new Users();
			session.beginTransaction();
			users=session.get(Users.class, 1);
			//password update
			users.setPassword("njpatel1234");
			session.getTransaction().commit();
			
		System.out.println(users);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();

		}
	}
	
	public static void getData(Session session) {
	try {
			
			//create object of entity class type
			//start transaction
			//perform operation
			//commit the transaction
			
			Users users=new Users();
			session.beginTransaction();
			users=session.get(Users.class, 2);
			
			session.getTransaction().commit();
			System.out.println(users.getFirstName());
			System.out.println(users.getLastName());
			System.out.println(users.getUsername());
		System.out.println(users);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		
		}
		
		
	}
	
	public  static void insertMethod(Session session) {

		try {
			//create object of entity class type
			Users users=new Users("username","password","first_name","last_name");
			//start transaction
			session.beginTransaction();
			//perform operation
			session.save(users);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Row Added "+session);
		} catch (Exception e) {
			
		}
		finally {
			session.close();
		
		}

	}

}
