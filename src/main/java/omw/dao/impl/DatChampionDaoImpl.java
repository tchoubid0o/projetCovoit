package omw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EmptyStackException;

import omw.dao.DatChampionDao;
import omw.model.Ability;
import omw.model.Champion;
import omw.model.DatChampion;
import omw.model.Skin;

public class DatChampionDaoImpl implements DatChampionDao{
	
	public ArrayList<DatChampion> listerDatChampion(){
		
		ArrayList<DatChampion> listDatChampion = new ArrayList<DatChampion>();
		
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
	
			Statement stmtListChampion = connection.createStatement();
			ResultSet resultsListChampion = stmtListChampion.executeQuery("SELECT * FROM champion  INNER JOIN image ON champion.idImage=image.idImage ORDER BY champion.libelleChampion");
			
	
			while (resultsListChampion.next()) {
				Champion champion = new Champion();
				champion.setLibelle(resultsListChampion.getString("libelleChampion"));
				champion.setNom(resultsListChampion.getString("nomChampion"));
				champion.setSousNom(resultsListChampion.getString("sousNomChampion"));
				champion.setOffense(resultsListChampion.getInt("offense"));
				champion.setDefense(resultsListChampion.getInt("defense"));
				champion.setMagie(resultsListChampion.getInt("magie"));
				champion.setDifficulte(resultsListChampion.getInt("difficulte"));
				champion.setVie(resultsListChampion.getInt("vie"));
				champion.setVieLevel(resultsListChampion.getDouble("vieLevel"));
				champion.setMana(resultsListChampion.getInt("mana"));
				champion.setManaLevel(resultsListChampion.getDouble("manaLevel"));
				champion.setAttaque(resultsListChampion.getDouble("attaque"));
				champion.setAttaqueLevel(resultsListChampion.getDouble("attaqueLevel"));
				champion.setVitesseAttaque(resultsListChampion.getDouble("vitesseAttaque"));
				champion.setVitesseAttaqueLevel(resultsListChampion.getDouble("vitesseAttaqueLevel"));
				champion.setRegenVie(resultsListChampion.getDouble("regenVie"));
				champion.setRegenVieLevel(resultsListChampion.getDouble("regenVieLevel"));
				champion.setRegenMana(resultsListChampion.getDouble("regenMana"));
				champion.setRegenManaLevel(resultsListChampion.getDouble("regenManaLevel"));
				champion.setArmure(resultsListChampion.getDouble("armure"));
				champion.setArmureLevel(resultsListChampion.getDouble("armureLevel"));
				champion.setMagicRes(resultsListChampion.getDouble("magicRes"));
				champion.setMagicResLevel(resultsListChampion.getDouble("magicResLevel"));
				champion.setVitesse(resultsListChampion.getInt("vitesse"));
				champion.setImagePath(resultsListChampion.getString("imagePath"));
				
				DatChampion datChampion = new DatChampion(champion);
				listDatChampion.add(datChampion);
			}			

			stmtListChampion.close();
			resultsListChampion.close();
			
			for(int i = 0 ; i < listDatChampion.size() ; i++)
			{
				PreparedStatement stmtListSkinsChampion = connection.prepareStatement("SELECT * FROM champion INNER JOIN skin ON champion.idChampion=skin.idChampion INNER JOIN image ON skin.idImage=image.idImage WHERE champion.libelleChampion=? ORDER BY numeroSkin");			
				stmtListSkinsChampion.setString(1,listDatChampion.get(i).getChampion().getLibelle());
				ResultSet resultsListSkinsChampion = stmtListSkinsChampion.executeQuery();
				
				while (resultsListSkinsChampion.next()) {
					Skin skin = new Skin();
					skin.setNumeroSkin(resultsListSkinsChampion.getInt("numeroSkin"));
					skin.setNomSkin(resultsListSkinsChampion.getString("nomSkin"));
					skin.setPrice(resultsListSkinsChampion.getInt("prixSkinRP"));
					skin.setImagePath(resultsListSkinsChampion.getString("imagePath"));
					
					listDatChampion.get(i).addSkin(skin);
				}
				
				stmtListSkinsChampion.close();
				resultsListSkinsChampion.close();
				
				PreparedStatement stmtListAbilitiesChampion = connection.prepareStatement("SELECT * FROM champion INNER JOIN ability ON champion.idChampion=ability.idChampion INNER JOIN image ON ability.idImage=image.idImage WHERE champion.libelleChampion=? ORDER BY numeroAbility");			
				stmtListAbilitiesChampion.setString(1,listDatChampion.get(i).getChampion().getLibelle());
				ResultSet resultsAbilitiesChampion = stmtListAbilitiesChampion.executeQuery();
				
				while (resultsAbilitiesChampion.next()) {
					Ability ability = new Ability();
					ability.setLettreAbility(resultsAbilitiesChampion.getString("lettreAbility"));
					ability.setNomAbility(resultsAbilitiesChampion.getString("nomAbility"));
					ability.setImagePath(resultsAbilitiesChampion.getString("imagePath"));
					
					listDatChampion.get(i).addAbility(ability);
				}
				
				stmtListAbilitiesChampion.close();
				resultsAbilitiesChampion.close();
			}	
			
			
			
			connection.close();
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return listDatChampion;
	}
	

