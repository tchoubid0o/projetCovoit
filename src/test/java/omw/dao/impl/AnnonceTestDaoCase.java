package omw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;
import omw.model.Utilisateur;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class AnnonceTestDaoCase {
	
	@Before
	public void purgeBDD() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("DELETE FROM proposer");
		stmt.executeUpdate("INSERT INTO `proposer`(`idProposer`,`idAnnonceRecherche`, `login`, `idAnnonceProposition`, `propositionConfirmee`) VALUES (1, 1,'log', 1, 0)");
		stmt.executeUpdate("DELETE FROM reserver");
		stmt.executeUpdate("INSERT INTO `reserver`(`idReserver`,`login`, `demandeConfirmee`) VALUES (1, 'log', 1, 0");
		stmt.executeUpdate("DELETE FROM etapes");
		stmt.executeUpdate("INSERT INTO `etapes`(`idEtape`,`idAnnonceProposition`, `nomVille`, `ordre`) VALUES (1, 1, 'etapeTest',0)");
		stmt.executeUpdate("DELETE FROM annonceproposition");
		stmt.executeUpdate("INSERT INTO `annonceproposition`(`idAnnonceProposition`,`estReponseARecherche`, `villeDepart`, `villeArrivee`, `dateEtHeureTrajet`, `commentaire`, `prix`, `nbPlace`, `nbPlaceDispo`, `login`) VALUES (1, 0, 'departTest','arriveeTest','2014/01/020001','test',25,2,1,'log')");
		stmt.executeUpdate("DELETE FROM annoncerecherche");
		stmt.executeUpdate("INSERT INTO `annoncerecherche`(`idAnnonceRecherche`, `villeDepartRecherche`, `villeArriveeRecherche`, `dateEtHeureRecherche`, `commentaireRecherche`, `login`) VALUES (1, 'departRechercheTest', 'arriveeRechercheTest','2014/05/060708','testRecherche','log')");		
		stmt.executeUpdate("DELETE FROM utilisateur");
		stmt.executeUpdate("INSERT INTO `utilisateur`(`login`,`email`, `password`, `ip`, `nom`, `prenom`, `telephone`, `registered`) VALUES ('log', 'test@gmail.com','passwordTest','ipTest','NOMTEST','Prenomtest','0312345678','2014-01-02 00:01:02')");
		stmt.close();
		connection.close();
	}
	
	/*@Test
	public void testListerRechercheProposition() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT DISTINCT AP.idAnnonceProposition FROM annonceproposition AP INNER JOIN etapes ET ON AP.idAnnonceProposition = ET.idAnnonceProposition WHERE AP.estReponseARecherche = 0 ");
		Assert.assertTrue(results.next());
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertEquals("test@gmail.com", results.getString("email"));
		Assert.assertEquals("passwordTest", results.getString("password"));
		Assert.assertEquals("ipTest", results.getString("ip"));
		Assert.assertEquals("NOMTEST", results.getString("nom"));
		Assert.assertEquals("Prenomtest", results.getString("prenom"));
		Assert.assertEquals("0312345678", results.getString("telephone"));
		Assert.assertEquals("2014-01-02 00:01:02.0", results.getString("registered"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	public List<AnnonceProposition> listerRechercheProposition(String villeDepart, String villeArrivee){
		//Schema trajet possible:
				// A ---> B
				// A ~~~~ B ---> C
				// Other ~~~~ A ~~~~ B ~~~~ D    Requête stmt et stmt2; Les 3 autres cas sont traités simplement avec stmt3
				// Other ~~~~ A ~~~~ B
		
		List<AnnonceProposition> liste = new ArrayList<AnnonceProposition>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			ResultSet results = null;
			
			PreparedStatement stmt = connection.prepareStatement("SELECT DISTINCT AP.idAnnonceProposition FROM annonceproposition AP INNER JOIN etapes ET ON AP.idAnnonceProposition = ET.idAnnonceProposition "
					+ "WHERE AP.estReponseARecherche = 0 ");
			
			results = stmt.executeQuery();

			while (results.next()) {
				//System.out.println(results.getInt("idAnnonceProposition"));
				int i = 0;
				ResultSet results2 = null;
				
				//liste.add(proposition);
				
				PreparedStatement stmt2 = connection.prepareStatement("SELECT * FROM etapes WHERE idAnnonceProposition = ? ORDER BY idEtape ASC");
				stmt2.setInt(1, results.getInt("idAnnonceProposition"));
				results2 = stmt2.executeQuery();
				ArrayList<String> maListe = new ArrayList<String>();
				//System.out.println("----------------");
				while (results2.next()) {
					//System.out.println(results2.getString("nomVille"));
					maListe.add(results2.getString("nomVille"));
				}
				
				maListe.add("null");
				Integer taille = maListe.size()-1;
				Integer firstV = 0;
				Integer lastV = 0;
				for(i=0; i< taille; i++){
					//System.out.println(villeDepart+" et "+maListe.get(i)+" avec "+maListe.get(i+1)+" et "+villeArrivee);
					if(maListe.get(i).toLowerCase().equals(villeDepart)){
						
						//System.out.println("idAnnonceProposition"+i+"test");
						firstV = i;
					}
					if(maListe.get(i).toLowerCase().equals(villeArrivee)){
						lastV = i;
					}
				}
				
				if(firstV < lastV){
					liste.add(listerUneAnnonceProposition(results.getInt("idAnnonceProposition")));
				}
				
				results2.close();
				stmt2.close();
				
			}
			results.close();
			stmt.close();

			ResultSet results3 = null;
			
			PreparedStatement stmt3 = connection.prepareStatement("SELECT DISTINCT AP.idAnnonceProposition FROM annonceproposition AP RIGHT JOIN etapes ET ON AP.idAnnonceProposition = ET.idAnnonceProposition "
					+ "WHERE AP.estReponseARecherche = 0 "
					+ "AND ((AP.villeDepart = ? AND AP.villeArrivee = ?) OR (AP.villeDepart = ? AND ET.nomVille = ?) OR (ET.nomVille = ? AND AP.villeArrivee = ?))");
			stmt3.setString(1,villeDepart);
			stmt3.setString(2,villeArrivee);
			stmt3.setString(3,villeDepart);
			stmt3.setString(4,villeArrivee);
			stmt3.setString(5,villeDepart);
			stmt3.setString(6,villeArrivee);
			
			results3 = stmt3.executeQuery();

			while (results3.next()) {
				liste.add(listerUneAnnonceProposition(results3.getInt("idAnnonceProposition")));
			}
			results3.close();
			stmt3.close();
			
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return liste;	
	}*/
	
	@Test
	public void testDeleteAds() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("DELETE FROM annonceproposition WHERE idAnnonceProposition = 1");
		ResultSet results = stmt.executeQuery("SELECT * FROM annonceproposition WHERE idAnnonceProposition = 1");
		
		Assert.assertFalse(results.next());
		
		stmt.executeUpdate("DELETE FROM etapes WHERE idAnnonceProposition = 1");
		results = stmt.executeQuery("SELECT * FROM etapes WHERE idAnnonceProposition = 1");
		
		Assert.assertFalse(results.next());
		
		stmt.executeUpdate("DELETE FROM annoncerecherche WHERE idAnnonceRecherche = 1");
		results = stmt.executeQuery("SELECT * FROM annoncerecherche WHERE idAnnonceRecherche = 1");
		
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	

	@Test
	public void testUpdateProposition() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("UPDATE `annonceproposition` SET estReponseARecherche = 0 ,villeDepart = 'departTestBis',villeArrivee='arriveeTestBis', dateEtHeureTrajet='2014/05/060304', commentaire='testBis', prix=10, nbPlace=4 WHERE idAnnonceProposition = 1");
		ResultSet results = stmt.executeQuery("SELECT * FROM annonceproposition WHERE idAnnonceProposition = 1");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt("idAnnonceProposition"));
		Assert.assertEquals(0, results.getInt("estReponseARecherche"));
		Assert.assertEquals("departTestBis", results.getString("villeDepart"));
		Assert.assertEquals("arriveeTestBis", results.getString("villeArrivee"));
		Assert.assertEquals("2014/05/060304", results.getString("dateEtHeureTrajet"));
		Assert.assertEquals("testBis", results.getString("commentaire"));
		Assert.assertEquals(10, results.getInt("prix"));
		Assert.assertEquals(4, results.getInt("nbPlace"));
		Assert.assertEquals(1, results.getInt("nbPlaceDispo"));
		Assert.assertEquals("log", results.getString("login"));		
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testUpdateRecherche() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("UPDATE `annoncerecherche` SET villeDepartRecherche = 'departTestBis',villeArriveeRecherche='arriveeTestBis', dateEtHeureRecherche='2014/01/020001', commentaireRecherche='testBis' WHERE idAnnonceRecherche = 1");
		ResultSet results = stmt.executeQuery("SELECT * FROM annoncerecherche WHERE idAnnonceRecherche = 1");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt("idAnnonceRecherche"));
		Assert.assertEquals("departTestBis", results.getString("villeDepartRecherche"));
		Assert.assertEquals("arriveeTestBis", results.getString("villeArriveeRecherche"));
		Assert.assertEquals("2014/01/020001", results.getString("dateEtHeureRecherche"));
		Assert.assertEquals("testBis", results.getString("commentaireRecherche"));
		Assert.assertEquals("log", results.getString("login"));		
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testInsertProposition() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("INSERT INTO `annonceproposition`(`idAnnonceProposition`, `estReponseARecherche`,`villeDepart`,`villeArrivee`, `dateEtHeureTrajet`, `commentaire`, `prix`, `nbPlace`, `nbPlaceDispo`, `login`) VALUES (2, 0, 'departTestBis','arriveeTestBis','2014/05/060304','testBis',15,2,1,'log')");
		ResultSet results = stmt.executeQuery("SELECT * FROM annonceproposition WHERE idAnnonceProposition = 2");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(2, results.getInt("idAnnonceProposition"));
		Assert.assertEquals(0, results.getInt("estReponseARecherche"));
		Assert.assertEquals("departTestBis", results.getString("villeDepart"));
		Assert.assertEquals("arriveeTestBis", results.getString("villeArrivee"));
		Assert.assertEquals("2014/05/060304", results.getString("dateEtHeureTrajet"));
		Assert.assertEquals("testBis", results.getString("commentaire"));
		Assert.assertEquals(15, results.getInt("prix"));
		Assert.assertEquals(2, results.getInt("nbPlace"));
		Assert.assertEquals(1, results.getInt("nbPlaceDispo"));
		Assert.assertEquals("log", results.getString("login"));		
		Assert.assertFalse(results.next());
		
		stmt.executeUpdate("INSERT INTO `etapes`(`idEtape`,`idAnnonceProposition`, `nomVille`, `ordre`) VALUES(2,2,'villeTestBis',0)");
		results = stmt.executeQuery("SELECT * FROM etapes WHERE idAnnonceProposition = 2");		

		Assert.assertTrue(results.next());
		Assert.assertEquals(2, results.getInt("idEtape"));
		Assert.assertEquals(2, results.getInt("idAnnonceProposition"));
		Assert.assertEquals("villeTestBis", results.getString("nomVille"));
		Assert.assertEquals(0, results.getInt("ordre"));	
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testInsertPropositionReponse() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("INSERT INTO `annonceproposition`(`idAnnonceProposition`, `estReponseARecherche`,`villeDepart`,`villeArrivee`, `dateEtHeureTrajet`, `commentaire`, `prix`, `nbPlace`, `nbPlaceDispo`, `login`) VALUES (2, 1, 'departTestBis','arriveeTestBis','2014/05/060304','testBis',15,2,1,'log')");
		ResultSet results = stmt.executeQuery("SELECT * FROM annonceproposition WHERE idAnnonceProposition = 2");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(2, results.getInt("idAnnonceProposition"));
		Assert.assertEquals(0, results.getInt("estReponseARecherche"));
		Assert.assertEquals("departTestBis", results.getString("villeDepart"));
		Assert.assertEquals("arriveeTestBis", results.getString("villeArrivee"));
		Assert.assertEquals("2014/05/060304", results.getString("dateEtHeureTrajet"));
		Assert.assertEquals("testBis", results.getString("commentaire"));
		Assert.assertEquals(15, results.getInt("prix"));
		Assert.assertEquals(2, results.getInt("nbPlace"));
		Assert.assertEquals(1, results.getInt("nbPlaceDispo"));
		Assert.assertEquals("log", results.getString("login"));		
		Assert.assertFalse(results.next());
		
		stmt.executeUpdate("INSERT INTO `etapes`(`idEtape`,`idAnnonceProposition`, `nomVille`, `ordre`) VALUES(2,2,'villeTestBis',0)");
		results = stmt.executeQuery("SELECT * FROM etapes WHERE idAnnonceProposition = 2");		

		Assert.assertTrue(results.next());
		Assert.assertEquals(2, results.getInt("idEtape"));
		Assert.assertEquals(2, results.getInt("idAnnonceProposition"));
		Assert.assertEquals("villeTestBis", results.getString("nomVille"));
		Assert.assertEquals(0, results.getInt("ordre"));	
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	public void insertPropositionReponse(String idAnnonceRecherche, Integer rep, String villeDepart, String villeArrivee, String date, String heure, String minute, String prix, String nbPlace, String comment, String login, String[] etapes){
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
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `annonceproposition`(`estReponseARecherche`,`villeDepart`,`villeArrivee`, `dateEtHeureTrajet`, `commentaire`, `prix`, `nbPlace`, `nbPlaceDispo`, `login`) VALUES(?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, rep);
			stmt.setString(2, villeDepart);
			stmt.setString(3, villeArrivee);
			stmt.setString(4, formatedDate);
			stmt.setString(5, comment);
			stmt.setInt(6, Integer.parseInt(prix));
			stmt.setInt(7, Integer.parseInt(nbPlace));
			stmt.setInt(8, Integer.parseInt(nbPlace));
			stmt.setString(9, login);
			
			int numero = stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()){
			    lastId = rs.getInt(1);
			}
			
			for(int i=0;i<etapes.length;i++){
				if(etapes[i] != ""){
					PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO `etapes`(`idAnnonceProposition`, `nomVille`, `ordre`) VALUES(?,?,?)");
					stmt2.setInt(1, lastId);
					stmt2.setString(2, etapes[i]);
					stmt2.setInt(3, i);
					stmt2.executeUpdate();
				}
		    }
			
			PreparedStatement stmt3 = connection.prepareStatement("INSERT INTO `proposer`(`idAnnonceRecherche`, `login`, `idAnnonceProposition` , `propositionConfirmee`) VALUES(?,?,?, 0)");
			stmt3.setInt(1, Integer.parseInt(idAnnonceRecherche));
			stmt3.setString(2, login);
			stmt3.setInt(3, lastId);
			stmt3.executeUpdate();
			
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
	
	public void ajouterDemandePourAnnonce(Integer idAnnonceProposition, String login){
		
		try{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `reserver`(`login`,`idAnnonceProposition`, `demandeConfirmee`) VALUES(?,?,0)");
			
			stmt.setString(1, login);
			stmt.setInt(2, idAnnonceProposition);
			
			stmt.executeUpdate();			
			
			stmt.close();
			connection.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void refuserDemandePourAnnonce(Integer idAnnonceProposition, String login){
		
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();

			PreparedStatement stmt = connection.prepareStatement("UPDATE `reserver` SET demandeConfirmee = -1 WHERE idAnnonceProposition = ? AND login = ?");
			stmt.setInt(1, idAnnonceProposition);
			stmt.setString(2, login);
			stmt.executeUpdate();
				
			stmt.close();
				
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public boolean accepterDemandePourAnnonce(Integer idAnnonceProposition, String login){
		
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			ResultSet result = null;
			int nbPlaceDispoCovoit = 0;
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM annonceproposition WHERE idAnnonceProposition = ?");
			stmt.setInt(1, idAnnonceProposition);
			result = stmt.executeQuery();
			
			while(result.next()){
			
				nbPlaceDispoCovoit = result.getInt("nbPlaceDispo");
			}
			
			if(nbPlaceDispoCovoit > 0){
				
				nbPlaceDispoCovoit -= 1;
				stmt = connection.prepareStatement("UPDATE `annonceproposition` SET nbPlaceDispo = ? WHERE idAnnonceProposition = ?");
				stmt.setInt(1, nbPlaceDispoCovoit);
				stmt.setInt(2, idAnnonceProposition);
				
				stmt.executeUpdate();
			
				stmt = connection.prepareStatement("UPDATE `reserver` SET demandeConfirmee = 1 WHERE idAnnonceProposition = ? AND login = ?");
				stmt.setInt(1, idAnnonceProposition);
				stmt.setString(2, login);
			
				stmt.executeUpdate();
			}else{
				
				System.out.println("Pas assez de place disponible dans le covoit");
				return false;
			}
			
			stmt.close();
			result.close();
			connection.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public List<AnnonceProposition> listerAnnonceProposition(String login) {
		List<AnnonceProposition> liste = new ArrayList<AnnonceProposition>();
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			ResultSet results = null;			

			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM annonceproposition WHERE login != ? ORDER BY dateEtHeureTrajet ASC");// pas de selection de ses propres annonces		
			stmt.setString(1, login);
			results = stmt.executeQuery();

			while (results.next()) {
				
				ResultSet resultsBis = null;				
				int idAP = results.getInt("idAnnonceProposition");
				
				PreparedStatement stmtbis = connection.prepareStatement("SELECT * FROM reserver WHERE login = ? AND idAnnonceProposition = ? AND demandeConfirmee != -1");// pas de selection des annonces deja reservees et qui sont en attente ou deja confirmees		
				stmtbis.setString(1, login);
				stmtbis.setInt(2, idAP);
				resultsBis = stmtbis.executeQuery();
				
				if(!(resultsBis.next())){
				
					AnnonceProposition proposition = new AnnonceProposition(
							idAP,
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
				
				resultsBis.close();
				stmtbis.close();
			}
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return liste;
	}
	
	public List<AnnonceRecherche> listerAnnonceRecherche(String login) {
		List<AnnonceRecherche> liste = new ArrayList<AnnonceRecherche>();
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			ResultSet results = null;			

			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM annoncerecherche WHERE login != ? ORDER BY dateEtHeureRecherche ASC");// pas de selection de ses propres annonces		
			stmt.setString(1, login);
			results = stmt.executeQuery();

			while (results.next()) {
				
				ResultSet resultsBis = null;				
				int idAR = results.getInt("idAnnonceRecherche");
				
				PreparedStatement stmtbis = connection.prepareStatement("SELECT * FROM proposer WHERE login = ? AND idAnnonceRecherche = ? AND propositionConfirmee != -1");// pas de selection des annonces deja reservees et qui sont en attente ou deja confirmees		
				stmtbis.setString(1, login);
				stmtbis.setInt(2, idAR);
				resultsBis = stmtbis.executeQuery();
				
				if(!(resultsBis.next())){
				
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
				
				resultsBis.close();
				stmtbis.close();
			}
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return liste;
	}
	
	public AnnonceProposition listerUneAnnonceProposition(Integer id) {
		List<AnnonceProposition> liste = new ArrayList<AnnonceProposition>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();
			
			ResultSet results = null;

			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM annonceproposition WHERE idAnnonceProposition = ?");
			stmt.setInt(1,id);
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
				
				return proposition;
				
			}
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<AnnonceProposition> listerMesAnnonceProposition(String login) {
		List<AnnonceProposition> liste = new ArrayList<AnnonceProposition>();
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
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
				
				ResultSet resultsBis = null;
				
				PreparedStatement stmtBis = connection.prepareStatement("SELECT * FROM reserver INNER JOIN utilisateur ON reserver.login = utilisateur.login WHERE reserver.idAnnonceProposition = ? AND reserver.demandeConfirmee = 1 ORDER BY reserver.idReserver ASC ");
				stmtBis.setInt(1,proposition.getIdAnnonceProposition());
				resultsBis = stmtBis.executeQuery();
				
				while(resultsBis.next()){
					
					Utilisateur utilisateur = new Utilisateur(
							resultsBis.getString("login"), 
							resultsBis.getString("email"), 
							resultsBis.getString("password"), 
							resultsBis.getString("ip"),
							resultsBis.getString("nom"),
							resultsBis.getString("prenom"), 
							resultsBis.getString("telephone"), 
							resultsBis.getDate("registered"));
					
					proposition.addPersonneAccepteeDansCovoit(utilisateur);
				}
				
				resultsBis = null;
				
				stmtBis = connection.prepareStatement("SELECT * FROM reserver INNER JOIN utilisateur ON reserver.login = utilisateur.login WHERE reserver.idAnnonceProposition = ? AND reserver.demandeConfirmee = 0 ORDER BY reserver.idReserver ASC ");
				stmtBis.setInt(1,proposition.getIdAnnonceProposition());
				resultsBis = stmtBis.executeQuery();
				
				while(resultsBis.next()){
					
					Utilisateur utilisateur = new Utilisateur(
							resultsBis.getString("login"), 
							resultsBis.getString("email"), 
							resultsBis.getString("password"), 
							resultsBis.getString("ip"),
							resultsBis.getString("nom"),
							resultsBis.getString("prenom"), 
							resultsBis.getString("telephone"), 
							resultsBis.getDate("registered"));
					
					proposition.addPersonneSouhaitantParticiperCovoit(utilisateur);
				}				
				
				resultsBis.close();
				stmtBis.close();
				
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
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			ResultSet results = null;
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM annoncerecherche WHERE login = ? ORDER BY dateEtHeureRecherche ASC");
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
	
	public List<AnnonceProposition> listerAnnoncePropositionLeConcernant(String login, int demandeConfirmee){
		List<AnnonceProposition> liste = new ArrayList<AnnonceProposition>();
		
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			ResultSet results = null;
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM annonceproposition INNER JOIN reserver ON annonceproposition.idAnnonceProposition = reserver.idAnnonceProposition WHERE reserver.login = ? AND reserver.demandeConfirmee = ? ORDER BY annonceproposition.dateEtHeureTrajet ASC");
			stmt.setString(1,login);
			stmt.setInt(2,demandeConfirmee);
			results = stmt.executeQuery();

			while (results.next()) {
				AnnonceProposition annonce = new AnnonceProposition(
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
				liste.add(annonce);
			}
			results.close();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return liste;		
	}
}
