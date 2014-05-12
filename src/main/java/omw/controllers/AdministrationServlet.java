package omw.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.AnnonceManager;
import omw.metier.UtilisateurManager;
import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;
import omw.model.Utilisateur;


public class AdministrationServlet extends GlobalInformationsServlet {
	private static final long serialVersionUID = 1L;
    
    public AdministrationServlet() {
        super();     
    }

	@Override
	public void getRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String login = (String) request.getSession().getAttribute("login");
		List<Utilisateur> listUsers = null;
		List<AnnonceProposition> listAnnonceProp = null;
		List<AnnonceRecherche> listAnnonceRech = null;
		
		if(UtilisateurManager.getInstance().estAdministateur(login)){
			
			listUsers = UtilisateurManager.getInstance().listerUsers();
			listAnnonceProp = AnnonceManager.getInstance().listerAnnonceProposition("");
			listAnnonceRech = AnnonceManager.getInstance().listerAnnonceRecherche("");
		}
		
		request.setAttribute("listUsers", listUsers);	
		request.setAttribute("listAnnonceProp", listAnnonceProp);
		request.setAttribute("listAnnonceRech", listAnnonceRech);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/administration.jsp");
		view.forward(request, response);
	}

	@Override
	public void postRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
