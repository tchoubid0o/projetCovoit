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
			
			request.setAttribute("villes", AnnonceManager.getInstance().listerVille());
			
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
		
		request.setAttribute("villes", AnnonceManager.getInstance().listerVille());
		
		if(request.getParameter("modifierProp") != null){
			
			Integer idProp = Integer.parseInt(request.getParameter("idProp"));
			
			String villeDepart = request.getParameter("villeDepartPropM");
			String villeArrivee = request.getParameter("villeArriveePropM");
			String date = request.getParameter("datePropM");
			String heure = request.getParameter("heurePropM");
			String minute = request.getParameter("minutePropM");
			String prix = request.getParameter("prixPropM");
			String nbPlace = request.getParameter("nbPlacePropM");
			String comment = request.getParameter("commentPropM");
	 
	        String[] etapes=request.getParameterValues("etapesPropM");
	        
	        AnnonceManager.getInstance().updateProposition(idProp, 0, villeDepart, villeArrivee, date, heure, minute, prix, nbPlace, comment, login, etapes);
	        
			
		}
		
		if(request.getParameter("modifierRech") != null){
			
			Integer idRech = Integer.parseInt(request.getParameter("idRech"));
			
			String villeDepart = request.getParameter("villeDepartRechM");
			String villeArrivee = request.getParameter("villeArriveeRechM");
			String date = request.getParameter("dateRechM");
			String heure = request.getParameter("heureRechM");
			String minute = request.getParameter("minuteRechM");
			String comment = request.getParameter("commentRechM");
	        
	        AnnonceManager.getInstance().updateRecherche(idRech, villeDepart, villeArrivee, date, heure, minute, comment, login);
			
		}

		if(request.getParameter("deleteAds") != null){
			Integer idProp = Integer.parseInt(request.getParameter("id"));
			
			String type = request.getParameter("type");
			
			AnnonceManager.getInstance().deleteAds(idProp, type);
		}
		
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

}