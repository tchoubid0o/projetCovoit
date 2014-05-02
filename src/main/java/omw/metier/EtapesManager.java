package omw.metier;

import omw.dao.EtapesDao;
import omw.dao.impl.EtapesDaoImpl;
import omw.model.Ville;

import java.util.List;

public class EtapesManager {

	private static EtapesManager instance;

	private EtapesDao etapesDao = new EtapesDaoImpl();

	private EtapesManager() {
	}

	public static EtapesManager getInstance() {
		if (instance == null) {
			instance = new EtapesManager();
		}
		return instance;
	}
	
	public List<Ville> listerEtape(Integer idAnnonce){
		return etapesDao.listerEtape(idAnnonce);
	}
}
