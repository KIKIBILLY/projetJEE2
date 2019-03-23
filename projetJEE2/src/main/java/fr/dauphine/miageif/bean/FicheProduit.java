package fr.dauphine.miageif.bean;

/**
 * @author REZKELLAH
 *
 */
public class FicheProduit {
	private String libelle;
	private Double PxLJ;// prix de location par jour
	private Double CL; // caution de location
	private Double ADJ; // amende de depassement journaliere
	private String description; // description technique du projet
	private String defauts; // liste des defauts connu de l'objet

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Double getPxLJ() {
		return PxLJ;
	}

	public void setPxLJ(Double pxLJ) {
		PxLJ = pxLJ;
	}

	public Double getCL() {
		return CL;
	}

	public void setCL(Double cL) {
		CL = cL;
	}

	public Double getADJ() {
		return ADJ;
	}

	public void setADJ(Double aDJ) {
		ADJ = aDJ;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDefauts() {
		return defauts;
	}

	public void setDefauts(String defauts) {
		this.defauts = defauts;
	}
}
