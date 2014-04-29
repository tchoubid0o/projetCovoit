package omw.model;

import java.util.Date;

public class Utilisateur {
	
	private String login;
	private String email;
	private String password;
	private String ip;
	private String nom;
	private String prenom;
	private String telephone;
	private Date registered;
	
	public Utilisateur(String login, String email, String password, String ip,
			String nom, String prenom, String telephone, Date registered) {
		super();
		this.login = login;
		this.email = email;
		this.password = password;
		this.ip = ip;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.registered = registered;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}
}
