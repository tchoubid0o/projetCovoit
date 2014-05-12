package omw.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.AnnonceManager;

public class ProposerServlet extends GlobalInformationsServlet{

	private static final long serialVersionUID = -4927724527514530512L;

	@Override
	public void getRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		request.setAttribute("villes", AnnonceManager.getInstance().listerVille());
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/proposer.jsp");
		view.forward(request, response);
	}

	@Override
	public void postRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		request.setAttribute("villes", AnnonceManager.getInstance().listerVille());
		
		String villeDepart = request.getParameter("villeDepart");
		String villeArrivee = request.getParameter("villeArrivee");
		String date = request.getParameter("date");
		String heure = request.getParameter("heure");
		String minute = request.getParameter("minute");
		String prix = request.getParameter("prix");
		String nbPlace = request.getParameter("nbPlace");
		String comment = request.getParameter("comment");
 
        String[] etapes=request.getParameterValues("etapes");
        
		
		String login = (String) request.getSession().getAttribute("login");
		
		AnnonceManager.getInstance().insertProposition(0, villeDepart, villeArrivee, date, heure, minute, prix, nbPlace, comment, login, etapes);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/proposer.jsp");
		view.forward(request, response);

	}
	
}
