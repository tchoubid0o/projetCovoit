package omw.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.AnnonceManager;
import omw.model.AnnonceProposition;


public class TrouverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<AnnonceProposition> propositions = AnnonceManager.getInstance().listerAnnonceProposition();
		request.setAttribute("propositions", propositions);
		request.setAttribute("propositions_size", propositions.size());
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/find.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/find.jsp");
		view.forward(request, response);
	}

}
