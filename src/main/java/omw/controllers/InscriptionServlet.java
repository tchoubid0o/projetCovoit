package omw.controllers;

import omw.metier.UtilisateurManager;
import omw.model.Utilisateur;

import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InscriptionServlet extends GlobalInformationsServlet{

	private static final long serialVersionUID = -4927724527514530512L;

	@Override
	public void getRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/inscription.jsp");
		view.forward(request, response);
	}

	@Override
	public void postRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String, String> erreursMessage = new HashMap<String, String>();
		
		String login = request.getParameter("login");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password_verif = request.getParameter("password_verif");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		String resultat = "";

		//Validation pseudo
        try {
            validationPseudo(login);
        } catch ( Exception e ) {
            erreursMessage.put("login", e.getMessage() );
        }
        //Validation mail
        try {
            validationEmail(email);
        } catch ( Exception e ) {
            erreursMessage.put("email", e.getMessage() );
        }
		//Validation password
		try {
			validationMotsDePasse(password,password_verif);
		} catch ( Exception e ) {
			erreursMessage.put("password", e.getMessage() );
		}

		if ( erreursMessage.isEmpty() ) {
			//On crypte le password
			try {
				String passwd = UtilisateurManager.getInstance().HashMyPassword(password);
				UtilisateurManager.getInstance().ajouterUser(new Utilisateur(login, email, passwd, null, nom, prenom, telephone, null));
				request.getSession().setAttribute("login",login);
				request.getSession().setAttribute("email",email);
				request.getSession().setAttribute("nom",nom);
				request.getSession().setAttribute("prenom",prenom);
				resultat = "<div class='erreur_message' style='color: green !important;'><span class='titleAbout'>Inscription</span>Succès de l'inscription.<script>$('#wrapperInsc').slideUp();</script></div>";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			resultat = "<div class='erreur_message'>Échec de l'inscription.</div>";
		}

		//Stockage des erreurs et du résultat
		request.setAttribute("erreurs", erreursMessage );
		request.setAttribute("resultat", resultat );
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/inscription.jsp");
		view.forward(request, response);
	}

	private void validationPseudo(String user_pseudo) throws Exception {
		if ( user_pseudo != null && user_pseudo.trim().length() < 3 ) {
			throw new Exception( "<div class='erreur_message'>Le nom d'utilisateur doit contenir au moins 3 caractères.</div>" );
		}
		else{
			Integer nbPseudo = UtilisateurManager.getInstance().countUsersPseudoUsed(user_pseudo);
			if(nbPseudo != 0){
				throw new Exception( "<div class='erreur_message'>Le pseudo est déjà utilisé.</div>" );
			}
		}
	}

	private void validationEmail(String user_mail) throws Exception {
		if ( user_mail != null && user_mail.trim().length() != 0 ) {
			if ( !user_mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
				throw new Exception( "<div class='erreur_message'>Merci de saisir une adresse mail valide.</div>" );
			}
			else{
				Integer nbMail = UtilisateurManager.getInstance().countUsersMailUsed(user_mail);
				if(nbMail != 0){
					throw new Exception( "<div class='erreur_message'>L'adresse mail est déjà utilisée.</div>" );
				}
			}
		} else {
			throw new Exception( "<div class='erreur_message'>Merci de saisir une adresse mail.</div>" );
		}
	}


	private void validationMotsDePasse(String user_password,
			String user_password_verif) throws Exception {
		if (user_password != null && user_password.trim().length() != 0 && user_password_verif != null && user_password_verif.trim().length() != 0) {
			if (!user_password.equals(user_password_verif)) {
				throw new Exception("<div class='erreur_message'>Les mots de passe entrés sont différents, merci de les saisir à nouveau.</div>");
			} else if (user_password.trim().length() < 3) {
				throw new Exception("<div class='erreur_message'>Les mots de passe doivent contenir au moins 3 caractères.</div>");
			}
		} else {
			throw new Exception("<div class='erreur_message'>Merci de saisir et confirmer votre mot de passe.</div>");
		}
	}

}
