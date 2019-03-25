package fr.dauphine.miageif.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.dauphine.miageif.bean.Client;
import fr.dauphine.miageif.bean.Credentials;
import fr.dauphine.miageif.bean.Utilisateur;
import fr.dauphine.miageif.config.Configuration;
import fr.dauphine.miageif.dao.ObjetDao;
import fr.dauphine.miageif.db.MysqlDB;
import fr.dauphine.miageif.util.GenerateurID;

public class TestMain {
	public static void main(String[] args) throws SQLException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		Credentials credential = new Credentials();
		MysqlDB db = new MysqlDB();
		Configuration conf = new Configuration();
		String email="arezki.bourihane@dauphine.eu";
		String password="arezki06";
		
		try {
			db.open(conf.dbHost, conf.dbPort, conf.dbName, conf.dbAdminLogin, conf.dbAdminPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "Select * from utilisateur WHERE (utilisateur.email='"+email+"') AND (utilisateur.password='"+password+"')";
		try {
			
			ResultSet rs = db.executeQuery(query);
			
			if (rs.next()!= false) {
	
				String identifiant = rs.getString(1);
				String emaiL = rs.getString(2);
				String passworD = rs.getString(3);
				String nom = rs.getString(4);
				String prenom = rs.getString(5);
				String numtel = rs.getString(6);
				String adresse = rs.getString(7);
				String urlphoto= rs.getString(8);
				
				
				utilisateur.setIdentifiant(identifiant);
				credential.setEmail(emaiL);
				credential.setPassword(passworD);
				utilisateur.setCredential(credential);				
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				utilisateur.setNumeroTel(numtel);
				utilisateur.setAdresseHabitation(adresse);
				utilisateur.setUrlPhoto(urlphoto);
				
			}
			String query2 = "INSERT INTO utilisateur VALUES('123','aze@zee.ze','"+utilisateur.getCredential().getPassword()+"','"+utilisateur.getNom()+"','"+utilisateur.getPrenom()+"','"+utilisateur.getNumeroTel()+"','"+utilisateur.getAdresseHabitation()+"','"+utilisateur.getUrlPhoto()+"')";
			db.executeQuery(query2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(utilisateur.getNom());
		db.close();
	}
}
