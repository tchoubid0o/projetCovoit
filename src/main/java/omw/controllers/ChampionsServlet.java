package omw.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.DatChampionManager;
import omw.model.DatChampion;

public class ChampionsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
  
    public ChampionsServlet() 
    {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<DatChampion> datChampions = DatChampionManager.getInstance().listerDatChampion();
		request.setAttribute("listDatChampions", datChampions);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/champions.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String libelle = request.getParameter("libelle");
		DatChampionManager.getInstance().removeDatChampion(libelle);
	}

}
