package fr.dauphine.miageif.controleur;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dauphine.miageif.bean.User;
import fr.dauphine.miageif.dao.BaseDao;
import fr.dauphine.miageif.dao.BaseDaoImp;


public class EnregistrementControleur extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrementControleur() {
    	
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.sendRedirect("loginRegistration.jsp");
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String msg = "La confirmation du mot de passe est fausse !";
  String page = "loginRegistration.jsp";
 
  if(request.getParameter("password").equals(request.getParameter("confPassword"))){
   User user = new User();
   user.setUsername(request.getParameter("username"));
   user.setPassword(request.getParameter("password"));
   user.setFirstName(request.getParameter("firstName"));
   user.setLastName(request.getParameter("lastName"));
   user.setDob(request.getParameter("dob"));
   user.setEmailId(request.getParameter("emailId"));
   user.setMobileNo(request.getParameter("mobileNo"));
   
   System.out.println(user.toString());
   BaseDao baseDao = new BaseDaoImp();
   msg = baseDao.register(user);
   page = "login.jsp";
  } 
  request.setAttribute("msg2", msg);
  request.getRequestDispatcher(page).include(request, response);
 }

}