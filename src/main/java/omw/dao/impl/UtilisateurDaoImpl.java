package omw.dao.impl;

import omw.dao.UtilisateurDao;
import omw.model.Utilisateur;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDaoImpl implements UtilisateurDao {

	public UtilisateurDaoImpl() {
		
	}

	public List<Utilisateur> listerUsers() {
		List<Utilisateur> liste = new ArrayList<Utilisateur>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur");

			while (results.next()) {
				Utilisateur user = new Utilisateur(
						results.getString("login"),
						results.getString("email"),
						results.getString("password"),
						results.getString("ip"),
						results.getString("nom"),
						results.getString("prenom"),
						results.getString("telephone"),
						results.getDate("registered"));
				liste.add(user);
			}
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return liste;
	}
	
	public Utilisateur getUser(String login) {
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM utilisateur WHERE login = ?");
			stmt.setString(1, login);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				Utilisateur user = new Utilisateur(
						results.getString("login"),
						results.getString("email"),
						results.getString("password"),
						results.getString("ip"),
						results.getString("nom"),
						results.getString("prenom"),
						results.getString("telephone"),
						results.getDate("registered"));

				results.close();
				stmt.close();
				
				connection.close();

				//On retourne qu'une seule image
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Si aucun résultat
		return null;
	}

	public Integer countUsersMailUsed(String user_mail) {
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM utilisateur WHERE email = ?");
			stmt.setString(1, user_mail);

			ResultSet results = null;
			try {
				results = stmt.executeQuery();

				if(results.next()){
					return results.getInt(1);
				}

			} catch (SQLException e1) {
				System.out.println("Erreur lors de l'exécution de la requête comptant le nombre de mail présent dans la bdd");
				e1.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//retourne une erreur
		return -1;
	}

	public Integer countUsersPseudoUsed(String login) {
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM utilisateur WHERE login = ?");
			stmt.setString(1, login);

			ResultSet results = null;
			try {
				results = stmt.executeQuery();

				if(results.next()){
					return results.getInt(1);
				}

			} catch (SQLException e1) {
				System.out.println("Erreur lors de l'exécution de la requête comptant le nombre de pseudo présent dans la bdd");
				e1.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		//retourne une erreur
		return -1;
	}

	@Override
	public void ajouterUser(Utilisateur user) throws UnknownHostException {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			String nomUser = user.getNom().toUpperCase();
			String prenomUser = user.getPrenom().toLowerCase();
			prenomUser = prenomUser.substring(0,1).toUpperCase()+prenomUser.substring(1);
			
			String ip = InetAddress.getLocalHost().getHostAddress();

			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `utilisateur`(`login`,`email`,`password`, `ip`, `nom`, `prenom`, `telephone`, `registered`) VALUES(?,?,?,?,?,?,?, NOW())");
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, ip);
			stmt.setString(5, nomUser);
			stmt.setString(6, prenomUser);
			stmt.setString(7, user.getTelephone());
			
			stmt.executeUpdate();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String HashMyPassword(String password) throws Exception{
		// On crypte le password en MD5 avec un salt le tout 3 fois
		password = "projet"+password+"ITI";
		for(int a = 0; a < 3; a++){
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			password = sb.toString();
		}

		return password;
		//Renvoi un varchar(32)
	}
	
	public String GetPasswordConnexion(String login){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT password FROM utilisateur WHERE login = ?");
			stmt.setString(1, login);

			ResultSet results = null;
			try {
				results = stmt.executeQuery();

				if(results.next()){
					return results.getString(1);
				}

			} catch (SQLException e1) {
				System.out.println("Erreur lors de l'exécution de la requête permettant de récupérer le password hasher pour la connexion");
				e1.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "erreur";
	}
	
	//On a pas d'ID utilisateur
	
	/*
	public Integer getTheIdUser(String login){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM utilisateur WHERE login = ?");
			stmt.setString(1, login);
			ResultSet results = null;
			try {
				results = stmt.executeQuery();
				if(results.next()){
					//Retourne juste l'idUser
					return results.getInt(1);
				}

			} catch (SQLException e1) {
				System.out.println("Erreur lors de l'exécution de la requête permettant de récupérer l'idUser");
				e1.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public String getUserPseudo(Integer idUser){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT login FROM utilisateur WHERE idUser = ?");
			stmt.setInt(1, idUser);
			ResultSet results = null;
			try {
				results = stmt.executeQuery();
				if(results.next()){
					//Retourne juste l'idUser
					return results.getString(1);
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "erreur";
	}
	*/
	
	public String editMySettings(String email, String password, String password_verif, String telephone, String login){
		try {
			if(password.equals(password_verif)){
				Connection connection = DataSourceProvider.getDataSource().getConnection();
				String hashedPassword = "";
				try {
					hashedPassword = HashMyPassword(password);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				PreparedStatement stmt = connection.prepareStatement("UPDATE utilisateur SET email = ?, password = ?, telephone = ?  WHERE login = ?");
				stmt.setString(1, email);
				stmt.setString(2, hashedPassword);
				stmt.setString(3, telephone);
				stmt.setString(4, login);
				stmt.executeUpdate();
				
				return "<span class='red'>Votre compte a bien été modifié.</span>";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "<span class='red'>Erreur.</span>";
	}
}
