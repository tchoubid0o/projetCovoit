package omw.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.AnnonceManager;


public class RechercherServlet extends GlobalInformationsServlet {
	private static final long serialVersionUID = 1L;

	public void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("villes", AnnonceManager.getInstance().listerVille());
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/rechercher.jsp");
		view.forward(request, response);
	}

	public void postRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("villes", AnnonceManager.getInstance().listerVille());
		
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
