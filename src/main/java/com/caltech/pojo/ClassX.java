package com.caltech.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.caltech.dao.SubjectDAO;
import com.caltech.dao.TeacherDAO;
import com.caltech.pojo.Subject;
import com.caltech.pojo.Teacher;

@Entity
@Table(name = "classes")
public class ClassX implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "subject_id")
	private int subjectId;

	@Column(name = "teacher_id")
	private int teacherId;

	

	//getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubjectId() {
		return subjectId;
	}
	public Subject getSubject() {
		SubjectDAO subjectDAO = new SubjectDAO();
		Subject subject = subjectDAO.getSubject(subjectId);
		return subject;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getTeacherId() {
		return teacherId;
	}
	
	public Teacher getTeacher() {
		TeacherDAO teacherDAO = new TeacherDAO();
		Teacher teacher = teacherDAO.getTeacher(teacherId);
		return teacher;
	}


	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}


	
	//constructors
	public ClassX() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassX(int id, int subjectId, int teacherId) {
		super();
		this.id = id;
		this.subjectId = subjectId;
		this.teacherId = teacherId;
	}

	public ClassX(int subjectId, int teacherId) {
		super();
		this.subjectId = subjectId;
		this.teacherId = teacherId;
	}
	
	
	
}
