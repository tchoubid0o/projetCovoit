package omw.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import omw.dao.AnnonceDao;
import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;

public class AnnonceDaoImpl implements AnnonceDao{
	
	public void insertProposition(Integer rep, String villeDepart, String villeArrivee, String date, String heure, String minute, String prix, String nbPlace, String comment, String login){
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
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `annonceproposition`(`estReponseARecherche`,`villeDepart`,`villeArrivee`, `dateEtHeureTrajet`, `commentaire`, `prix`, `nbPlace`, `login`) VALUES(?,?,?,?,?,?,?,?)");
			stmt.setInt(1, rep);
			stmt.setString(2, villeDepart);
			stmt.setString(3, villeArrivee);
			stmt.setString(4, formatedDate);
			stmt.setString(5, comment);
			stmt.setInt(6, Integer.parseInt(prix));
			stmt.setInt(7, Integer.parseInt(nbPlace));
			stmt.setString(8, login);
			
			stmt.executeUpdate();
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
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
	
	public void proposerAnnonce(String login, AnnonceProposition annonceProposition){
		
	}
	
	public void rechercherAnnonce(String login, AnnonceRecherche annonceRecherche){
		
	}

}