	public void addDatChampion(DatChampion datChampion){

		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("SELECT idChampion FROM champion WHERE libelleChampion=?");
			stmt.setString(1, datChampion.getChampion().getLibelle());
			ResultSet results = stmt.executeQuery();
			if(results.next()){
				System.out.println("le champion existe deja");
				throw (new EmptyStackException());
			}
			
			//ajout des images concernant le champion
			 
			stmt = connection.prepareStatement("INSERT INTO `image` (`imagePath`) VALUES(?)");
			stmt.setString(1, datChampion.getChampion().getImagePath());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement("SELECT idImage FROM image WHERE imagePath=?");
			stmt.setString(1, datChampion.getChampion().getImagePath());
			results = stmt.executeQuery();
			int idIconeChamp=0;
			if(results.next()){
				idIconeChamp = results.getInt("idImage");
			}
			
			stmt = connection.prepareStatement("INSERT INTO `image` (`imagePath`) VALUES(?)");
			stmt.setString(1, datChampion.getListSkins().get(0).getImagePath());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement("SELECT idImage FROM image WHERE imagePath=?");
			stmt.setString(1, datChampion.getListSkins().get(0).getImagePath());
			results = stmt.executeQuery();
			int idImageChamp=0;
			if(results.next()){
				idImageChamp = results.getInt("idImage");
			}
			
			stmt = connection.prepareStatement("INSERT INTO `image` (`imagePath`) VALUES(?)");
			stmt.setString(1, datChampion.getChampion().getImagePath());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement("SELECT idImage FROM image WHERE imagePath=?");
			stmt.setString(1, datChampion.getListAbilities().get(0).getImagePath());
			results = stmt.executeQuery();
			int idImageP=0;
			if(results.next()){
				idImageP = results.getInt("idImage");
			}
			
			stmt = connection.prepareStatement("INSERT INTO `image` (`imagePath`) VALUES(?)");
			stmt.setString(1, datChampion.getListAbilities().get(1).getImagePath());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement("SELECT idImage FROM image WHERE imagePath=?");
			stmt.setString(1, datChampion.getListAbilities().get(1).getImagePath());
			results = stmt.executeQuery();
			int idImageQ=0;
			if(results.next()){
				idImageQ = results.getInt("idImage");
			}
			
			stmt = connection.prepareStatement("INSERT INTO `image` (`imagePath`) VALUES(?)");
			stmt.setString(1, datChampion.getListAbilities().get(2).getImagePath());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement("SELECT idImage FROM image WHERE imagePath=?");
			stmt.setString(1, datChampion.getListAbilities().get(2).getImagePath());
			results = stmt.executeQuery();
			int idImageW=0;
			if(results.next()){
				idImageW = results.getInt("idImage");
			}
			
			stmt = connection.prepareStatement("INSERT INTO `image` (`imagePath`) VALUES(?)");
			stmt.setString(1, datChampion.getListAbilities().get(3).getImagePath());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement("SELECT idImage FROM image WHERE imagePath=?");
			stmt.setString(1, datChampion.getListAbilities().get(3).getImagePath());
			results = stmt.executeQuery();
			int idImageE=0;
			if(results.next()){
				idImageE = results.getInt("idImage");
			}
			
			stmt = connection.prepareStatement("INSERT INTO `image` (`imagePath`) VALUES(?)");
			stmt.setString(1, datChampion.getListAbilities().get(4).getImagePath());
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement("SELECT idImage FROM image WHERE imagePath=?");
			stmt.setString(1, datChampion.getListAbilities().get(4).getImagePath());
			results = stmt.executeQuery();
			int idImageR=0;
			if(results.next()){
				idImageR = results.getInt("idImage");
			}
			
			//ajout du champion en lui meme
			
			stmt = connection.prepareStatement("INSERT INTO `champion` (`libelleChampion`,`nomChampion`,`sousNomChampion`,`offense`,`defense`,`magie`,`difficulte`,`vie`,`vieLevel`,`mana`,`manaLevel`,`attaque`,`attaqueLevel`,`vitesseAttaque`,`vitesseAttaqueLevel`,`regenVie`,`regenVieLevel`,`regenMana`,`regenManaLevel`,`armure`,`armureLevel`,`magicRes`,`magicResLevel`,`vitesse`,`idImage`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, datChampion.getChampion().getLibelle());
			stmt.setString(2, datChampion.getChampion().getNom());
			stmt.setString(3, datChampion.getChampion().getSousNom());
			stmt.setInt(4, datChampion.getChampion().getOffense());
			stmt.setInt(5, datChampion.getChampion().getDefense());
			stmt.setInt(6, datChampion.getChampion().getMagie());
			stmt.setInt(7, datChampion.getChampion().getDifficulte());
			stmt.setInt(8, datChampion.getChampion().getVie());
			stmt.setDouble(9, datChampion.getChampion().getVieLevel());
			stmt.setInt(10, datChampion.getChampion().getMana());
			stmt.setDouble(11, datChampion.getChampion().getManaLevel());
			stmt.setDouble(12, datChampion.getChampion().getAttaque());
			stmt.setDouble(13, datChampion.getChampion().getAttaqueLevel());
			stmt.setDouble(14, datChampion.getChampion().getVitesseAttaque());
			stmt.setDouble(15, datChampion.getChampion().getVitesseAttaqueLevel());
			stmt.setDouble(16, datChampion.getChampion().getRegenVie());
			stmt.setDouble(17, datChampion.getChampion().getRegenVieLevel());
			stmt.setDouble(18, datChampion.getChampion().getRegenMana());
			stmt.setDouble(19, datChampion.getChampion().getRegenManaLevel());
			stmt.setDouble(20, datChampion.getChampion().getArmure());
			stmt.setDouble(21, datChampion.getChampion().getArmureLevel());
			stmt.setDouble(22, datChampion.getChampion().getMagicRes());
			stmt.setDouble(23, datChampion.getChampion().getMagicResLevel());
			stmt.setInt(24, datChampion.getChampion().getVitesse());
			stmt.setDouble(25, idIconeChamp);
			stmt.executeUpdate();
			
			stmt = connection.prepareStatement("SELECT idChampion FROM champion WHERE libelleChampion=?");
			stmt.setString(1,datChampion.getChampion().getLibelle());
			results = stmt.executeQuery();
			int idChampion=0;
			if(results.next()){
				idChampion = results.getInt("idChampion");
			}
			
			
			//ajout du skin du champion
			
			stmt = connection.prepareStatement("INSERT INTO `skin` (`numeroSkin`,`nomSkin`,`prixSkinRP`,`idChampion`,`idImage`) VALUES (?,?,?,?,?)");
			stmt.setInt(1, datChampion.getListSkins().get(0).getNumeroSkin());
			stmt.setString(2, datChampion.getListSkins().get(0).getNomSkin());
			stmt.setInt(3, datChampion.getListSkins().get(0).getPrice());
			stmt.setInt(4, idChampion);
			stmt.setInt(5, idImageChamp);
			stmt.executeUpdate();
			
			
			//ajout des abilities
			
			stmt = connection.prepareStatement("INSERT INTO `ability` (`numeroAbility`,`lettreAbility`,`nomAbility`,`idChampion`,`idImage`) VALUES (?,?,?,?,?)");
			stmt.setInt(1, 0);
			stmt.setString(2, datChampion.getListAbilities().get(0).getLettreAbility());
			stmt.setString(3, datChampion.getListAbilities().get(0).getNomAbility());
			stmt.setInt(4, idChampion);
			stmt.setInt(5, idImageP);
			stmt.executeUpdate();
			
			stmt.setInt(1, 1);
			stmt.setString(2, datChampion.getListAbilities().get(1).getLettreAbility());
			stmt.setString(3, datChampion.getListAbilities().get(1).getNomAbility());
			stmt.setInt(4, idChampion);
			stmt.setInt(5, idImageQ);
			stmt.executeUpdate();
			
			stmt.setInt(1, 2);
			stmt.setString(2, datChampion.getListAbilities().get(2).getLettreAbility());
			stmt.setString(3, datChampion.getListAbilities().get(2).getNomAbility());
			stmt.setInt(4, idChampion);
			stmt.setInt(5, idImageW);
			stmt.executeUpdate();
			
			stmt.setInt(1, 3);
			stmt.setString(2, datChampion.getListAbilities().get(3).getLettreAbility());
			stmt.setString(3, datChampion.getListAbilities().get(3).getNomAbility());
			stmt.setInt(4, idChampion);
			stmt.setInt(5, idImageE);
			stmt.executeUpdate();
			
			stmt.setInt(1, 4);
			stmt.setString(2, datChampion.getListAbilities().get(4).getLettreAbility());
			stmt.setString(3, datChampion.getListAbilities().get(4).getNomAbility());
			stmt.setInt(4, idChampion);
			stmt.setInt(5, idImageR);
			stmt.executeUpdate();
			
			stmt.close();
			results.close();
			connection.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeDatchampion(String libelle){
		
		try{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			PreparedStatement stmt = connection.prepareStatement("SELECT idChampion,idImage FROM champion WHERE libelleChampion=?");
			stmt.setString(1,libelle);
			ResultSet results = stmt.executeQuery();
			int idChampion=0;
			int idIconeChamp=0;
			if(results.next()){
				idChampion = results.getInt("idChampion");
				idIconeChamp = results.getInt("idImage");
			}
			
			stmt = connection.prepareStatement("SELECT idImage FROM champion WHERE idChampion=?");
			stmt.setInt(1,idChampion);
			results = stmt.executeQuery();
			ArrayList<Integer> listIdSkinImages= new ArrayList<Integer>();
			while(results.next()){
				listIdSkinImages.add(results.getInt("idImage"));
			}
			
			stmt = connection.prepareStatement("SELECT idImage FROM ability WHERE idChampion=?");
			stmt.setInt(1,idChampion);
			results = stmt.executeQuery();
			ArrayList<Integer> listIdAbilityImages= new ArrayList<Integer>();
			while(results.next()){
				listIdAbilityImages.add(results.getInt("idImage"));
			}
			
			stmt = connection.prepareStatement("DELETE FROM `champion` WHERE idChampion=?");
			stmt.setInt(1,idChampion);
			stmt.executeUpdate();
			stmt = connection.prepareStatement("DELETE FROM `skin` WHERE idChampion=?");
			stmt.setInt(1,idChampion);
			stmt.executeUpdate();
			stmt = connection.prepareStatement("DELETE FROM `ability` WHERE idChampion=?");
			stmt.setInt(1,idChampion);
			stmt.executeUpdate();
			stmt = connection.prepareStatement("DELETE FROM `image` WHERE idImage=?");
			stmt.setInt(1,idIconeChamp);
			stmt.executeUpdate();
			
			for(int i = 0 ; i < listIdSkinImages.size() ; i++){
				stmt = connection.prepareStatement("DELETE FROM `image` WHERE idImage=?");
				stmt.setInt(1,listIdSkinImages.get(i));
				stmt.executeUpdate();
			}
			
			for(int i = 0 ; i < listIdAbilityImages.size() ; i++){
				stmt = connection.prepareStatement("DELETE FROM `image` WHERE idImage=?");
				stmt.setInt(1,listIdAbilityImages.get(i));
				stmt.executeUpdate();
			}
			
			stmt.close();
			results.close();
			connection.close();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
