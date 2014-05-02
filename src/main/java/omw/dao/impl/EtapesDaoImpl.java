package omw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import omw.dao.EtapesDao;
import omw.model.Ville;

public class EtapesDaoImpl implements EtapesDao{
	
	public List<Ville> listerEtape(Integer idAnnonce) {
		List<Ville> liste = new ArrayList<Ville>();
		try {
			Connection connection = DataSourceProvider.getDataSource()
					.getConnection();

			ResultSet results = null;

			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM etapes WHERE idAnnonceProposition = ? ORDER BY ordre ASC");
			stmt.setInt(1,idAnnonce);
			results = stmt.executeQuery();

			while (results.next()) {
				Ville ville = new Ville(
						results.getString("nomVille"));
				liste.add(ville);
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
