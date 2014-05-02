package omw.dao;

import java.util.List;

import omw.model.Ville;

public interface EtapesDao {
	public List<Ville> listerEtape(Integer idAnnonce);
}
