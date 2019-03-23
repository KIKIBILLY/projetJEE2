package fr.dauphine.miageif.bean;

/**
 * @author REZKELLAH
 *
 */
public class Objet {

	private String identifiant;
	private String categorie;
	private FicheProduit fp;

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public FicheProduit getFp() {
		return fp;
	}

	public void setFp(FicheProduit fp) {
		this.fp = fp;
	}

}
