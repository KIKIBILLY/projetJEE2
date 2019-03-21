package fr.dauphine.miageif.test;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.dauphine.miageif.config.Configuration;
import fr.dauphine.miageif.db.MysqlDB;

public class TestMain {

	public static void main(String[] args) throws SQLException {
		MysqlDB db = new MysqlDB();
		Configuration conf = new Configuration();
		db.open(conf.dbHost, conf.dbPort, conf.dbName, conf.dbAdminLogin, conf.dbAdminPwd);
		String query = "Select * from user_data";
		ResultSet rs = db.executeQuery(query);
		if (rs.next()) {
			System.out.println(rs.getString(1));
		}

	}

}
