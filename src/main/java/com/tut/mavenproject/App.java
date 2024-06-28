package com.tut.mavenproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import org.hiberante.SessionFactory;
/**
 * Hello world!
 *
 */


//this is lecture 5 
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started..!" );
//        org.hibernate mathi import thavu joie
//        this is the 1st way
//        Configuration cfg=new Configuration();
//        cfg.configure();
//        SessionFactory sf=cfg.buildSessionFactory();
        
//        this is the 2nd way to create the sessionFactory object
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
//        
//        jo xml file no path change kariye to apre ahi akho path lakhvo pade che
//        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
//        factory.getCurrentSession();
        
//        creating student
        Student st=new Student();
        st.setId(105);
        st.setName("nj");
        st.setCity("Ayodhya");
        
////        2nd object of student 
//        Student st1=new Student();
//        st1.setId(103);
//        st1.setName("njp");
//        st1.setCity("Ayodhya");
//        
////      3nd object of student 
//      Student st2=new Student();
//      st2.setId(104);
//      st2.setName("njpatel");
//      st2.setCity("Ayodhya");

        
        System.out.println(st);
        
//        lecture 7
//        creating object of address class
        Address ad=new Address();
        ad.setStreet("street1");
        ad.setCity("delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.34);
        
//        Reading Image
        FileInputStream fis=new FileInputStream("src/main/java/pic.png"); //this thorw the IOException
//        1 st way ->Data read karva mate apre byte type no array banavi shakiye 
//        2nd way-> Direct
//        This is the First Way
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        
//        save(st);
        
//        factory apane ne session ape che
//        session jode save method che
//       Session session= factory.getCurrentSession();
//        Session session=factory.openSession();
       
//       start transaction
       /*
//        * this is the first way for the start transction
       session.beginTransaction();
       session.save(st);
       
       session.getTransaction().commit();
       
       session.close();
       */
       
//       2nd way to start transcation ->here we save the Student object st
        Session session=factory.openSession();
      Transaction tx= session.beginTransaction();
      session.save(st);
//      session.save(st1);
//      session.save(st2);
//      now here we save the Address object ->ad
      session.save(ad);
      tx.commit();
      session.close();
      
      System.out.println("Done");
       
    }
}
