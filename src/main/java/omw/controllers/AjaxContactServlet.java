package omw.controllers;

import omw.metier.AjaxContactManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class AjaxContactServlet extends GlobalInformationsServlet{
	
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
		String erreursMessage = null;
		
	    String email = request.getParameter("email");
	    String nom = request.getParameter("nom");
	    String message = request.getParameter("message");
	    
	  //Validation pseudo
        try {
            validationEmail(email);
            try {
            	validationNotEmpty(nom);
            	 try {
                 	validationNotEmpty(message);
                    if ( erreursMessage == null ) {
            		    erreursMessage = AjaxContactManager.getInstance().addContactMessage(email,nom,message);
            		    Gson gson = new Gson();
            		    response.setContentType("application/json"); 
            		    response.setCharacterEncoding("utf-8");
            		    
            		    String json = gson.toJson(erreursMessage);
            		    
            		    response.getWriter().write(json);
                    }
                 } catch ( Exception e ) {
                     erreursMessage = e.getMessage();
                 }
            } catch ( Exception e ) {
            	erreursMessage = e.getMessage();
            }
        } catch ( Exception e ) {
        	erreursMessage = e.getMessage();
        }
	}
	
	private void validationEmail(String user_mail) throws Exception {
		if ( user_mail != null && user_mail.trim().length() != 0 ) {
			if ( !user_mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				throw new Exception( "<div style='color: #ea3c3d;'>Merci de saisir une adresse mail valide.</div>" );
			}
		} else {
			throw new Exception( "<div style='color: #ea3c3d;'>Merci de saisir une adresse mail.</div>" );
		}
	}
	private void validationNotEmpty(String maString) throws Exception {
		if ( maString == null || maString.trim().length() == 0 ) {
			throw new Exception( "<div style='color: #ea3c3d;'>Vous devez remplir tous les champs.</div>" );
		}
	}
}
