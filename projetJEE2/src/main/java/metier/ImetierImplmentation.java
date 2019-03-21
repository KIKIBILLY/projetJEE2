package metier;


import dao.BaseDao;
import dao.BaseDaoImp;
import bean.User;

public class ImetierImplmentation implements Imetier {

 private BaseDao loginDao = new BaseDaoImp();

 @Override
 public boolean login(String username, String password) {
  return loginDao.login(username, password);
 }

 
 
 @Override
 public String register(User utilisateur)
 {
  return loginDao.register(utilisateur);
 }

 
}