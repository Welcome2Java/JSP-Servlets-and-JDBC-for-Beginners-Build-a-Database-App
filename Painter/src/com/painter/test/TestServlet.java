package com.painter.test;

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
  	@Resource(name="jdbc/painter")
  	public DataSource dataSource;
  	
	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/plain");
		
		Connection myConn = null;
		Statement  myStat = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			String sql = "select * from painter";
			myStat = myConn.createStatement();
			myRs = myStat.executeQuery(sql);
			
			while(myRs.next()) {
				String name = myRs.getString("name");
				String type = myRs.getString("type");
				printWriter.println(name + "          " + type);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
