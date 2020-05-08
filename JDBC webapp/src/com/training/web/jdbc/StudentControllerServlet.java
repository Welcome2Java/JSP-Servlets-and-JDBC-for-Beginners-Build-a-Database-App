package com.training.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentUtil studentUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	public DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create out student db utli and pass in the conn pool/datasouce
		try {
			studentUtil = new StudentUtil(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//list the students in MVC fashion
		try {
			//read the command
			
			//route it to appropriate method
			String theCommand = request.getParameter("command");
			if(theCommand==null) {
				theCommand = "List";
			}
			
			switch(theCommand) {
				case "List":
					listStudents(request, response);
					break;
				case "ADD":
					addStudent(request, response);
					break;
				case "LOAD":
					loadStudent(request, response);
					break;
				case "UPDATE":
					updateStudent(request, response);
					break;
				case "DELETE":
					deleteStudent(request, response);
					break;
				default:
					listStudents(request, response);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

			// read student id from form data
			String theStudentId = request.getParameter("studentId");
			
			// delete student from database
			studentUtil.deleteStudent(theStudentId);
			
			// send them back to "list students" page
			listStudents(request, response);
		}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// create a new student object
		Student theStudent = new Student(id, firstName, lastName, email);
		
		// perform update on database
		studentUtil.updateStudent(theStudent);
		
		// send them back to the "list students" page
		listStudents(request, response);
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read student id from the form data
		String id = request.getParameter("studentId");
	
		
		//get student from database
		Student theStudent = studentUtil.getStudents(id);
		
		//place student in the request attribute
		request.setAttribute("THE_STUDENT", theStudent);
		
		//send to jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//read the student info from the data
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
				
		//create a new student object
		Student newStudent = new Student(firstName, lastName, email);
				
		//add the student to the database.
		studentUtil.addStudent(newStudent);
		
		//send back to main page. 
		listStudents(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//get students from db util
		List<Student> students = studentUtil.getStudents();
		
		//add students to the request as an attribute
		request.setAttribute("Students_List", students);
		
		//send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}
}
