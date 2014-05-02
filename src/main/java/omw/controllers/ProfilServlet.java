package omw.controllers;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import omw.metier.AnnonceManager;
import omw.metier.UtilisateurManager;
import omw.model.Utilisateur;

@MultipartConfig(fileSizeThreshold=1024*1024*10,    // 10 MB 
maxFileSize=1024*1024*50,          // 50 MB
maxRequestSize=1024*1024*100)      // 100 MB
public class ProfilServlet extends GlobalInformationsServlet{

	private static final long serialVersionUID = -7188152923285024456L;

	
	@Override
	public void getRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		String login = (String) request.getSession().getAttribute("login");
		if(login != null){
			
			Utilisateur user = UtilisateurManager.getInstance().getUser(login);
			
			/*LISTER SES ANNONCES*/
				/*Annonces Proposition*/
				request.setAttribute("propositions", AnnonceManager.getInstance().listerMesAnnonceProposition(login) );
				request.setAttribute("propositions_size", (AnnonceManager.getInstance().listerMesAnnonceProposition(login)).size() );
			
				/*Annonces Recherche*/
				request.setAttribute("recherches", AnnonceManager.getInstance().listerMesAnnonceRecherche(login) );
				request.setAttribute("recherches_size", (AnnonceManager.getInstance().listerMesAnnonceRecherche(login)).size() );
			
			request.setAttribute("user", user );
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/profil.jsp");
			view.forward(request, response);
		}
		else{
			request.setAttribute("erreurs", "<div class='erreur_message'>Vous devez être connecté pour visualiser cette page.</div>");
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/profil.jsp");
			view.forward(request, response);
		}
	}

	public void postRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> erreursMessage = new HashMap<String, String>();
		String login = (String) request.getSession().getAttribute("login");
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/profil.jsp");
		view.forward(request, response);
	}

}