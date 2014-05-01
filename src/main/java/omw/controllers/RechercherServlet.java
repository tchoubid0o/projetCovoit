package omw.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.AnnonceManager;


public class RechercherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/rechercher.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String villeDepart = request.getParameter("villeDepart");
		String villeArrivee = request.getParameter("villeArrivee");
		String date = request.getParameter("date");
		String heure = request.getParameter("heure");
		String minute = request.getParameter("minute");
		String comment = request.getParameter("comment"); 
		
		String login = (String) request.getSession().getAttribute("login");
		
		AnnonceManager.getInstance().insertRecherche(villeDepart, villeArrivee, date, heure, minute, comment, login);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/rechercher.jsp");
		view.forward(request, response);
	}

}
