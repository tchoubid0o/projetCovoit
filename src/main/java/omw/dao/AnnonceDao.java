package omw.dao;

public interface AnnonceDao {
	public void insertProposition(Integer rep, String villeDepart, String villeArrivee, String date, String heure, String minute, String prix, String nbPlace, String comment, String login, String[] etapes);

	public void insertRecherche(String villeDepart, String villeArrivee, String date, String heure, String minute,	String comment, String login);
}
