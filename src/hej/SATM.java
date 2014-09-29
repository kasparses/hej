package hej;
import java.util.Scanner;


import javax.swing.JOptionPane;

public class SATM{
	Scanner input = new Scanner(System.in);
	Database database;					//	Henter data fra databasen
		public SATM(Database database){
			this.database = database;
		}
		
		
		boolean Exit = false;			//	Initialiserer Exit som falsk
		
		public void run(){
		
		boolean emailval = true;
		boolean inputemail = false;
		
		boolean passwordval = true;
		boolean inputpassword = false;
		String regexmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String regexpassword = "^[a-zA-Z0-9]*.{6,20}$";
		
			
			JOptionPane.showMessageDialog(null, "\nWelcome " + database.getCurrentUser().Gender + " " + database.getCurrentUser().Name);

			
			while( !Exit ) {			//	While loop kører så længe while ikke er Exit
				
		
			
			try{						//	"Prøver" koderne i try-klammen og fanger eventuelle fejl i catch længere nede
			
			String choise9 = JOptionPane.showInputDialog("\nMain menu:\n1 - Establish a new account\n2 - Enter the current exchange rate"
					+ "\n3 - Log off\n4 - Exit","Choose a number: ");
			int valg2 = Integer.parseInt(choise9);
			if(valg2 > 4){				//	Hvis valg2 fra brugeren er mere end 4 kører følgende
				JOptionPane.showMessageDialog(null, "\nThe number is too high."
						+ "\nYou are now at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
			}
			else if(valg2 == 0){		//	Hvis valg2 fra brugeren er = 0 kører følgende
				JOptionPane.showMessageDialog(null, "\nYou cannot choose 0."
						+ "\nYou are now at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
			}
			
			
			switch(valg2) {				//	Cases til main menu
			case 1:
				String Username =
				JOptionPane.showInputDialog("Please enter the new users e-mail:");
				if (Username.matches(regexmail)) { 
					emailval = false;
				    inputemail = true;
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "The e-mail is not valid."
				    			+ "\nYou are now back at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
				    	
				    break;				    	
				    }
				if (inputemail == true)
				   {
					do{
				String Password =
				JOptionPane.showInputDialog("Please enter the new users password:"
								+ "\n(Must be at least 6 characters long)");
				if (Password.matches(regexpassword)) { 
				       passwordval = false;
				       inputpassword = true;
				      }
				else
				{
					JOptionPane.showMessageDialog(null, "The password is not valid."
							+ "\nYou are now back at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
					
					break;
				}
					
				if (inputpassword == true)
			     {
				String Balance1 =
						JOptionPane.showInputDialog("Please enter the new users balance:");
				double Balance = Double.parseDouble(Balance1);
				
				String Type =
						JOptionPane.showInputDialog("Please enter the new users type:"
								+ "\n(Enter either user or administrator)");
								
				String Name =
						JOptionPane.showInputDialog("Please enter the new users full name: (Big initials)");
				
				String Gender =
						JOptionPane.showInputDialog("Please enter the new users gender:"
								+ "\n(Mr./Ms.");
			     
		        User newUser = new User(Username, Password, Balance, Type, Name, Gender);		//Opretter en ny bruger		
		        database.getUsers().add(newUser);		//	Den nye bruger bliver gemt i array
			     
			     }
					}
				while(passwordval);
					
					
					while(emailval);
					break;
			}
				   
				
			
		
			case 2:
				String choise10 = JOptionPane.showInputDialog("\nThe current exchange rate is: \n"
						+ ""+ database.getBtcRate()+ "\nPlease enter a new exchange rate: ");		//	Admin indsætter kursen som tal/decimaltal
				database.setBtcRate(Double.parseDouble(choise10));
				
				JOptionPane.showMessageDialog(null, "\nThe exchange rate has been updated."
						+ "\nThe exchange rate is now"
						+ "\n"+ database.getBtcRate()+".");
				break;
				
				
				
			case 3:
				JOptionPane.showMessageDialog(null, "\nGoodbye. Logout succeeded!", "",JOptionPane.PLAIN_MESSAGE);
				Exit = true;
				RunATM.login();
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "\nGoodbye!", "",JOptionPane.PLAIN_MESSAGE);
				Exit = true;
				break;
			}
			
			
						
			//	try afsluttes og catch prøver at fange de fejl som kan være fra brugerens side
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "\nYou cannot type letters/signs"
						+ "\nor too high numbers."
						+ "\nYou are now back at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
			}
				
			}
		
			
			
			
					
	}		
	
}
