package omw.controllers;

import omw.metier.AnnonceManager;
import omw.metier.UtilisateurManager;
import omw.model.Utilisateur;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MembreServlet extends GlobalInformationsServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void getRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("searchPersonneDansCovoit") != null){
			
			String login = request.getParameter("idMember");
			
		    Utilisateur user = UtilisateurManager.getInstance().getUser(login);
		    user.setNom(AnnonceManager.getInstance().ucfirst(user.getNom()));
		    user.setPrenom(AnnonceManager.getInstance().ucfirst(user.getPrenom()));
		    
		    String registered = user.getRegistered()+"";
		    
		    request.setAttribute("user_date", registered);
		    request.setAttribute("user", user);
		    
		    RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/membre.jsp");
			view.forward(request, response);
		}
	}
	

}