package omw.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GlobalInformationsTestDaoCase {
	
	@Before
	public void purgeBDD() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("DELETE FROM annonceproposition");
		stmt.executeUpdate("INSERT INTO `annonceproposition`(`idAnnonceProposition`,`estReponseARecherche`, `villeDepart`, `villeArrivee`, `dateEtHeureTrajet`, `commentaire`, `prix`, `nbPlace`, `nbPlaceDispo`, `login`) VALUES (1, 0, 'departTest','arriveeTest','2014/01/020001','test',25,2,1,'log')");
		stmt.executeUpdate("DELETE FROM annoncerecherche");
		stmt.executeUpdate("INSERT INTO `annoncerecherche`(`idAnnonceRecherche`, `villeDepartRecherche`, `villeArriveeRecherche`, `dateEtHeureRecherche`, `commentaireRecherche`, `login`) VALUES (1, 'departRechercheTest', 'arriveeRechercheTest','2014/05/060708','testRecherche','log')");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListLastOffers() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT * FROM annonceproposition WHERE estReponseARecherche = 0 ORDER BY idAnnonceProposition DESC LIMIT 5");
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt("idAnnonceProposition"));
		Assert.assertEquals(0, results.getInt("estReponseARecherche"));
		Assert.assertEquals("departTest", results.getString("villeDepart"));
		Assert.assertEquals("arriveeTest", results.getString("villeArrivee"));
		Assert.assertEquals("2014/01/020001", results.getString("dateEtHeureTrajet"));
		Assert.assertEquals("test", results.getString("commentaire"));
		Assert.assertEquals(25, results.getInt("prix"));
		Assert.assertEquals(2, results.getInt("nbPlace"));
		Assert.assertEquals(1, results.getInt("nbPlaceDispo"));
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListLastSearch() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT * FROM annoncerecherche ORDER BY idAnnonceRecherche DESC LIMIT 5");
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

}
