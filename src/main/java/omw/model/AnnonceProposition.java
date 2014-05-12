package omw.model;

import java.sql.Date;
import java.util.ArrayList;

public class AnnonceProposition {

	private int idAnnonceProposition;
	private boolean estReponseARecherche;
	private String villeDepart;
	private String villeArrivee;
	private String dateEtHeureTrajet;
	private String heure;
	private String minute;
	private String commentaire;
	private float prix;
	private int nbPlace;
	private String login;
	private ArrayList<Utilisateur> listePersonneSouhaitantParticiperCovoit;
	private ArrayList<Utilisateur> listePersonneAccepteeDansCovoit;
	
	public AnnonceProposition(int idAnnonceProposition,
			boolean estReponseARecherche, String villeDepart,
			String villeArrivee, String dateEtHeureTrajet, String heure,
			String minute, String commentaire, float prix, int nbPlace,
			String login) {
		super();
		this.idAnnonceProposition = idAnnonceProposition;
		this.estReponseARecherche = estReponseARecherche;
		this.villeDepart = villeDepart;
		this.villeArrivee = villeArrivee;
		this.dateEtHeureTrajet = dateEtHeureTrajet;
		this.heure = heure;
		this.minute = minute;
		this.commentaire = commentaire;
		this.prix = prix;
		this.nbPlace = nbPlace;
		this.login = login;
		this.listePersonneSouhaitantParticiperCovoit = new ArrayList<Utilisateur>();
		this.listePersonneAccepteeDansCovoit = new ArrayList<Utilisateur>();
	}
	public int getIdAnnonceProposition() {
		return idAnnonceProposition;
	}
	public void setIdAnnonceProposition(int idAnnonceProposition) {
		this.idAnnonceProposition = idAnnonceProposition;
	}
	public boolean getEstReponseARecherche() {
		return estReponseARecherche;
	}
	public void setEstReponseARecherche(boolean estReponseARecherche) {
		this.estReponseARecherche = estReponseARecherche;
	}
	public String getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}
	public String getVilleArrivee() {
		return villeArrivee;
	}
	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}
	public String getDateEtHeureTrajet() {
		return dateEtHeureTrajet;
	}
	public void setDateEtHeureTrajet(String dateEtHeureTrajet) {
		this.dateEtHeureTrajet = dateEtHeureTrajet;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public String getMinute() {
		return minute;
	}
	public void setMinute(String minute) {
		this.minute = minute;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public ArrayList<Utilisateur> getListePersonneSouhaitantParticiperCovoit() {
		return listePersonneSouhaitantParticiperCovoit;
	}
	public void setListePersonneSouhaitantParticiperCovoit(
			ArrayList<Utilisateur> listePersonneSouhaitantParticiperCovoit) {
		this.listePersonneSouhaitantParticiperCovoit = listePersonneSouhaitantParticiperCovoit;
	}
	public void addPersonneSouhaitantParticiperCovoit(Utilisateur utilisateur){
			
		listePersonneSouhaitantParticiperCovoit.add(utilisateur);
	}
	public ArrayList<Utilisateur> getListePersonneAccepteeDansCovoit() {
		return listePersonneAccepteeDansCovoit;
	}
	public void setListePersonneAccepteeDansCovoit(
			ArrayList<Utilisateur> listePersonneAccepteeDansCovoit) {
		this.listePersonneAccepteeDansCovoit = listePersonneAccepteeDansCovoit;
	}
	public void addPersonneAccepteeDansCovoit(Utilisateur utilisateur){
		
		listePersonneAccepteeDansCovoit.add(utilisateur);
	}	
}
