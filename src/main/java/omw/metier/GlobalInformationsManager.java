package omw.metier;

import java.util.ArrayList;
import omw.dao.GlobalInformationsDao;
import omw.dao.impl.GlobalInformationsDaoImpl;

public class GlobalInformationsManager {

	private static GlobalInformationsManager instance;

	private GlobalInformationsDao globalInformationsDao = new GlobalInformationsDaoImpl();

	private GlobalInformationsManager() {
	}

	public static GlobalInformationsManager getInstance() {
		if (instance == null) {
			instance = new GlobalInformationsManager();
		}
		return instance;
	}
	
	public Integer countImagesDataBase(){
		return globalInformationsDao.countImagesDataBase();
	}
	
	public Integer countUsersDataBase(){
		return globalInformationsDao.countUsersDataBase();
	}
	
	public Integer countVotesDataBase(){
		return globalInformationsDao.countVotesDataBase();
	}

	public ArrayList<String> returnAllCategorie() {
		return globalInformationsDao.returnAllCategorie();
	}
}
