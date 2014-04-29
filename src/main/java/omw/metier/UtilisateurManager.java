package omw.metier;

import omw.dao.UtilisateurDao;
import omw.dao.impl.UtilisateurDaoImpl;
import omw.model.Utilisateur;

import java.net.UnknownHostException;
import java.util.List;

public class UtilisateurManager {

	private static UtilisateurManager instance;

	private UtilisateurDao usersDao = new UtilisateurDaoImpl();

	private UtilisateurManager() {
	}

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	public List<Utilisateur> listerUsers() {
		return usersDao.listerUsers();
	}
	
	public Integer countUsersMailUsed(String user_mail){
		return usersDao.countUsersMailUsed(user_mail);
	}
	
	public Integer countUsersPseudoUsed(String user_pseudo){
		return usersDao.countUsersPseudoUsed(user_pseudo);
	}
	
	public void ajouterUser(Utilisateur user) throws UnknownHostException{
		usersDao.ajouterUser(user);
	}
	
	public String HashMyPassword(String user_password) throws Exception{
		return usersDao.HashMyPassword(user_password);
	}
	
	public String GetPasswordConnexion(String user_pseudo){
		return usersDao.GetPasswordConnexion(user_pseudo);
	}
	
	public Integer getTheIdUser(String user_pseudo){
		return usersDao.getTheIdUser(user_pseudo);
	}
	
	public String getUserPseudo(Integer idUser){
		return usersDao.getUserPseudo(idUser);
	}
}
