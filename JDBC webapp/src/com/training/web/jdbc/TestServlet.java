package com.training.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Define datasource/connection pool for resource injection. 
	@Resource(name="jdbc/web_student_tracker")
	public DataSource dataSource;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step 1 set up the printwriter
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/plain");
		
		//Step 2 getting a connection to the database
		Connection myConn = null;
		Statement  myStat = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			//Step 3. Create a SQL statement
			String sql = "select * from Student";
			myStat = myConn.createStatement();
			
			//Step 4 execute SQL query
			myRs = myStat.executeQuery(sql);
			
			//Step 5 Process the result set
			while(myRs.next()) {
				String email = myRs.getString("email");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				printWriter.println(firstName + " " + lastName + " " + email);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
