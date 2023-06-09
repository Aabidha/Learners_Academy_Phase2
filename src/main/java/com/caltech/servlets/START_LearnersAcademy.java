package com.caltech.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caltech.dao.AdminDAO;
import com.caltech.dao.ClassDAO;
import com.caltech.dao.StudentDAO;
import com.caltech.dao.SubjectDAO;
import com.caltech.dao.TeacherDAO;
import com.caltech.pojo.Admin;
import com.caltech.pojo.ClassX;
import com.caltech.pojo.Student;
import com.caltech.pojo.Subject;
import com.caltech.pojo.Teacher;

@WebServlet("/admin-registration-initial")
public class START_LearnersAcademy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AdminDAO adminDAO;
	StudentDAO studentDAO;
	SubjectDAO subjectDAO;
	TeacherDAO teacherDAO;
	ClassDAO classDAO;

	public void init(ServletConfig config) throws ServletException {
		adminDAO = new AdminDAO();
		studentDAO = new StudentDAO();
		subjectDAO = new SubjectDAO();
		teacherDAO = new TeacherDAO();
		classDAO = new ClassDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Admin starter
		Admin admin1 = new Admin("Mary", "Anderson", "mary.anderson", "moon123");
		Admin admin2 = new Admin("John", "Smith", "john.smith", "star98765");
		Admin admin3 = new Admin("Sarah", "Brown", "sarah.brown", "ps1987");
		Admin admin4 = new Admin("William", "Nelson", "william.nelson", "butterfly2022");
		adminDAO.saveAdmin(admin1);
		adminDAO.saveAdmin(admin2);
		adminDAO.saveAdmin(admin3);
		adminDAO.saveAdmin(admin4);

		// Student starter
		Student student1 = new Student("001/2022", "James", "Davis", 20);
		Student student2 = new Student("002/2022", "Elizabeth", "Nelson", 23);
		Student student3 = new Student("003/2022", "George", "Jones", 19);
		Student student4 = new Student("004/2022", "Martha", "Johnson", 21);
		Student student5 = new Student("005/2022", "Henry", "Clark", 22);
		Student student6 = new Student("006/2022", "Margaret", "Nelson", 23);
		Student student7 = new Student("007/2022", "Thomas", "Anderson", 20);
		Student student8 = new Student("008/2022", "Nancy", "Johnson", 21);
		Student student9 = new Student("009/2022", "Charles", "Miller", 19);
		Student student10 = new Student("010/2022", "Ann", "Wilson", 23);
		studentDAO.saveStudent(student1);
		studentDAO.saveStudent(student2);
		studentDAO.saveStudent(student3);
		studentDAO.saveStudent(student4);
		studentDAO.saveStudent(student5);
		studentDAO.saveStudent(student6);
		studentDAO.saveStudent(student7);
		studentDAO.saveStudent(student8);
		studentDAO.saveStudent(student9);
		studentDAO.saveStudent(student10);

		// Use those names for other instances later on

		// Catherine Moore
		// David Hill
		// Hannah Thompson
		// Daniel Jackson

		// teacher starter
		Teacher teacher1 = new Teacher("Jane", "Taylor", 49);
		Teacher teacher2 = new Teacher("Joseph", "Hernandez", 54);
		Teacher teacher3 = new Teacher("Eliza", "Walker", 60);
		Teacher teacher4 = new Teacher("Samuel", "Gonzalez", 57);
		Teacher teacher5 = new Teacher("Margaret", "Wilson", 37);
		teacherDAO.saveTeacher(teacher1);
		teacherDAO.saveTeacher(teacher2);
		teacherDAO.saveTeacher(teacher3);
		teacherDAO.saveTeacher(teacher4);
		teacherDAO.saveTeacher(teacher5);

		// Subject starter
		Subject subject1 = new Subject("English");
		Subject subject2 = new Subject("Mathematics");
		Subject subject3 = new Subject("Chemistry");
		Subject subject4 = new Subject("Biology");
		Subject subject5 = new Subject("History");
		Subject subject6 = new Subject("Art");
		Subject subject7 = new Subject("Geography");

		subjectDAO.saveSubject(subject1);
		subjectDAO.saveSubject(subject2);
		subjectDAO.saveSubject(subject3);
		subjectDAO.saveSubject(subject4);
		subjectDAO.saveSubject(subject5);
		subjectDAO.saveSubject(subject6);
		subjectDAO.saveSubject(subject7);

		// Class starter
		ClassX classX1 = new ClassX();
		classX1.setSubjectId(subject1.getId());
		classX1.setTeacherId(teacher1.getId());

		classDAO.saveClassX(classX1);
		subject1.setClassX(classX1.getSubject().getSubjectName());
		subjectDAO.updateSubject(subject1);
		teacher1.setClassX(classX1.getSubject().getSubjectName());
		teacherDAO.updateTeacher(teacher1);
		student1.setClassX(classX1.getSubject().getSubjectName());
		student2.setClassX(classX1.getSubject().getSubjectName());
		studentDAO.updateStudent(student1);
		studentDAO.updateStudent(student2);

		ClassX classX2 = new ClassX();
		classX2.setSubjectId(subject2.getId());
		classX2.setTeacherId(teacher2.getId());

		classDAO.saveClassX(classX2);
		subject2.setClassX(classX2.getSubject().getSubjectName());
		subjectDAO.updateSubject(subject2);
		teacher2.setClassX(classX2.getSubject().getSubjectName());
		teacherDAO.updateTeacher(teacher2);
		student3.setClassX(classX2.getSubject().getSubjectName());
		student4.setClassX(classX2.getSubject().getSubjectName());
		studentDAO.updateStudent(student3);
		studentDAO.updateStudent(student4);

		ClassX classX3 = new ClassX();
		classX3.setSubjectId(subject3.getId());
		classX3.setTeacherId(teacher3.getId());
	
		classDAO.saveClassX(classX3);
		subject3.setClassX(classX3.getSubject().getSubjectName());
		subjectDAO.updateSubject(subject3);
		teacher3.setClassX(classX3.getSubject().getSubjectName());
		teacherDAO.updateTeacher(teacher3);
		student5.setClassX(classX3.getSubject().getSubjectName());
		student6.setClassX(classX3.getSubject().getSubjectName());
		studentDAO.updateStudent(student5);
		studentDAO.updateStudent(student6);

		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-registration-initial.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		adminAdd_thanLogin(request, response);
	}

	private void adminAdd_thanLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Creating list of all Admin from database
		List<Admin> listOfAdmin = adminDAO.getAllAdmin();

		boolean shouldSaveAdmin = true;

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Preventing duplicate username
		for (Admin admin : listOfAdmin) {
			String tempUsername = admin.getUsername();
			if (tempUsername.equalsIgnoreCase(username)) {

				shouldSaveAdmin = false;

				request.setAttribute("errorMessage",
						"The username you entered: > " + username + " < is already taken, please try again!");

				RequestDispatcher dispatcher = request.getRequestDispatcher("admin-registration-initial.jsp");
				// The code below will case an error but that is OK
				dispatcher.forward(request, response);

			}
		}

		if (shouldSaveAdmin) {
			Admin admin = new Admin();
			admin.setFirstName(firstName);
			admin.setLastName(lastName);
			admin.setUsername(username);
			admin.setPassword(password);

			adminDAO.saveAdmin(admin);

			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}

	}

}
