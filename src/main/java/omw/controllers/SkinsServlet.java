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
import omw.model.Skin;

public class SkinsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
  
    public SkinsServlet() 
    {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<DatChampion> datChampions = DatChampionManager.getInstance().listerDatChampion();
		request.setAttribute("listDatChampions", datChampions);	
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/skins.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		String libelle = request.getParameter("libelle");		
		
		if(libelle != null && libelle != ""){
			DatChampionManager.getInstance().removeDatChampion(libelle);			
		}
		
		String libelleChampion = request.getParameter("libelleChampion");
		String nomSkin = request.getParameter("nomSkin");
		String imagePathSkin = request.getParameter("imagePathSkin");
		
		int priceSkin=0;
		int numeroSkin=0;
		try{
			priceSkin = Integer.parseInt(request.getParameter("priceSkin"));
			numeroSkin = Integer.parseInt(request.getParameter("numeroSkin")) + 1;
		}
		catch(NumberFormatException arg0){
			arg0.printStackTrace();
		}
		
		if(libelleChampion != null && libelleChampion != "" && nomSkin != null && nomSkin != "" && imagePathSkin != null && imagePathSkin != ""){
			
			Skin skin = new Skin();
			
			skin.setNomSkin(nomSkin);
			skin.setImagePath(imagePathSkin);
			skin.setPrice(priceSkin);
			skin.setNumeroSkin(numeroSkin);
			
			DatChampionManager.getInstance().addSkin(skin, libelleChampion);
			
			response.sendRedirect("skins");
		}
	}

}