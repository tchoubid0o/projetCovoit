package omw.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.SubstringMatcher;

import omw.dao.AnnonceDao;
import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;
import omw.model.Ville;

public class AnnonceDaoImpl implements AnnonceDao{
	
	
	public void updateProposition(Integer idProp, Integer rep, String villeDepart, String villeArrivee, String date, String heure, String minute, String prix, String nbPlace, String comment, String login, String[] etapes){

		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
	
			String formatedDate = date.concat(heure).concat(minute);
			
			PreparedStatement stmt = connection.prepareStatement("UPDATE `annonceproposition` SET estReponseARecherche = ? ,villeDepart = ?,villeArrivee=?, dateEtHeureTrajet=?, commentaire=?, prix=?, nbPlace=? WHERE idAnnonceProposition = ?");
			stmt.setInt(1, rep);
			stmt.setString(2, villeDepart);
			stmt.setString(3, villeArrivee);
			stmt.setString(4, formatedDate);
			stmt.setString(5, comment);
			stmt.setInt(6, Integer.parseInt(prix));
			stmt.setInt(7, Integer.parseInt(nbPlace));
			stmt.setInt(8, idProp);
			
			stmt.executeUpdate();
				
			PreparedStatement stmt2 = connection.prepareStatement("DELETE FROM etapes WHERE idAnnonceProposition = ?");
			stmt2.setInt(1, idProp);
			stmt2.executeUpdate();
			
			
			for(int i=0;i<etapes.length;i++){
				PreparedStatement stmt3 = connection.prepareStatement("INSERT INTO `etapes`(`idAnnonceProposition`, `nomVille`, `ordre`) VALUES(?,?,?)");
				stmt3.setInt(1, idProp);
				stmt3.setString(2, etapes[i]);
				stmt3.setInt(3, i);
				stmt3.executeUpdate();
		    }
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateRecherche(Integer idRech, String villeDepart, String villeArrivee, String date, String heure, String minute, String comment,	String login){

		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
	
			String formatedDate = date.concat(heure).concat(minute);
			
			PreparedStatement stmt = connection.prepareStatement("UPDATE `annoncerecherche` SET villeDepartRecherche = ?,villeArriveeRecherche=?, dateEtHeureRecherche=?, commentaireRecherche=? WHERE idAnnonceRecherche = ?");
			stmt.setString(1, villeDepart);
			stmt.setString(2, villeArrivee);
			stmt.setString(3, formatedDate);
			stmt.setString(4, comment);
			stmt.setInt(5, idRech);
			
			stmt.executeUpdate();
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertProposition(Integer rep, String villeDepart, String villeArrivee, String date, String heure, String minute, String prix, String nbPlace, String comment, String login, String[] etapes){
		/*
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateLimite = null;
		try {
		dateLimite = df.parse(date);
		} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		*/
		
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
	
			String formatedDate = date.concat(heure).concat(minute);
			int lastId = 0;
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `annonceproposition`(`estReponseARecherche`,`villeDepart`,`villeArrivee`, `dateEtHeureTrajet`, `commentaire`, `prix`, `nbPlace`, `login`) VALUES(?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, rep);
			stmt.setString(2, villeDepart);
			stmt.setString(3, villeArrivee);
			stmt.setString(4, formatedDate);
			stmt.setString(5, comment);
			stmt.setInt(6, Integer.parseInt(prix));
			stmt.setInt(7, Integer.parseInt(nbPlace));
			stmt.setString(8, login);
			
			int numero = stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
			    lastId = rs.getInt(1);
			}
			
			for(int i=0;i<etapes.length;i++){
				PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO `etapes`(`idAnnonceProposition`, `nomVille`, `ordre`) VALUES(?,?,?)");
				stmt2.setInt(1, lastId);
				stmt2.setString(2, etapes[i]);
				stmt2.setInt(3, i);
				stmt2.executeUpdate();
		    }
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertRecherche(String villeDepart, String villeArrivee, String date, String heure, String minute, String comment,	String login){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
	
			String formatedDate = date.concat(heure).concat(minute);
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `annoncerecherche`(`villeDepartRecherche`,`villeArriveeRecherche`, `dateEtHeureRecherche`, `commentaireRecherche`, `login`) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, villeDepart);
			stmt.setString(2, villeArrivee);
			stmt.setString(3, formatedDate);
			stmt.setString(4, comment);
			stmt.setString(5, login);	
			stmt.executeUpdate();
			
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public ArrayList<AnnonceProposition> listerAnnonceProposition(){
		
		ArrayList<AnnonceProposition> listAnnonceProposition = new ArrayList<AnnonceProposition>();
		
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
	
			Statement stmtListAnnonceProposition = connection.createStatement();
			ResultSet resultsListAnnonceProposition = stmtListAnnonceProposition.executeQuery("SELECT * FROM annonceproposition  INNER JOIN etapes ON annonceproposition.idAnnonceProposition=etapes.idAnnonceProposition");
			
			while (resultsListAnnonceProposition.next()) {
				AnnonceProposition annonceProposition = new AnnonceProposition();
				
				
			}
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listAnnonceProposition;
	}
	*/
	
	public void ajouterDemandePourAnnonce(Integer idAnnonceProposition, String login){
		
		try{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `reserver`(`login`,`idAnnonceProposition`, `demandeConfirmee`) VALUES(?,?,?)");
			
			stmt.setString(1, login);
			stmt.setInt(2, idAnnonceProposition);
			stmt.setInt(3, 0);
			
			stmt.close();
			connection.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<AnnonceProposition> listerAnnonceProposition() {
		List<AnnonceProposition> liste = new ArrayList<AnnonceProposition>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM annonceproposition ORDER BY idAnnonceProposition ASC");

			while (results.next()) {
				AnnonceProposition proposition = new AnnonceProposition(
						results.getInt("idAnnonceProposition"),
						results.getBoolean("estReponseARecherche"),
						ucfirst(results.getString("villeDepart")),
						ucfirst(results.getString("villeArrivee")),
						(results.getString("dateEtHeureTrajet")).substring(0,10),
						(results.getString("dateEtHeureTrajet")).substring(10,12),
						(results.getString("dateEtHeureTrajet")).substring(12),
						results.getString("commentaire"),
						results.getInt("prix"),
						results.getInt("nbPlace"),
						results.getString("login"));
				liste.add(proposition);
			}
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return liste;
	}
	
	public List<AnnonceRecherche> listerAnnonceRecherche() {
		List<AnnonceRecherche> liste = new ArrayList<AnnonceRecherche>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM annoncerecherche ORDER BY idAnnonceRecherche ASC");

			while (results.next()) {
				AnnonceRecherche proposition = new AnnonceRecherche(
						results.getInt("idAnnonceRecherche"),
						ucfirst(results.getString("villeDepartRecherche")),
						ucfirst(results.getString("villeArriveeRecherche")),
						(results.getString("dateEtHeureRecherche")).substring(0,10),
						(results.getString("dateEtHeureRecherche")).substring(10,12),
						(results.getString("dateEtHeureRecherche")).substring(12),
						results.getString("commentaireRecherche"),
						results.getString("login"));
				liste.add(proposition);
			}
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return liste;
	}
	
	public List<AnnonceProposition> listerMesAnnonceProposition(String login) {
		List<AnnonceProposition> liste = new ArrayList<AnnonceProposition>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();
			
			ResultSet results = null;

			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM annonceproposition WHERE login = ? ORDER BY idAnnonceProposition ASC");
			stmt.setString(1,login);
			results = stmt.executeQuery();

			while (results.next()) {
				AnnonceProposition proposition = new AnnonceProposition(
						results.getInt("idAnnonceProposition"),
						results.getBoolean("estReponseARecherche"),
						ucfirst(results.getString("villeDepart")),
						ucfirst(results.getString("villeArrivee")),
						(results.getString("dateEtHeureTrajet")).substring(0,10),
						(results.getString("dateEtHeureTrajet")).substring(10,12),
						(results.getString("dateEtHeureTrajet")).substring(12),
						results.getString("commentaire"),
						results.getInt("prix"),
						results.getInt("nbPlace"),
						results.getString("login"));
				liste.add(proposition);
			}
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return liste;
	}
	
	public List<AnnonceRecherche> listerMesAnnonceRecherche(String login) {
		List<AnnonceRecherche> liste = new ArrayList<AnnonceRecherche>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();
			
			ResultSet results = null;
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM annoncerecherche WHERE login = ? ORDER BY idAnnonceRecherche ASC");
			stmt.setString(1,login);
			results = stmt.executeQuery();

			while (results.next()) {
				AnnonceRecherche proposition = new AnnonceRecherche(
						results.getInt("idAnnonceRecherche"),
						ucfirst(results.getString("villeDepartRecherche")),
						ucfirst(results.getString("villeArriveeRecherche")),
						(results.getString("dateEtHeureRecherche")).substring(0,10),
						(results.getString("dateEtHeureRecherche")).substring(10,12),
						(results.getString("dateEtHeureRecherche")).substring(12),
						results.getString("commentaireRecherche"),
						results.getString("login"));
				liste.add(proposition);
			}
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return liste;
	}
	
	public void proposerAnnonce(String login, AnnonceProposition annonceProposition){
		
	}
	
	public void rechercherAnnonce(String login, AnnonceRecherche annonceRecherche){
		
	}
	
	public static String ucfirst(String chaine){
		return chaine.substring(0, 1).toUpperCase()+ chaine.substring(1).toLowerCase();
	}

}
