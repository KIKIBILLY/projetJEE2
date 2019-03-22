package fr.dauphine.miageif.controleur;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.miageif.bean.Annonce;
import fr.dauphine.miageif.config.Configuration;
import fr.dauphine.miageif.db.MysqlDB;

/**
 * Servlet implementation class ListProduit
 */
public class MagasinControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MagasinControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MysqlDB db = new MysqlDB();
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
			List<Annonce> ans =new ArrayList<Annonce>();
			Annonce an = null;
			while (rs.next()) { 
				an = new Annonce();
			    an.setCategory(rs.getString(1));
			    an.setName(rs.getString(2));
			    an.setImage( rs.getString(3));
			    an.setAdresse( rs.getString(5));
			    an.setPrix(Integer.parseInt( rs.getString(4)));
			    ans.add(an);
			}
			request.setAttribute("annonces", ans);
			this.getServletContext().getRequestDispatcher("/store.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
