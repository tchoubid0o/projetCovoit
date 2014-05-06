package omw.dao;

import java.util.List;

import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;

public interface AnnonceDao {
	public void insertProposition(Integer rep, String villeDepart, String villeArrivee, String date, String heure, String minute, String prix, String nbPlace, String comment, String login, String[] etapes);

	public void insertRecherche(String villeDepart, String villeArrivee, String date, String heure, String minute,	String comment, String login);	

	public void ajouterDemandePourAnnonce(Integer idAnnonceProposition, String login);
	
	public void refuserDemandePourAnnonce(Integer idAnnonceProposition, String login);
	
	public void accepterDemandePourAnnonce(Integer idAnnonceProposition, String login);

	public List<AnnonceProposition> listerAnnonceProposition();

	public List<AnnonceRecherche> listerAnnonceRecherche();

	public List<AnnonceRecherche> listerMesAnnonceRecherche(String login);

	public List<AnnonceProposition> listerMesAnnonceProposition(String login);
	
	public AnnonceProposition listerUneAnnonceProposition(Integer id);
	
	public void updateProposition(Integer idProp, Integer rep, String villeDepart, String villeArrivee, String date, String heure, String minute, String prix, String nbPlace, String comment, String login, String[] etapes);

	public void updateRecherche(Integer idRech, String villeDepart, String villeArrivee, String date, String heure, String minute, String comment,	String login);

	public void deleteAds(Integer idProp, String type);
	
	public String listerVille();
	
	public List<AnnonceProposition> listerRechercheProposition(String villeDepart, String villeArrivee);
	
	public String ucfirst(String chaine);
}
