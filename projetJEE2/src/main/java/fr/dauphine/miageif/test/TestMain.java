package fr.dauphine.miageif.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.dauphine.miageif.config.Configuration;
import fr.dauphine.miageif.db.MysqlDB;
import fr.dauphine.miageif.util.GenerateurID;

public class TestMain {

	public static void main(String[] args) throws SQLException {
		
		System.out.println(GenerateurID.generate(12));
		/*MysqlDB db = new MysqlDB();
		Configuration conf = new Configuration();
		try {
			db.open(conf.dbHost, conf.dbPort, conf.dbName, conf.dbAdminLogin, conf.dbAdminPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query = "Select * from annonce";
		try {
			ResultSet rs = db.executeQuery(query);
			String[] produit = new String[5];

			while (rs.next()) { 
			    produit[0]= rs.getString(1);
			    produit[1]= rs.getString(2);
			    produit[2]= rs.getString(3);
			    produit[3]= rs.getString(4);
			    produit[4]= rs.getString(5);
			}
			System.out.println(produit[2]);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
