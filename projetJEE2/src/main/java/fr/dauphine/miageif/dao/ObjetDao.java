package fr.dauphine.miageif.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.dauphine.miageif.bean.FicheProduit;
import fr.dauphine.miageif.bean.Objet;
import fr.dauphine.miageif.config.Configuration;
import fr.dauphine.miageif.db.MysqlDB;

public class ObjetDao {
	MysqlDB db = new MysqlDB();
	MysqlDB db2 = new MysqlDB();
	Configuration conf = new Configuration();

	public List<Objet> getAllListObjet() throws IOException {
		List<Objet> objets = new ArrayList<Objet>();
		try {
			db.open(conf.dbHost, conf.dbPort, conf.dbName, conf.dbAdminLogin, conf.dbAdminPwd);
			db2.open(conf.dbHost, conf.dbPort, conf.dbName, conf.dbAdminLogin, conf.dbAdminPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "Select * from objet";
		try {
			ResultSet rs = db.executeQuery(query);
			Objet objet = null;
			FicheProduit fp = null;
			while (rs.next()) {
				objet = new Objet();
				fp = new FicheProduit();
				objet.setIdentifiant(rs.getString(1));
				objet.setCategorie(rs.getString(2));
				fp.setLibelle(rs.getString(3));
				fp.setDescription(rs.getString(4));
				fp.setpxlj(rs.getDouble(5));
				fp.setcl(rs.getDouble(6));
				fp.setadj(rs.getDouble(7));
				fp.setDefauts(rs.getString(8));
				objet.setFp(fp);
				ResultSet rs2 = db2.executeQuery(
						"select url_image from image_objet as i,objet as o where i.id_objet=o.id_objet and i.id_objet='"
								+ objet.getIdentifiant() + "'");
				while(rs2.next()) {
					objet.getImages().add(rs2.getString(1));
				}
				objets.add(objet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objets;
	}
}
