package omw.metier;

import omw.dao.AnnonceDao;
import omw.dao.UtilisateurDao;
import omw.dao.impl.AnnonceDaoImpl;
import omw.dao.impl.UtilisateurDaoImpl;
import omw.model.AnnonceProposition;
import omw.model.AnnonceRecherche;
import omw.model.Utilisateur;

import java.net.UnknownHostException;
import java.util.List;

public class AnnonceManager {

	private static AnnonceManager instance;

	private AnnonceDao annonceDao = new AnnonceDaoImpl();

	private AnnonceManager() {
	}

	public static AnnonceManager getInstance() {
		if (instance == null) {
			instance = new AnnonceManager();
		}
		return instance;
	}
	
	public List<AnnonceProposition> listerAnnonceProposition(){
		return annonceDao.listerAnnonceProposition();
	}
	
	public List<AnnonceRecherche> listerAnnonceRecherche(){
		return annonceDao.listerAnnonceRecherche();
	}
	
	public void updateProposition(Integer idProp, Integer rep, String villeDepart, String villeArrivee, String date, String heure, String minute, String prix, String nbPlace, String comment, String login, String[] etapes){
		annonceDao.updateProposition(idProp, rep, villeDepart, villeArrivee, date, heure, minute, prix, nbPlace, comment, login, etapes);
	}
	
	public void updateRecherche(Integer idRech, String villeDepart, String villeArrivee, String date, String heure, String minute, String comment,	String login){
		annonceDao.updateRecherche(idRech, villeDepart, villeArrivee, date, heure, minute, comment, login);
	}

	public void insertProposition(Integer rep, String villeDepart, String villeArrivee, String date, String heure, String minute, String prix, String nbPlace, String comment, String login, String[] etapes){
		annonceDao.insertProposition(rep, villeDepart, villeArrivee, date, heure, minute, prix, nbPlace, comment, login, etapes);
	}

	public void insertRecherche(String villeDepart, String villeArrivee, String date, String heure, String minute, String comment,	String login) {
		annonceDao.insertRecherche(villeDepart, villeArrivee, date, heure, minute, comment, login);
	}
	
	public List<AnnonceRecherche> listerMesAnnonceRecherche(String login) {
		return annonceDao.listerMesAnnonceRecherche(login);
	}
	
	public List<AnnonceProposition> listerMesAnnonceProposition(String login) {
		return annonceDao.listerMesAnnonceProposition(login);
	}
	
	public AnnonceProposition listerUneAnnonceProposition(Integer id){
		return annonceDao.listerUneAnnonceProposition(id);
	}
	
	public void ajouterDemandePourAnnonce(Integer idAnnonceProposition, String login){
		annonceDao.ajouterDemandePourAnnonce(idAnnonceProposition, login);
	}
	
	public void deleteAds(Integer idProp, String type){
		annonceDao.deleteAds(idProp, type);
	}
	
	public String listerVille(){
		return annonceDao.listerVille();
	}
	
	public List<AnnonceProposition> listerRechercheProposition(String villeDepart, String villeArrivee){
		return annonceDao.listerRechercheProposition(villeDepart, villeArrivee);
	}
	
	public String ucfirst(String chaine){
		return annonceDao.ucfirst(chaine);
	}
}
