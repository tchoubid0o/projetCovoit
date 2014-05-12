package omw.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnnonceTestDaoCase {
	
	@Before
	public void purgeBDD() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("DELETE FROM proposer");
		stmt.executeUpdate("INSERT INTO `proposer`(`idProposer`,`idAnnonceRecherche`, `login`, `idAnnonceProposition`, `propositionConfirmee`) VALUES (1, 1,'log', 1, 0)");
		stmt.executeUpdate("DELETE FROM reserver");
		stmt.executeUpdate("INSERT INTO `reserver`(`idReserver`,`login`, `idAnnonceProposition`, `demandeConfirmee`) VALUES (1, 'log', 1, 0)");
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
		Assert.assertEquals(10, results.getFloat("prix"), 0.01);
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
		Assert.assertEquals(15, results.getFloat("prix"), 0.01);
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
		Assert.assertEquals(1, results.getInt("estReponseARecherche"));
		Assert.assertEquals("departTestBis", results.getString("villeDepart"));
		Assert.assertEquals("arriveeTestBis", results.getString("villeArrivee"));
		Assert.assertEquals("2014/05/060304", results.getString("dateEtHeureTrajet"));
		Assert.assertEquals("testBis", results.getString("commentaire"));
		Assert.assertEquals(15, results.getFloat("prix"), 0.01);
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
		
		stmt.executeUpdate("INSERT INTO `proposer`(`idProposer`,`idAnnonceRecherche`, `login`, `idAnnonceProposition` , `propositionConfirmee`) VALUES(2,1,'log',2, 0)");
		results = stmt.executeQuery("SELECT * FROM proposer WHERE idProposer = 2");		

		Assert.assertTrue(results.next());
		Assert.assertEquals(2, results.getInt("idProposer"));
		Assert.assertEquals(1, results.getInt("idAnnonceRecherche"));
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertEquals(2, results.getInt("idAnnonceProposition"));	
		Assert.assertEquals(0, results.getInt("propositionConfirmee"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testInsertRecherche() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("INSERT INTO `annoncerecherche`(`idAnnonceRecherche`,`villeDepartRecherche`,`villeArriveeRecherche`, `dateEtHeureRecherche`, `commentaireRecherche`, `login`) VALUES(2,'departTest','arriveeTest','2014/05/060708','test','log')");
		ResultSet results = stmt.executeQuery("SELECT * FROM annoncerecherche WHERE idAnnonceRecherche = 2");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(2, results.getInt("idAnnonceRecherche"));
		Assert.assertEquals("departTest", results.getString("villeDepartRecherche"));
		Assert.assertEquals("arriveeTest", results.getString("villeArriveeRecherche"));
		Assert.assertEquals("2014/05/060708", results.getString("dateEtHeureRecherche"));
		Assert.assertEquals("test", results.getString("commentaireRecherche"));
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testAjouterDemandePourAnnonce() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("INSERT INTO `reserver`(`idReserver`,`login`,`idAnnonceProposition`, `demandeConfirmee`) VALUES(2,'log',1,0)");
		ResultSet results = stmt.executeQuery("SELECT * FROM reserver WHERE idReserver = 2");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(2, results.getInt("idReserver"));
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertEquals(1, results.getInt("idAnnonceProposition"));
		Assert.assertEquals(0, results.getInt("demandeConfirmee"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testRefuserDemandePourAnnonce() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("UPDATE `reserver` SET demandeConfirmee = -1 WHERE idAnnonceProposition = 1 AND login = 'log'");
		ResultSet results = stmt.executeQuery("SELECT * FROM reserver WHERE idAnnonceProposition = 1 AND login = 'log'");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt("idReserver"));
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertEquals(1, results.getInt("idAnnonceProposition"));
		Assert.assertEquals(-1, results.getInt("demandeConfirmee"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}

	@Test
	public void testAccepterDemandePourAnnonce() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("UPDATE `annonceproposition` SET nbPlaceDispo = 0 WHERE idAnnonceProposition = 1");
		ResultSet results = stmt.executeQuery("SELECT * FROM annonceproposition WHERE idAnnonceProposition = 1");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt("idAnnonceProposition"));
		Assert.assertEquals(0, results.getInt("estReponseARecherche"));
		Assert.assertEquals("departTest", results.getString("villeDepart"));
		Assert.assertEquals("arriveeTest", results.getString("villeArrivee"));
		Assert.assertEquals("2014/01/020001", results.getString("dateEtHeureTrajet"));
		Assert.assertEquals("test", results.getString("commentaire"));
		Assert.assertEquals(25, results.getFloat("prix"), 0.01);
		Assert.assertEquals(2, results.getInt("nbPlace"));
		Assert.assertEquals(0, results.getInt("nbPlaceDispo"));
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertFalse(results.next());
		
		stmt.executeUpdate("UPDATE `reserver` SET demandeConfirmee = 1 WHERE idAnnonceProposition = 1 AND login = 'log'");
		results = stmt.executeQuery("SELECT * FROM reserver WHERE idAnnonceProposition = 1 AND login = 'log'");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt("idReserver"));
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertEquals(1, results.getInt("idAnnonceProposition"));
		Assert.assertEquals(1, results.getInt("demandeConfirmee"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListerMesAnnonceProposition() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT * FROM annonceproposition WHERE login = 'log' ORDER BY idAnnonceProposition ASC");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt("idAnnonceProposition"));
		Assert.assertEquals(0, results.getInt("estReponseARecherche"));
		Assert.assertEquals("departTest", results.getString("villeDepart"));
		Assert.assertEquals("arriveeTest", results.getString("villeArrivee"));
		Assert.assertEquals("2014/01/020001", results.getString("dateEtHeureTrajet"));
		Assert.assertEquals("test", results.getString("commentaire"));
		Assert.assertEquals(25, results.getFloat("prix"), 0.01);
		Assert.assertEquals(2, results.getInt("nbPlace"));
		Assert.assertEquals(1, results.getInt("nbPlaceDispo"));
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertFalse(results.next());
		
		results = stmt.executeQuery("SELECT * FROM reserver INNER JOIN utilisateur ON reserver.login = utilisateur.login WHERE reserver.idAnnonceProposition = 1 AND reserver.demandeConfirmee = 1 ORDER BY reserver.idReserver ASC ");		
		
		Assert.assertFalse(results.next());
		
		results = stmt.executeQuery("SELECT * FROM reserver INNER JOIN utilisateur ON reserver.login = utilisateur.login WHERE reserver.idAnnonceProposition = 1 AND reserver.demandeConfirmee = 0 ORDER BY reserver.idReserver ASC ");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertEquals("test@gmail.com", results.getString("email"));
		Assert.assertEquals("passwordTest", results.getString("password"));
		Assert.assertEquals("ipTest", results.getString("ip"));
		Assert.assertEquals("NOMTEST", results.getString("nom"));
		Assert.assertEquals("Prenomtest", results.getString("prenom"));
		Assert.assertEquals("0312345678", results.getString("telephone"));
		Assert.assertEquals("2014-01-02 00:01:02.0", results.getString("registered"));
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListerMesAnnonceRecherche() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT * FROM annoncerecherche WHERE login = 'log' ORDER BY dateEtHeureRecherche ASC");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt("idAnnonceRecherche"));
		Assert.assertEquals("departRechercheTest", results.getString("villeDepartRecherche"));
		Assert.assertEquals("arriveeRechercheTest", results.getString("villeArriveeRecherche"));
		Assert.assertEquals("2014/05/060708", results.getString("dateEtHeureRecherche"));
		Assert.assertEquals("testRecherche", results.getString("commentaireRecherche"));
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListerAnnoncePropositionLeConcernant() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT * FROM annonceproposition INNER JOIN reserver ON annonceproposition.idAnnonceProposition = reserver.idAnnonceProposition WHERE reserver.login = 'log' AND reserver.demandeConfirmee = 0 ORDER BY annonceproposition.dateEtHeureTrajet ASC");		
		
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt("idAnnonceProposition"));
		Assert.assertEquals(0, results.getInt("estReponseARecherche"));
		Assert.assertEquals("departTest", results.getString("villeDepart"));
		Assert.assertEquals("arriveeTest", results.getString("villeArrivee"));
		Assert.assertEquals("2014/01/020001", results.getString("dateEtHeureTrajet"));
		Assert.assertEquals("test", results.getString("commentaire"));
		Assert.assertEquals(25, results.getFloat("prix"), 0.01);
		Assert.assertEquals(2, results.getInt("nbPlace"));
		Assert.assertEquals(1, results.getInt("nbPlaceDispo"));
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
}
