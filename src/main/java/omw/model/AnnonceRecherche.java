package omw.model;

import java.sql.Date;

public class AnnonceRecherche {
	
	private int idAnnonceRecherche;
	private String villeDepartRecherche;
	private String villeArriveeRecherche;
	private Date dateEtHeureRecherche;
	private String commentaireRecherche;
	private String login;
	
	public AnnonceRecherche(){
		
	}

	public int getIdAnnonceRecherche() {
		return idAnnonceRecherche;
	}

	public void setIdAnnonceRecherche(int idAnnonceRecherche) {
		this.idAnnonceRecherche = idAnnonceRecherche;
	}

	public String getVilleDepartRecherche() {
		return villeDepartRecherche;
	}

	public void setVilleDepartRecherche(String villeDepartRecherche) {
		this.villeDepartRecherche = villeDepartRecherche;
	}

	public String getVilleArriveeRecherche() {
		return villeArriveeRecherche;
	}

	public void setVilleArriveeRecherche(String villeArriveeRecherche) {
		this.villeArriveeRecherche = villeArriveeRecherche;
	}

	public Date getDateEtHeureRecherche() {
		return dateEtHeureRecherche;
	}

	public void setDateEtHeureRecherche(Date dateEtHeureRecherche) {
		this.dateEtHeureRecherche = dateEtHeureRecherche;
	}

	public String getCommentaireRecherche() {
		return commentaireRecherche;
	}

	public void setCommentaireRecherche(String commentaireRecherche) {
		this.commentaireRecherche = commentaireRecherche;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
