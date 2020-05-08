package com.aluren.servlet;

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

import com.aluren.jdbc.Aluren;
import com.aluren.jdbc.dao.AlruenDAO;
import com.nicfit.jdbc.Nicfit;


/**
 * Servlet implementation class AlurenServlet
 */
@WebServlet("/AlurenServlet")
public class AlurenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AlruenDAO alurenDAO;

	@Resource(name = "jdbc/painter")
	public DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		// create out student db utli and pass in the conn pool/datasouce
		try {
			alurenDAO = new AlruenDAO(dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");
			if (theCommand == null) {
				theCommand = "List";
			}
			switch (theCommand) {
			case "List":
				listDeck(request, response);
				break;
			case "ADD_ALuren":
				addCard(request, response);
				break;
//			case "UPDATE":
//				updateCard(request, response);
//				break;
//			case "LOAD":
//				loadList(request, response);
//				break;
//			case "DELETE":
//				deleteCard(request, response);
//				break;

			default:
				listDeck(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    

    private void addCard(HttpServletRequest request, HttpServletResponse response) throws Exception {

  		String name = request.getParameter("name");
  		String type = request.getParameter("type");
  		int quantity = Integer.valueOf(request.getParameter("quantity"));
  		String cost = request.getParameter("cost");
  		String set = request.getParameter("cardSet");

  		Aluren newCard = new Aluren(name, type, quantity, cost, set);
  		alurenDAO.addCard(newCard);

  		listDeck(request, response);
  	}
    
    private void listDeck(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Aluren> aluren = alurenDAO.getAluren();

		request.setAttribute("aluren_list", aluren);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-aluren.jsp");
		dispatcher.forward(request, response);
	}




}
