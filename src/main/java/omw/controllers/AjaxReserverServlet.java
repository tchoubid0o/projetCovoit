package omw.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.AnnonceManager;

@WebServlet("/AjaxReserverServlet")
public class AjaxReserverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AjaxReserverServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/404.jsp");
		view.forward(request, response);
		//On n'autorise pas l'affichage de la page		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("reserverForm") != null){
			
			String login = (String) request.getSession().getAttribute("login");
			
			if(!login.equals("") && login != null){
				
				Integer idAnnonceProposition = Integer.parseInt(request.getParameter("idAnnonceProposition"));
				
				AnnonceManager.getInstance().ajouterDemandePourAnnonce(idAnnonceProposition, login);			
			}
			else{
				
				System.out.printf("user not logged");
			}
		}		
	}

}
