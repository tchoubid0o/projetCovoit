package omw.dao;

import java.util.List;

import omw.model.AnnonceProposition;

public interface AnnonceDao {
	public void insertProposition(Integer rep, String villeDepart, String villeArrivee, String date, String heure, String minute, String prix, String nbPlace, String comment, String login, String[] etapes);

	public void insertRecherche(String villeDepart, String villeArrivee, String date, String heure, String minute,	String comment, String login);

	public List<AnnonceProposition> listerAnnonceProposition();
}
