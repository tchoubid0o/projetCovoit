package omw.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnexionServlet extends GlobalInformationsServlet {


	private static final long serialVersionUID = -4927724527514530512L;
	

	@Override
	public void getRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/connexion.jsp");
		view.forward(request, response);
		System.out.println("test");
	}

	@Override
	public void postRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
