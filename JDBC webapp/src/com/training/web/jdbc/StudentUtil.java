package com.training.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentUtil {
	
	private DataSource dataSource;

	public StudentUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//method to list the students
	@SuppressWarnings("finally")
	public List<Student> getStudents() throws Exception{
	
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement  myStat = null;
		ResultSet myRs = null;
		
		// get a connection
		try {
			myConn = dataSource.getConnection();
			
			//Step 3. Create a SQL statement
			String sql = "select * from Student order by last_name";
			myStat = myConn.createStatement();
			
			//Step 4 execute SQL query
			myRs = myStat.executeQuery(sql);
			
			//Step 5 Process the result set
			while(myRs.next()) {
				
				//retrieve data from result set row
				int id = Integer.valueOf(myRs.getString("id"));
				String email = myRs.getString("email");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				
				//create new student object
				Student student = new Student(id, firstName, lastName, email);

				//add it to the list
				students.add(student);
			}
			return students;
			
		} finally {
			//close JDBC objects
			close(myConn, myStat, myRs);
		}
	}

	public void addStudent(Student newStudent) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement  myStat = null;

		try {
			myConn = dataSource.getConnection();
			
			//Step 1 create sql for insert
			String sql = "insert into student (first_name, last_name, email) values(?, ?, ?)"  ;
			myStat = myConn.prepareStatement(sql);
			
			//set the param value for the student
			 myStat.setString(1, newStudent.getFirstName());
			 myStat.setString(2, newStudent.getLastName());
			 myStat.setString(3, newStudent.getEmail());
			
			//execute sql insert
			myStat.execute();
		} finally {
			//clean up JDBC
			close(myConn, myStat, null);
		}	
	}
	
	
	private void close(Connection myConn, Statement myStat, ResultSet myRs) {
		try {
			if(myRs != null) {
				myRs.close(); //just puts back in connection pool. make it free for someone else to use. 
			}
			if(myStat != null) {
				myStat.close();
			}
			if(myConn != null) {
				myConn.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public Student getStudents(String id) throws Exception {
Student theStudent = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;
		
		try {
			// convert student id to int
			studentId = Integer.parseInt(id);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from student where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, studentId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				// use the studentId during construction
				theStudent = new Student(studentId, firstName, lastName, email);
			}
			else {
				throw new Exception("Could not find student id: " + studentId);
			}				
			
			return theStudent;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateStudent(Student theStudent) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStat = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update student "
						+ "set first_name=?, last_name=?, email=? "
						+ "where id=?";
			
			// prepare statement
			myStat = myConn.prepareStatement(sql);
			
			// set params
			myStat.setString(1, theStudent.getFirstName());
			myStat.setString(2, theStudent.getLastName());
			myStat.setString(3, theStudent.getEmail());
			myStat.setInt(4, theStudent.getId());
			
			// execute SQL statement
			myStat.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStat, null);
		}
		
	}

	public void deleteStudent(String theStudentId)  throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int studentId = Integer.parseInt(theStudentId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from student where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, studentId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}
