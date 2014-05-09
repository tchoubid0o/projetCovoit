package omw.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.AnnonceManager;
import omw.model.AnnonceProposition;

public class CalculateurServlet extends GlobalInformationsServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void getRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("villes", AnnonceManager.getInstance().listerVille());
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/calculateur.jsp");
		view.forward(request, response);
		
	}

	@Override
	public void postRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/calculateur.jsp");
			view.forward(request, response);	
	}

}
