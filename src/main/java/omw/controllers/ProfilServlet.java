package omw.controllers;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import omw.metier.AnnonceManager;
import omw.metier.UtilisateurManager;
import omw.model.Utilisateur;

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
				/*Les covoiturage*/
				request.setAttribute("covoitAccepte", AnnonceManager.getInstance().listerAnnoncePropositionLeConcernant(login, 1) );
				request.setAttribute("covoitAccepte_size", (AnnonceManager.getInstance().listerAnnoncePropositionLeConcernant(login, 1)).size() );
				
				request.setAttribute("covoitAttente", AnnonceManager.getInstance().listerAnnoncePropositionLeConcernant(login, 0) );
				request.setAttribute("covoitAttente_size", (AnnonceManager.getInstance().listerAnnoncePropositionLeConcernant(login, 0)).size() );
				
				request.setAttribute("covoitRefuse", AnnonceManager.getInstance().listerAnnoncePropositionLeConcernant(login, -1) );
				request.setAttribute("covoitRefuse_size", (AnnonceManager.getInstance().listerAnnoncePropositionLeConcernant(login, -1)).size() );
				
				
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
			
			response.sendRedirect("accueil");
		}
	}

	public void postRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = (String) request.getSession().getAttribute("login");
		
		if(login != null){
			request.setAttribute("villes", AnnonceManager.getInstance().listerVille());
			
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
			if(request.getParameter("editMySettings") != null){
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String password_verif = request.getParameter("password_verif");
				String telephone = request.getParameter("telephone");
				UtilisateurManager.getInstance().editMySettings(email, password, password_verif, telephone, login);
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
		else{
				
			response.sendRedirect("accueil");
		}
	}
}
