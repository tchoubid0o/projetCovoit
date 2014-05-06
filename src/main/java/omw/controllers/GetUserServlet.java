package omw.controllers;

import omw.metier.AjaxContactManager;
import omw.metier.AnnonceManager;
import omw.metier.EtapesManager;
import omw.metier.UtilisateurManager;
import omw.model.Utilisateur;
import omw.model.Ville;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class GetUserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 5274442345250866770L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                       throws ServletException, IOException {	    
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/404.jsp");
		view.forward(request, response);
		//On n'autorise pas l'affichage de la page
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	                      throws ServletException, IOException {
		if(request.getParameter("seeMoreInfos") != null){
			
			String login = request.getParameter("login");
			
		    Utilisateur user = UtilisateurManager.getInstance().getUser(login);
		    user.setNom(AnnonceManager.getInstance().ucfirst(user.getNom()));
		    user.setPrenom(AnnonceManager.getInstance().ucfirst(user.getPrenom()));
		    
		    Gson gson = new Gson();
		    response.setContentType("application/json"); 
		    response.setCharacterEncoding("utf-8");
		    
		    String json = gson.toJson(user);	    
		    response.getWriter().write(json);
	    
		}
	}
}