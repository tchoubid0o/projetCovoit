package omw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import omw.dao.SkinDao;
import omw.model.Skin;

public class SkinDaoImpl implements SkinDao{
	
	public void addSkin(Skin skin, String libelleChampion){
		
		try{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("SELECT idChampion FROM champion WHERE libelleChampion=?");
			stmt.setString(1,libelleChampion);
			ResultSet results = stmt.executeQuery();
			int idChampion=0;
			if(results.next()){
				idChampion = results.getInt("idChampion");
			}
			
			stmt = connection.prepareStatement("INSERT INTO `image` (`imagePath`) VALUES(?)");
			stmt.setString(1,skin.getImagePath());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement("SELECT idImage FROM image WHERE imagePath=?");
			stmt.setString(1,skin.getImagePath());
			results = stmt.executeQuery();
			int idImageSkin=0;
			if(results.next()){
				idImageSkin = results.getInt("idImage");
			}
			
			stmt = connection.prepareStatement("INSERT INTO `skin` (`numeroSkin`,`nomSkin`,`prixSkinRP`,`idChampion`,`idImage`) VALUES(?,?,?,?,?)");
			stmt.setInt(1,skin.getNumeroSkin());
			stmt.setString(2,skin.getNomSkin());
			stmt.setInt(3,skin.getPrice());
			stmt.setInt(4,idChampion);
			stmt.setInt(5,idImageSkin);
			stmt.executeUpdate();
			
			stmt.close();
			results.close();
			connection.close();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
