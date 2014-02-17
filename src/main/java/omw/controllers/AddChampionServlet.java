package omw.controllers;

import java.io.IOException;
import java.util.EmptyStackException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import omw.metier.DatChampionManager;
import omw.model.Ability;
import omw.model.Champion;
import omw.model.DatChampion;
import omw.model.Skin;

public class AddChampionServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/addChamp.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{			
		String[] parameterRequest = {"name","nickname","iconePathChamp","imagePathChamp","price","offense","defense","magie","difficulte","vie","vieLevel","mana","manaLevel","attaque","attaqueLevel","vitesseAttaque","vitesseAttaqueLevel","regenVie","regenVieLevel","regenMana","regenManaLevel","armure",
		"armureLevel","magicRes","magicResLevel","vitesse","passive","imagePathP","q","imagePathQ","w","imagePathW","e","imagePathE","r","imagePathR"};
		
		for(int i = 0 ; i < parameterRequest.length ; i++){
			if(request.getParameter(parameterRequest[i]) == null || request.getParameter(parameterRequest[i]) == "") throw (new EmptyStackException());
		}
		
		Champion champion = new Champion();
		
		DatChampion datChampion = new DatChampion(champion);
		
		Skin skin = new Skin();
		skin.setNumeroSkin(0);
		
		Ability abilityP = new Ability();
		abilityP.setLettreAbility("P");
		Ability abilityQ = new Ability();
		abilityQ.setLettreAbility("Q");
		Ability abilityW = new Ability();
		abilityW.setLettreAbility("W");
		Ability abilityE = new Ability();
		abilityE.setLettreAbility("E");
		Ability abilityR = new Ability();
		abilityR.setLettreAbility("R");
		
		champion.setLibelle(request.getParameter("name").replaceAll("[^a-zA-Z]", "").toLowerCase());
		champion.setNom(request.getParameter("name"));
		champion.setSousNom(request.getParameter("nickname"));
		champion.setImagePath(request.getParameter("iconePathChamp"));
		
		skin.setNomSkin(request.getParameter("name"));
		skin.setImagePath(request.getParameter("imagePathChamp"));
		
		try{
			skin.setPrice(Integer.parseInt(request.getParameter("price")));
			
			champion.setOffense(Integer.parseInt(request.getParameter("offense")));
			champion.setDefense(Integer.parseInt(request.getParameter("defense")));
			champion.setMagie(Integer.parseInt(request.getParameter("magie")));
			champion.setDifficulte(Integer.parseInt(request.getParameter("difficulte")));
			
			champion.setVie(Integer.parseInt(request.getParameter("vie")));
			champion.setVieLevel(Double.parseDouble(request.getParameter("vieLevel")));
			champion.setMana(Integer.parseInt(request.getParameter("mana")));
			champion.setManaLevel(Double.parseDouble(request.getParameter("manaLevel")));
			champion.setAttaque(Double.parseDouble(request.getParameter("attaque")));
			champion.setAttaqueLevel(Double.parseDouble(request.getParameter("attaqueLevel")));
			champion.setVitesseAttaque(Double.parseDouble(request.getParameter("vitesseAttaque")));
			champion.setVitesseAttaqueLevel(Double.parseDouble(request.getParameter("vitesseAttaqueLevel")));
			champion.setRegenVie(Double.parseDouble(request.getParameter("regenVie")));
			champion.setRegenVieLevel(Double.parseDouble(request.getParameter("regenVieLevel")));
			champion.setRegenMana(Double.parseDouble(request.getParameter("regenMana")));
			champion.setRegenManaLevel(Double.parseDouble(request.getParameter("regenManaLevel")));
			champion.setArmure(Double.parseDouble(request.getParameter("armure")));
			champion.setArmureLevel(Double.parseDouble(request.getParameter("armureLevel")));
			champion.setMagicRes(Double.parseDouble(request.getParameter("magicRes")));
			champion.setMagicResLevel(Double.parseDouble(request.getParameter("magicResLevel")));
			champion.setVitesse(Integer.parseInt(request.getParameter("vitesse")));
		}
		catch(NumberFormatException arg0){
			arg0.printStackTrace();
		}
		
		abilityP.setNomAbility(request.getParameter("passive"));
		abilityP.setImagePath(request.getParameter("imagePathP"));
		abilityQ.setNomAbility(request.getParameter("q"));
		abilityQ.setImagePath(request.getParameter("imagePathQ"));
		abilityW.setNomAbility(request.getParameter("w"));
		abilityW.setImagePath(request.getParameter("imagePathW"));
		abilityE.setNomAbility(request.getParameter("e"));
		abilityE.setImagePath(request.getParameter("imagePathE"));
		abilityR.setNomAbility(request.getParameter("r"));
		abilityR.setImagePath(request.getParameter("imagePathR"));
		
		datChampion.addAbility(abilityP);
		datChampion.addAbility(abilityQ);
		datChampion.addAbility(abilityW);
		datChampion.addAbility(abilityE);
		datChampion.addAbility(abilityR);
		
		datChampion.addSkin(skin);
		
		DatChampionManager.getInstance().addDatChampion(datChampion);
		
		response.sendRedirect("champions");
	}
		
}
