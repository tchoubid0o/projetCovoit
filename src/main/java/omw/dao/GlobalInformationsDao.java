package omw.dao;

import java.util.List;

import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;

public interface GlobalInformationsDao {

	public List<AnnonceProposition> listLastOffers();
	
	public List<AnnonceRecherche> listLastSearch();
	
}
