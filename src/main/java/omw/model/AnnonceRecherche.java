package omw.model;

public class AnnonceRecherche {
	
	private int idAnnonceRecherche;
	private String villeDepartRecherche;
	private String villeArriveeRecherche;
	private String dateEtHeureRecherche;
	private String heure;
	private String minute;
	private String commentaireRecherche;
	private String login;
	
	public AnnonceRecherche(int idAnnonceRecherche,
			String villeDepartRecherche, String villeArriveeRecherche,
			String dateEtHeureRecherche, String heure, String minute,
			String commentaireRecherche, String login) {
		super();
		this.idAnnonceRecherche = idAnnonceRecherche;
		this.villeDepartRecherche = villeDepartRecherche;
		this.villeArriveeRecherche = villeArriveeRecherche;
		this.dateEtHeureRecherche = dateEtHeureRecherche;
		this.heure = heure;
		this.minute = minute;
		this.commentaireRecherche = commentaireRecherche;
		this.login = login;
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
	public String getDateEtHeureRecherche() {
		return dateEtHeureRecherche;
	}
	public void setDateEtHeureRecherche(String dateEtHeureRecherche) {
		this.dateEtHeureRecherche = dateEtHeureRecherche;
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
