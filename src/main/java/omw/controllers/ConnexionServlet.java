package omw.controllers;

import omw.metier.UtilisateurManager;

import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnexionServlet extends GlobalInformationsServlet{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5104843472431401461L;

	@Override
	public void getRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/connexion.jsp");
		view.forward(request, response);
	}

	@Override
	public void postRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> erreursMessage = new HashMap<String, String>();

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String resultat = "";

		//Validation pseudo
		try {
			validationPseudo(login);
		} catch ( Exception e ) {
			erreursMessage.put("login", e.getMessage() );
		}
		//Validation password
		try {
			validationMotsDePasse(login, password);
		} catch ( Exception e ) {
			erreursMessage.put("password", e.getMessage() );
		}

		if ( erreursMessage.isEmpty() ) {
			resultat = "Succès connexion.";
			request.getSession().setAttribute("login",login);
			//request.getSession().setAttribute("idUser",UsersManager.getInstance().getTheIdUser(user_pseudo));
			
			response.sendRedirect("profil");
		} else {
			resultat = "Échec de la connexion.";
			//Stockage des erreurs et du résultat
			request.setAttribute("erreurs", erreursMessage );
			request.setAttribute("resultat", resultat );

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/connexion.jsp");
			view.forward(request, response);
		}

	}

	private void validationPseudo(String login) throws Exception {
		Integer nbPseudo = UtilisateurManager.getInstance().countUsersPseudoUsed(login);
		if(nbPseudo == 0){
			throw new Exception( "<div class='erreur_message'>Le pseudo n'existe pas.</div>" );
		}
	}

	private void validationMotsDePasse(String login, String password) throws Exception {
		String passwordStockedInBdd = UtilisateurManager.getInstance().GetPasswordConnexion(login);
		//On hash le password posté par l'utilisateur pour vérifier les deux 
		String passwordHashed = UtilisateurManager.getInstance().HashMyPassword(password);
		if(!(passwordHashed.equals(passwordStockedInBdd))){
			throw new Exception( "<div class='erreur_message'>Vous avez entré un mauvais mot de passe.</div>" );
		}
	}

}