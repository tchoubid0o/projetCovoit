package omw.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class GlobalInformationsServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6724419434412485659L;

	public abstract void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public abstract void postRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		getRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		postRequest(request, response);
	}

}
