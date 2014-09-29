package hej;
import User;

import java.util.ArrayList;

public class Database {
	private static ArrayList<User> users = new ArrayList();			//	Laver en arrayliste som hedder users
	private User currentUser;		//	Omdøbber variablen
	private User transferUser;		//	Omdøbber variablen
	private static Double btcRate = 5656.20;
	public Database(){				//	Arraylisten
		users.add(new User("mani13ar@student.cbs.dk", "abcd1234", 1.0,"user", "Mathias Okholm Nielsen", "Mr."));
	    users.add(new User("kabj13ab@student.cbs.dk", "4321dcba", 1.0,"user", "Kasper Holm Bjerring", "Mr."));
	    users.add(new User("thj13aj@student.cbs.dk", "dcba1234", 1.0,"user", "Thomas Kirk", "Mr."));
	    users.add(new User("togr13ab@student.cbs.dk", "5678abcd", 1.0,"user", "Tobias Pavar Gregersen", "Mr."));
	    users.add(new User("88888888", "1234abcd", 1.0,"administrator", "Administrator", "Mr."));
	    
	}
	
	public boolean authenticateUser(String username, String password){
		User user = getUser(username);
		if(user!=null && user.getPassword().equals(password)){
			return true;
		}	
		return false;
	}
	
	public User getUser(String username){
		for(User user:users){
			if(user.getUsername().equals(username)){
				return user;
			}
		}
		return null;

}
