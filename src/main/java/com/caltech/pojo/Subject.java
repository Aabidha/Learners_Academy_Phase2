package com.caltech.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "subject_name")
	private String subjectName;

	

	@Column(name = "classX")
	private String classX;

	// Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	public String getClassX() {
		return classX;
	}

	public void setClassX(String classX) {
		this.classX = classX;
	}

	// Constructors

	public Subject() {
		super();

	}

	public Subject(String subjectName) {
		super();

		this.subjectName = subjectName;
		

	}

	public Subject(String subjectName, String classX) {
		super();

		this.subjectName = subjectName;
		
		this.classX = classX;
	}

	public Subject(int id, String subjectName) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		

	}

	public Subject(int id, String subjectName, String classX) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		
		this.classX = classX;
	}

}
