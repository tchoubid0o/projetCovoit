package omw.model;

import java.sql.Date;
import java.util.ArrayList;

public class AnnonceProposition {

	private int idAnnonceProposition;
	private boolean estReponseARecherche;
	private String villeDepart;
	private String villeArrivee;
	private Date dateEtHeureTrajet;
	private String commentaire;
	private int prix;
	private int nbPlace;
	private String login;
	private ArrayList<String> listeEtapes;

	public AnnonceProposition(){

	}

	public int getIdAnnonceProposition() {
		return idAnnonceProposition;
	}

	public void setIdAnnonceProposition(int idAnnonceProposition) {
		this.idAnnonceProposition = idAnnonceProposition;
	}

	public boolean isEstReponseARecherche() {
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

	public Date getDateEtHeureTrajet() {
		return dateEtHeureTrajet;
	}

	public void setDateEtHeureTrajet(Date dateEtHeureTrajet) {
		this.dateEtHeureTrajet = dateEtHeureTrajet;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
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

	public ArrayList<String> getListeEtapes() {
		return listeEtapes;
	}

	public void setListeEtapes(ArrayList<String> listeEtapes) {
		this.listeEtapes = listeEtapes;
	}

	public void addListeEtapes(String etape){
		if(etape != null && etape.equals("")){
			listeEtapes.add(etape);
		}
	}

}
