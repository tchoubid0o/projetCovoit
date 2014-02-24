package omw.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import omw.dao.AnnonceDao;
import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;

public class AnnonceDaoImpl implements AnnonceDao{
	
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
