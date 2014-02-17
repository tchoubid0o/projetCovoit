package omw.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;

import org.junit.Before;

import org.junit.Test;

import omw.dao.SkinDao;

public class SkinTestDaoCase {
	
	@Before
	public void purgeBDD() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("DELETE FROM skin");
		stmt.executeUpdate("INSERT INTO `skin`(`idSkin`,`numeroSkin`, `nomSkin`, `prixSkinRP`, `idChampion`, `idImage`) VALUES (1,0,'nomSkin', '975',1,1)");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testSelectSkin() throws SQLException{
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT * FROM skin");
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt("idSkin"));
		Assert.assertEquals(0, results.getInt("numeroskin"));
		Assert.assertEquals("nomSkin", results.getString("nomSkin"));
		Assert.assertEquals(975, results.getInt("prixSkinRP"));
		Assert.assertEquals(1, results.getInt("idChampion"));
		Assert.assertEquals(1, results.getInt("idImage"));
		
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testRemoveSkin()throws SQLException{
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("DELETE FROM skin WHERE idSkin=1");
		ResultSet results = stmt.executeQuery("SELECT * FROM skin");
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
	
	
	@Test
	public void testAddSkin()throws SQLException{
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("INSERT INTO `skin`(`idSkin`,`numeroSkin`, `nomSkin`, `prixSkinRP`, `idChampion`, `idImage`) VALUES (2,0,'nomSkin', '975',1,1)");
		ResultSet results = stmt.executeQuery("SELECT * FROM skin WHERE idSkin=2");
		Assert.assertTrue(results.next());
		Assert.assertEquals(2, results.getInt("idSkin"));
		Assert.assertEquals(0, results.getInt("numeroskin"));
		Assert.assertEquals("nomSkin", results.getString("nomSkin"));
		Assert.assertEquals(975, results.getInt("prixSkinRP"));
		Assert.assertEquals(1, results.getInt("idChampion"));
		Assert.assertEquals(1, results.getInt("idImage"));
		
		stmt.close();
		connection.close();
	}
}
