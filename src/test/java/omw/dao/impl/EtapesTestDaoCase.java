package omw.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EtapesTestDaoCase {
	
	@Before
	public void purgeBDD() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("DELETE FROM etapes");
		stmt.executeUpdate("INSERT INTO `etapes`(`idEtape`,`idAnnonceProposition`, `nomVille`, `ordre`) VALUES (1, 1, 'etapeTest',0)");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListerEtape() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT * FROM etapes WHERE idAnnonceProposition = 1 ORDER BY ordre ASC");
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt("idEtape"));
		Assert.assertEquals(1, results.getInt("idAnnonceProposition"));
		Assert.assertEquals("etapeTest", results.getString("nomVille"));
		Assert.assertEquals(0, results.getInt("ordre"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
}
