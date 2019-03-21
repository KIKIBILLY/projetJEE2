package metier;


import bean.User;

public interface Imetier {
 
	public boolean login(String username, String password);
	public String register(User user);
 
}
