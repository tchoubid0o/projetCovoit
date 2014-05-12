package omw.controllers;

import omw.metier.AjaxNewsletterManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class AjaxNewsletterServlet extends GlobalInformationsServlet{
	
	private static final long serialVersionUID = 5274442345250866770L;

	@Override
	public void getRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
	    String result = AjaxNewsletterManager.getInstance().addMailInNewsletter(email);
	    Gson gson = new Gson();
	    response.setContentType("application/json"); 
	    response.setCharacterEncoding("utf-8");
	    
	    String json = gson.toJson(result);	    
	    response.getWriter().write(json);
	}


}
