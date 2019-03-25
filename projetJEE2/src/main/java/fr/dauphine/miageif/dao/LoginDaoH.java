package fr.dauphine.miageif.dao;

import org.hibernate.Session;

import fr.dauphine.miageif.bean.Utilisateur;
import fr.dauphine.miageif.util.HibernateUtil;

public class LoginDaoH {
	
	 
	 public boolean login(String email, String password) {
	 Session session = HibernateUtil.getSession();
	  if (session != null) {
	   try {
	    Utilisateur user = (Utilisateur) session.get(Utilisateur.class, email);
	    if (password.equals(user.getCredential().getPassword())) {
	     System.out.println("User: " + user.toString());
	     return true;
	    }
	   } catch (Exception exception) {
	    System.out.println("Exception occred while reading user data: "
	      + exception.getMessage());
	    return false;
	   }

	  } else {
	   System.out.println("DB server down.....");
	  }
	  return false;
	 }

	 public String register(Utilisateur user) {
	  String msg = "Registration unsuccessful, try again.....";
	  Session session = HibernateUtil.getSession();
	  if (session != null) {
	   try {
	    if (user != null) {
	     String username = (String) session.save(user);
	     session.beginTransaction().commit();
	     msg = "User " + username
	       + " created successfully, please login...";
	    }
	   } catch (Exception exception) {
	    System.out.println("Exception occred while reading user data: "
	      + exception.getMessage());
	   }

	  } else {
	   System.out.println("DB server down.....");
	  }
	  System.out.println("msg:" + msg);
	  return msg;
	 }

}
