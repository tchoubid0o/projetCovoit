package omw.metier;

import java.util.ArrayList;
import java.util.List;

import omw.dao.GlobalInformationsDao;
import omw.dao.impl.GlobalInformationsDaoImpl;
import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;

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
	public List<AnnonceProposition> listLastOffers(){
		return globalInformationsDao.listLastOffers();
	}
	
	public List<AnnonceRecherche> listLastSearch(){
		return globalInformationsDao.listLastSearch();
	}
}
