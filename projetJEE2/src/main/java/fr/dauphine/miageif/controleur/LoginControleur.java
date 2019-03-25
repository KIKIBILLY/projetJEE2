package fr.dauphine.miageif.controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.miageif.bean.Profile;
import fr.dauphine.miageif.bean.Utilisateur;
import fr.dauphine.miageif.dao.LoginDao;

/**
 * Servlet implementation class LoginController
 */



public class LoginControleur extends HttpServlet {
 private static final long serialVersionUID = 1L;


 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("login.jsp");
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String email = request.getParameter("email");
  String password = request.getParameter("password");
  
  
  String page = "login.jsp";
  if(email.trim().length() >= 0 && email != null &&
    password.trim().length() >= 0 && password != null) {
	  Utilisateur utilisateur=null;
	  LoginDao logindao = new LoginDao();
	  utilisateur = logindao.login(email, password);
	  Profile profil= logindao.getProfile(utilisateur);
   
   if(utilisateur!= null) {
    request.setAttribute("email", email);
    request.setAttribute("msg", "Login Success.....");
    if (profil==Profile.employe) {
    	page = "compteEmployeListeClient.jsp";
    }else if(profil==Profile.client){
    	page = "store.jsp";
    }else page = "Admin.jsp";
    
   } else {
    request.setAttribute("msg", "Nom d'utilisateur/Mot de passe incorrect !!!");
   }
  } else {
   request.setAttribute("msg", "Introduisez un username/password...");
  }
  request.getRequestDispatcher(page).include(request, response);
 }
}