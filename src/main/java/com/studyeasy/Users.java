package com.studyeasy;

import javax.persistence.*;

@Entity(name="users")
@Table(name="users")
public class Users {
	@Id //primary key
	@Column(name="user_id")
	int userId;
	
	@Column(name="username")
	String username;//here in the class and in database we have the same so we not required to write the name="username" we can spkip the this annotation attribute also
	
	@Column(name="password")
	String password;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	//here userid is auto increment so that's why we skip here
	public Users(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}
	
	
}
