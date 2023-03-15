package com.caltech.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;


	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private int age;

	@Column(name = "classX")
	private String classX;

	// Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClassX() {
		return classX;
	}

	public void setClassX(String classX) {
		this.classX = classX;
	}

	// Constructors

	public Teacher() {
		super();

	}

	public Teacher(String firstName, String lastName, int age) {
		super();

		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;

	}

	public Teacher(String firstName, String lastName, int age, String classX) {
		super();

		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.classX = classX;
	}

	public Teacher(int id,String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;

	}

	public Teacher(int id,  String firstName, String lastName, int age, String classX) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.classX = classX;
	}

}
