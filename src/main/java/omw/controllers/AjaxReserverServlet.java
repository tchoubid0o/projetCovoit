package omw.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import omw.metier.AnnonceManager;

@WebServlet("/AjaxReserverServlet")
public class AjaxReserverServlet extends GlobalInformationsServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void getRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void postRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
if(request.getParameter("reserverForm") != null){
			
			String login = (String) request.getSession().getAttribute("login");
			
			if(!login.equals("") && login != null){
				
				Integer idAnnonceProposition = Integer.parseInt(request.getParameter("idAnnonceProposition"));
				
				AnnonceManager.getInstance().ajouterDemandePourAnnonce(idAnnonceProposition, login);	// ajout d'une demande pour un covoiturage		
			}
			else{
				
				System.out.printf("user not logged");
			}
		}
		else if(request.getParameter("typeDemande").equals("voirDetail")){
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/404.jsp");
			view.forward(request, response);			
		}
		else if(request.getParameter("typeDemande").equals("accepterDansCovoit")){
			
			Integer idAP = Integer.parseInt(request.getParameter("idAP"));
			String loginDesirEtreDansCovoit = request.getParameter("loginDesirEtreDansCovoit");
			
			boolean result = AnnonceManager.getInstance().accepterDemandePourAnnonce(idAP, loginDesirEtreDansCovoit);	// acceptation d'une demande pour un covoiturage si false alors il n'y a plus assez de place dans le covoit
			
			Gson gson = new Gson();
		    response.setContentType("application/json"); 
		    response.setCharacterEncoding("utf-8");
		    
		    String json = gson.toJson(result);	    
		    response.getWriter().write(json);
		}
		else if(request.getParameter("typeDemande").equals("refusePourCovoit")){
			
			Integer idAP = Integer.parseInt(request.getParameter("idAP"));
			String loginDesirEtreDansCovoit = request.getParameter("loginDesirEtreDansCovoit");
			
			AnnonceManager.getInstance().refuserDemandePourAnnonce(idAP, loginDesirEtreDansCovoit);	// refus d'une demande pour un covoiturage			
		}
	}

}
