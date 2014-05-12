package omw.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.AnnonceManager;
import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;


public class TrouverServlet extends GlobalInformationsServlet{
	private static final long serialVersionUID = 1L;

	public void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = (String) request.getSession().getAttribute("login");
		if(login == null){
			
			login = "";
		}
		
		List<AnnonceProposition> propositions = AnnonceManager.getInstance().listerAnnonceProposition(login);
		request.setAttribute("propositions", propositions);
		request.setAttribute("propositions_size", propositions.size());
		
		List<AnnonceRecherche> propositionsp = AnnonceManager.getInstance().listerAnnonceRecherche(login);
		request.setAttribute("propositionsp", propositionsp);
		request.setAttribute("propositionsp_size", propositionsp.size());
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/trouver.jsp");
		view.forward(request, response);
	}

	public void postRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		

		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/trouver.jsp");
		view.forward(request, response);
	}

}
