package fr.dauphine.miageif.bean;

public class Utilisateur {

String identifiant;
String adresseHabitation;
String numeroTel;
String nom;
String prenom;
Credentials credential;

public String getAdresseHabitation() {
	return adresseHabitation;
}
public void setAdresseHabitation(String adresseHabitation) {
	this.adresseHabitation = adresseHabitation;
}
public String getNumeroTel() {
	return numeroTel;
}
public void setNumeroTel(String numeroTel) {
	this.numeroTel = numeroTel;
}
public String getIdentifiant() {
	return identifiant;
}
public void setIdentifiant(String identifiant) {
	this.identifiant = identifiant;
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
public Credentials getCredential() {
	return credential;
}
public void setCredential(Credentials credential) {
	this.credential = credential;
}


}
