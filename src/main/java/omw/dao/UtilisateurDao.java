package omw.dao;

import omw.model.Utilisateur;

import java.net.UnknownHostException;
import java.util.List;

public interface UtilisateurDao {

	public List<Utilisateur> listerUsers();
	
	public Utilisateur getUser(String login); 
	
	public Integer countUsersMailUsed(String user_mail);
	
	public Integer countUsersPseudoUsed(String user_pseudo);

	public void ajouterUser(Utilisateur user) throws UnknownHostException;
	
	public String HashMyPassword(String user_password) throws Exception;
	
	public String GetPasswordConnexion(String user_pseudo);
	
	public String editMySettings(String email, String password, String password_verif, String telephone, String login);
	/*
	public Integer getTheIdUser(String user_pseudo);

	public String getUserPseudo(Integer idUser);*/
}
