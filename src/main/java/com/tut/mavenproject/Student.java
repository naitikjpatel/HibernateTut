package com.tut.mavenproject;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

//class =Table
//class varible(instance)=table column


//@Entity denote the class as a table (Entity hoy te table create thay)
//change the enity name using a name attribute
//@Entity(name="student_details")
@Entity
//@Table(name="mystudents")  ->table name change kari shaky che
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY) //this for the second level cache enable karva mate
public class Student {
	
//	using @Id we make the primary key
	@Id
	private int id;
	private String name;
	private Certificate certi;
	private String city;
	
	public Certificate getCerti() {
		return certi;
	}
	public void setCerti(Certificate certi) {
		this.certi = certi;
	}
	
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		object print karishu tyre aa print thashe toString method
		return this.id+" : "+this.name+" : "+this.city;
	}
}


/*
 * Lecture 6

commonly use hibernate annotation

@Entity : use to mark any class as Entity  ->to create a table

@Table :use to change the table details

@Id : use to mark column as id (primary key)

@GeneratedValue -hibernate will automatically values for that using an internal sequence.
		therefore we don't have to set manually.

@Column :Can be used to specify column mappings.For example ,to change the column name in the associated 	table in databases
	->modify the column details

@Transient :THis tells hibernate not to save this field.
		4 mathi apre 3 j column banavavi hoy tena mate @Transient lakhvu
		->Transient thi te column database ma jashe nahi

@Temporal :@Temporal over a date field tells hiberante the format in which the data need to be saved

@Lob : @Lob tells hiberante that this is a large object,not a simple object

@OneToOne ,@OneToMany ,@ManyToOne ,@JoinColumn etc



   
 * */
