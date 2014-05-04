package omw.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import omw.dao.GlobalInformationsDao;
import omw.metier.AnnonceManager;
import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;

public class GlobalInformationsDaoImpl implements GlobalInformationsDao {
	
	public List<AnnonceProposition> listLastOffers(){
		List<AnnonceProposition> liste = new ArrayList<AnnonceProposition>();
		try {
			
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM annonceproposition WHERE estReponseARecherche = 0 ORDER BY idAnnonceProposition DESC LIMIT 5");
			
			while (results.next()) {
				AnnonceProposition proposition = new AnnonceProposition(
						results.getInt("idAnnonceProposition"),
						results.getBoolean("estReponseARecherche"),
						AnnonceManager.getInstance().ucfirst(results.getString("villeDepart")),
						AnnonceManager.getInstance().ucfirst(results.getString("villeArrivee")),
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
			
			return liste;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//erreur
		return null;
	}
	
	public List<AnnonceRecherche> listLastSearch(){
		List<AnnonceRecherche> liste = new ArrayList<AnnonceRecherche>();
		try {
			
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM annoncerecherche ORDER BY idAnnonceRecherche DESC LIMIT 5");
			
			while (results.next()) {
				AnnonceRecherche proposition = new AnnonceRecherche(
						results.getInt("idAnnonceRecherche"),
						AnnonceManager.getInstance().ucfirst(results.getString("villeDepartRecherche")),
						AnnonceManager.getInstance().ucfirst(results.getString("villeArriveeRecherche")),
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
			
			return liste;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//erreur
		return null;
	}
	
	/*
	public Integer countUsersDataBase(){
		Integer nbUsers = 0;
		try {
			
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT COUNT(*) FROM users");
			
			while (results.next()) {
				nbUsers = results.getInt(1);
			}
			
			results.close();
			stmt.close();
			connection.close();
			
			return nbUsers;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//erreur
		return -1;
	}
	
	public Integer countVotesDataBase(){
		Integer nbVotes = 0;
		try {
			
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT COUNT(*) FROM historiques");
			
			while (results.next()) {
				nbVotes = results.getInt(1);
			}
			
			results.close();
			stmt.close();
			connection.close();
			
			return nbVotes;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//erreur
		return -1;
	}
	
	public ArrayList<String> returnAllCategorie(){
		ArrayList<String> maListe = new ArrayList<String>();
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
	
			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT libelleCategorie FROM categories ORDER BY idCategorie ASC");

			while (results.next()) {
				maListe.add(results.getString(1));
			}
				
			results.close();
			stmt.close();
			connection.close();
				
			return maListe;
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//erreur
		return maListe;
	}
	*/
}
