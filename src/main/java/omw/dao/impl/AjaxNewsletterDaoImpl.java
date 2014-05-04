package omw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import omw.dao.AjaxNewsletterDao;


public class AjaxNewsletterDaoImpl implements AjaxNewsletterDao {
	
	public AjaxNewsletterDaoImpl() {
	}
	
	public String addMailInNewsletter(String email){
		String returnResult;
		
		try {
			//On va commencer par v�rifier que le mail n'est pas d�j� pr�sent dans la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();

			PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM newsletter WHERE emailNewsletter = ?");
			stmt.setString(1, email);
			
			
			ResultSet results = stmt.executeQuery();

			if(results.next()){
				if(results.getInt(1) > 0){
					returnResult = "<div style='color: #ea3c3d;text-align: center; margin-top: 15px;'>Vous �tes d�j� inscrit � la newsletter.</div>";
					return returnResult;
				}
				else{
					try {
						PreparedStatement stmt2 = connection.prepareStatement("INSERT INTO `newsletter`(`emailNewsletter`, dateNewsletterInsc) VALUES(?, NOW())");
						stmt2.setString(1, email);
						stmt2.executeUpdate();
						
						returnResult = "Vous vous &ecirc;tes correctement inscrit � la newsletter.";
						
						stmt2.close();
						return returnResult;
					} catch (SQLException e) {
							e.printStackTrace();
					}
				}
			}
			connection.close();
			stmt.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return "erreur";
	}
}
