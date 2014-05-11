package omw.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AjaxNewsletterTestDaoCase {
	
	@Before
	public void purgeBDD() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		stmt.executeUpdate("DELETE FROM newsletter");
		stmt.executeUpdate("INSERT INTO `newsletter`(`idNewsletter`,`emailNewsletter`, `dateNewsletterInsc`) VALUES (1,'test@gmail.com','2014-01-02 00:01:02')");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testAddMailInNewsletter() throws SQLException{
		
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		Statement stmt = connection.createStatement();
		
		ResultSet results = stmt.executeQuery("SELECT COUNT(*) FROM newsletter WHERE emailNewsletter = 'test@gmail.com'");
		Assert.assertTrue(results.next());
		Assert.assertEquals(1, results.getInt(1));
		Assert.assertFalse(results.next());
		
		results = stmt.executeQuery("SELECT COUNT(*) FROM newsletter WHERE emailNewsletter = 'testbis@gmail.com'");
		Assert.assertTrue(results.next());
		Assert.assertEquals(0, results.getInt(1));
		Assert.assertFalse(results.next());
		
		stmt.executeUpdate("INSERT INTO `newsletter`(`idNewsletter`,`emailNewsletter`, dateNewsletterInsc) VALUES(2,'testbis@gmail.com', '2014-05-06 07:08:09')");
		results = stmt.executeQuery("SELECT * FROM newsletter WHERE idNewsletter = 2");
		Assert.assertTrue(results.next());
		Assert.assertEquals(2, results.getInt("idNewsletter"));
		Assert.assertEquals("testbis@gmail.com", results.getString("emailNewsletter"));
		Assert.assertEquals("2014-05-06 07:08:09.0", results.getString("dateNewsletterInsc"));
		Assert.assertFalse(results.next());
		
		stmt.close();
		connection.close();
	}
}
