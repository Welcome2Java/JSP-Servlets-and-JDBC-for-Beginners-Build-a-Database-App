package com.training.servletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 * http://localhost:8080/ServletDemo/StudentServlet?firstName=Jon&lastName=Joo
	 * 
	 * good for debugging
	 * 
	 * bookmark or email url
	 * 
	 * limitations on data length
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 1 set content type
		response.setContentType("text/html");
		
		//Step get the printwriter
		PrintWriter out = response.getWriter();
		
		//step 3 generate the HTML content
		out.println("<html><body>");
		
		out.println("The student is confirmed: " + request.getParameter("firstName") + " " + request.getParameter("lastName"));
		
		out.println("</body></html>");
	}

	/*
	 * Can't bookmark or email url
	 * 
	 * No limitations on data length
	 * 
	 * can also send binary data
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
