package omw.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.GlobalInformationsManager;
import omw.metier.UtilisateurManager;
import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;

public abstract class GlobalInformationsServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6724419434412485659L;

	public abstract void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public abstract void postRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = (String) request.getSession().getAttribute("login");		
		boolean estAdmin = UtilisateurManager.getInstance().estAdministateur(login);
		
		request.setAttribute("estAdmin", estAdmin);
	
		List<AnnonceProposition> last_offers = GlobalInformationsManager.getInstance().listLastOffers();
		List<AnnonceRecherche> last_searchs = GlobalInformationsManager.getInstance().listLastSearch();
		
		request.setAttribute("last_offers", last_offers);
		request.setAttribute("last_offers_size", last_offers.size());
		request.setAttribute("last_searchs", last_searchs);
		request.setAttribute("last_searchs_size", last_searchs.size());
		
		getRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		List<AnnonceProposition> last_offers = GlobalInformationsManager.getInstance().listLastOffers();
		List<AnnonceRecherche> last_searchs = GlobalInformationsManager.getInstance().listLastSearch();
		
		request.setAttribute("last_offers", last_offers);
		request.setAttribute("last_offers_size", last_offers.size());
		request.setAttribute("last_searchs", last_searchs);
		request.setAttribute("last_searchs_size", last_searchs.size());
		
		postRequest(request, response);
	}

}
