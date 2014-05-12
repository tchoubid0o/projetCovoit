package omw.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UtilisateurTestDaoCase {
	
	@Before
	public void purgeBDD() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("DELETE FROM utilisateur");
		stmt.executeUpdate("INSERT INTO `utilisateur`(`login`,`email`, `password`, `ip`, `nom`, `prenom`, `telephone`, `registered`) VALUES ('log', 'test@gmail.com','passwordTest','ipTest','NOMTEST','Prenomtest','0312345678','2014-01-02 00:01:02')");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testListerUsers() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur");
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
	
	@Test	
	public void testgetUser() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur WHERE login = 'log'");
		Assert.assertTrue(results.next());
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}	

	@Test
	public void testCountUsersMailUsed() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT COUNT(*) FROM utilisateur WHERE email = 'test@gmail.com'");
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt(1));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testCountUsersPseudoUsed() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT COUNT(*) FROM utilisateur WHERE login = 'log'");
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt(1));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}

	@Test
	public void testAjouterUser() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("INSERT INTO `utilisateur`(`login`,`email`, `password`, `ip`, `nom`, `prenom`, `telephone`, `registered`) VALUES ('logbis', 'testbis@gmail.com','passwordTestBis','ipTestBis','NOMTESTBIS','Prenomtestbis','0387654321','2014-05-06 09:08:07')");
		ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur WHERE login = 'logbis'");
		Assert.assertTrue(results.next());
		Assert.assertEquals("logbis", results.getString("login"));
		Assert.assertEquals("testbis@gmail.com", results.getString("email"));
		Assert.assertEquals("passwordTestBis", results.getString("password"));
		Assert.assertEquals("ipTestBis", results.getString("ip"));
		Assert.assertEquals("NOMTESTBIS", results.getString("nom"));
		Assert.assertEquals("Prenomtestbis", results.getString("prenom"));
		Assert.assertEquals("0387654321", results.getString("telephone"));
		Assert.assertEquals("2014-05-06 09:08:07.0", results.getString("registered"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test	
	public void testGetPasswordConnexion() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT password FROM utilisateur WHERE login = 'log'");
		Assert.assertTrue(results.next());
		Assert.assertEquals("passwordTest", results.getString(1));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	@Test	
	public void testEditMySettings() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("UPDATE utilisateur SET email = 'newtest@gmail.com', password = 'newPasswordTest', telephone = '0356781234'  WHERE login = 'log'");
		ResultSet results = stmt.executeQuery("SELECT * FROM utilisateur WHERE login = 'log'");
		Assert.assertTrue(results.next());
		Assert.assertEquals("log", results.getString("login"));
		Assert.assertEquals("newtest@gmail.com", results.getString("email"));
		Assert.assertEquals("newPasswordTest", results.getString("password"));
		Assert.assertEquals("ipTest", results.getString("ip"));
		Assert.assertEquals("NOMTEST", results.getString("nom"));
		Assert.assertEquals("Prenomtest", results.getString("prenom"));
		Assert.assertEquals("0356781234", results.getString("telephone"));
		Assert.assertEquals("2014-01-02 00:01:02.0", results.getString("registered"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
}
