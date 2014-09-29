package hej;

import javax.swing.JOptionPane;


public class LoginMenu {
public LoginMenu(Database database){
	
	boolean authUser = false;	//	Initialiserer authUser som falsk
	while(!authUser){			//	While loop kører så længe brugeren ikke har adgang
	String username = JOptionPane.showInputDialog("Welcome to Bitcoin CBS\n","Enter your username: ");
	

	
	String password = JOptionPane.showInputDialog("Enter your password: ","Enter your password: ");
	if(database.authenticateUser(username, password)){		//	Hvis brugeren får adgang er authUser sandt og henter bruger fra database
		authUser= true;
		
		database.setCurrentUser(database.getUser(username));
		
	}else{
		JOptionPane.showMessageDialog(null, "\nUsername or password is wrong.\nPlease try again.\n", "Error message",JOptionPane.PLAIN_MESSAGE);

	}	
   }
  }
 }
