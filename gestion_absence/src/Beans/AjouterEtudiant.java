package Beans;

public class AjouterEtudiant {
	
	private String nom;
	private String prenom;
	private String email;
	private int telephone_et;
	private int telephone_par;
	private String filiere;
	private String niveau;
	
	public AjouterEtudiant() {
		
	}

	public AjouterEtudiant(String nom, String prenom, String email, int telephone_et, int telephone_par,
			String filiere, String niveau) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone_et = telephone_et;
		this.telephone_par = telephone_par;
		this.filiere = filiere;
		this.niveau = niveau;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelephone_et() {
		return telephone_et;
	}

	public void setTelephone_et(int telephone_et) {
		this.telephone_et = telephone_et;
	}

	public int getTelephone_par() {
		return telephone_par;
	}

	public void setTelephone_par(int telephone_par) {
		this.telephone_par = telephone_par;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	

}
