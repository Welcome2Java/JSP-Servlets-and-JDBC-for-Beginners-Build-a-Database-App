package com.painter.servlet;

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

import com.painter.jdbc.Painter;
import com.painter.jdbc.dao.PainterDAO;


/**
 * Servlet implementation class PainterServlet
 */
@WebServlet("/PainterServlet")
public class PainterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private PainterDAO painterDao;

    
    @Resource(name="jdbc/painter")
	public DataSource dataSource;
    
    @Override
	public void init() throws ServletException {
		super.init();
		
		//create out student db utli and pass in the conn pool/datasouce
		try {
			painterDao = new PainterDAO(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			if(theCommand==null) {
				theCommand = "List";
			}switch(theCommand) {
			case "List":
				loadList(request, response);
				break;
			case "ADD":
				addCard(request, response);
				break;
			default:
				loadList(request, response);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addCard(HttpServletRequest request, HttpServletResponse response) throws Exception {

		 String name = request.getParameter("name");
		 String type = request.getParameter("type");
		 int quantity = Integer.valueOf(request.getParameter("quantity"));
		 String cost = request.getParameter("cost");
		 String description = request.getParameter("description");
		 String set = request.getParameter("CardSet");
		 
		 Painter newCard = new Painter(name,type,quantity,cost,description,set);
		 painterDao.addCard(newCard);
		 
		 loadList(request, response);
	}

	private void loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Painter> painter = painterDao.getPainter();
		
		request.setAttribute("painter_List", painter);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list_painter.jsp");
		dispatcher.forward(request, response);
	}

}
