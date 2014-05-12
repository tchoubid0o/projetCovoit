package omw.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeconnexionServlet extends GlobalInformationsServlet{

	private static final long serialVersionUID = -8044405890640694131L;

	@Override
	public void getRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		request.getSession().removeAttribute("login");
		request.getSession().removeAttribute("email");
		request.getSession().removeAttribute("nom");
		request.getSession().removeAttribute("prenom");
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/deconnexion.jsp");
		view.forward(request, response);
	}

	@Override
	public void postRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
