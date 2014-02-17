package omw.metier;

import java.util.ArrayList;

import omw.dao.DatChampionDao;
import omw.dao.SkinDao;
import omw.dao.impl.DatChampionDaoImpl;
import omw.dao.impl.SkinDaoImpl;
import omw.model.DatChampion;
import omw.model.Skin;

public class DatChampionManager {
	
	private static DatChampionManager instance;
	
	private DatChampionDao datChampionDao = new DatChampionDaoImpl();
	
	private SkinDao skinDao = new SkinDaoImpl();
	
	private DatChampionManager() {
	}

	public static DatChampionManager getInstance() {
		if (instance == null) {
			instance = new DatChampionManager();
		}
		return instance;
	}

	public ArrayList<DatChampion> listerDatChampion() {
		return datChampionDao.listerDatChampion();
	}
	
	public void removeDatChampion(String libelle){
		datChampionDao.removeDatchampion(libelle);
	}
	
	public void addDatChampion(DatChampion datChampion){
		datChampionDao.addDatChampion(datChampion);
	}
	
	public void addSkin(Skin skin, String libelleChampion){
		skinDao.addSkin(skin, libelleChampion);
	}
}
