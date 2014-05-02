package omw.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.EtapesManager;
import omw.model.Ville;

import com.google.gson.Gson;

public class EtapesServlet extends GlobalInformationsServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void getRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
	    List<Ville> result = EtapesManager.getInstance().listerEtape(1);
	    Gson gson = new Gson();
	    response.setContentType("application/json"); 
	    response.setCharacterEncoding("utf-8");
	    
	    String json = gson.toJson(result);	    
	    response.getWriter().write(json);
		
		//RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/etapes.jsp");
		//view.forward(request, response);	
	}

	@Override
	public void postRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
	    List<Ville> result = EtapesManager.getInstance().listerEtape(id);
	    Gson gson = new Gson();
	    response.setContentType("application/json"); 
	    response.setCharacterEncoding("utf-8");
	    
	    String json = gson.toJson(result);	    
	    response.getWriter().write(json);
	}

}