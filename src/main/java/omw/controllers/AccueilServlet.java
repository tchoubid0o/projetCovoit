package omw.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.AnnonceManager;
import omw.model.AnnonceProposition;

public class AccueilServlet extends GlobalInformationsServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void getRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("villes", AnnonceManager.getInstance().listerVille());
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/accueil.jsp");
		view.forward(request, response);
		
	}

	@Override
	public void postRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("villes", AnnonceManager.getInstance().listerVille());
		// TODO Auto-generated method stub
		if(request.getParameter("searchCarProp") != null){
			String villeDepart = request.getParameter("villeDepart").toLowerCase();
			String villeArrivee = request.getParameter("villeArrivee").toLowerCase();
			
			List<AnnonceProposition> liste = AnnonceManager.getInstance().listerRechercheProposition(villeDepart, villeArrivee);
			
			request.setAttribute("listeAnnonces", liste);
			request.setAttribute("listeAnnonces_size", liste.size());
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/accueil.jsp");
			view.forward(request, response);	
		}
	}

}
