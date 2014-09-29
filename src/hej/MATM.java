package hej;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MATM{
	Scanner input = new Scanner(System.in);		//	Scanneren indputtes, så brugeren kan skrive/indtaste i programmet
	Database database;							//	Klassen Database bliver omdøbbet til database og giver adgang til at hente fra klassen
		public MATM(Database database){
			this.database = database;
			
		}
		
		boolean Exit = false;					//	Initialiserer Exit som en boolean og som falsk
		private static double btcKroner;		//	Initialiserer btcKroner som en private static double
		private static double kronerBTC;		//	Initialiserer kronerBTC som en private static double
		
		public void run(){						//	Påbegyndelse af selve programmet under MATM
			JOptionPane.showMessageDialog(null, "\nWelcome " + database.getCurrentUser().Gender + " " + database.getCurrentUser().Name);

			while( !Exit ) {					//	Dette fortæller at while loopet skal køre så længe det ikke er Exit 
					
				boolean Exit2 = false;			//	Initialiserer Exit2 som en boolean og som falsk
				boolean Exit3 = false;			//	Initialiserer Exit3 som en boolean og som falsk
				boolean Exit4 = false;			//	Initialiserer Exit4 som en boolean og som falsk
				
				String menu = JOptionPane.showInputDialog("\nMain menu:\n1 - View my balance\n2 - Withdraw cash\n3 - Deposit funds"
						+ "\n4 - Transfer Bitcoins \n5 - Log off\n6 - Exit","Choose a number: ");
				try{							//	Programmet vil "prøve" at køre dette og senere fange alle de fejl som programmet har "prøvet" at køre
				
				int valg = Integer.parseInt(menu);
				if(valg > 6){					//	If sætning starter og siger at hvis valg er mere end 6 sker dette
					JOptionPane.showMessageDialog(null, "\nThe number cannot be chosen. "
							+ "\nYou are now at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
					
				}
				else if(valg == 0){				//	Else if sætning. Nedenstående bliver printet hvis valg = 0
					JOptionPane.showMessageDialog(null, "\nYou cannot choose 0. "
							+ "\nYou are now at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
				}
				
				switch(valg) {					//	Programmets cases til main menu
				case 1:
					
					btcKroner = database.getCurrentUser().Balance * database.getBtcRate();		//	Henter balancen fra databasen i bitcoins
					JOptionPane.showMessageDialog(null, "View my balance\n\nYou have:"
							+ "\n" +database.getCurrentUser().Balance+ " Bitcoin/-s,"
							+ "\nwhich is the same as:"
							+ "\n"+ btcKroner+ " DKK.");		//	Henter balancen i kroner
					String bla = JOptionPane.showInputDialog("\n\n1 - Main menu\n2 - Log off\n3 - Exit","Choose a number: ");

					
					int valg2 = Integer.parseInt(bla);
					if(valg2 > 3 | valg2 == 0){		// If sætning starter. Hvis valg2 er mere end 3 eller = 0 bliver nedenstående printet 
						JOptionPane.showMessageDialog(null, "\nThe number cannot be chosen."
								+ "\nYou are now at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
					}
					switch (valg2){					//	Cases til undermenu
					case 1: 
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "\nGoodbye. Logout succeeded!", "",JOptionPane.PLAIN_MESSAGE);
						Exit = true;				//	Afslutter while loppet
						RunATM.login();				//	Returnerer bruger til start
						break;
					case 3:
						JOptionPane.showMessageDialog(null, "\nGoodbye!", "",JOptionPane.PLAIN_MESSAGE);
						Exit = true;
						break;
					
					}
					break;
				case 2:
					while(!Exit2){					//	While loop kører hvis while ikke er Exit2
					
					String bla15 = JOptionPane.showInputDialog("Withdraw cash\n\n"
							+ "How many Bitcoins whould you"
							+ "\nlike to withdraw?: ","Choose a number: ");
					double valg3 = Double.parseDouble(bla15);
					
					if(valg3 > database.getCurrentUser().Balance){		// undermenu kører hvis valg3 er mere end sin balance
						
						String choise1 = JOptionPane.showInputDialog("The withdraw amount is too high.\n1 - Try again\n2 - Main menu"
								+ "\n3 - Log off\n4 - Exit","Choose a number: ");
						int valg5 = Integer.parseInt(choise1);
						if(valg5 > 4 || valg5 == 0){
							JOptionPane.showMessageDialog(null, "\nThe number cannot be chosen."
									+ "\nYou are now at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
							Exit2 = true;
							break;
						}
						switch (valg5){
						case 1:
							break;
						case 2: 
							Exit2 = true;
							break;
						case 3:
							JOptionPane.showMessageDialog(null, "\nGoodbye. Logout succeeded!", "",JOptionPane.PLAIN_MESSAGE);
							Exit2 = true;			//	Afslutter while loppet
							Exit = true;
							RunATM.login();			//	Returnerer bruger til start
							break;
						case 4:
							JOptionPane.showMessageDialog(null, "\nGoodbye!", "",JOptionPane.PLAIN_MESSAGE);
							Exit = true;
							Exit2 = true;
							break;
						}
					}else{
						database.getCurrentUser().Balance -= valg3;		//	Trækker hævebeløb fra balance
						btcKroner = valg3 * database.getBtcRate();			//	Henter bitcoins i kroner
						JOptionPane.showMessageDialog(null, "You have withdrawn:"
								+ "\n" +valg3+ " Bitcoin/-s,"
								+ "\nwhich is the same as:"
								+ "\n"+ btcKroner+ " DKK.");

												
		
						btcKroner = database.getCurrentUser().Balance * database.getBtcRate();
						JOptionPane.showMessageDialog(null, "Your current balance is now:"
								+ "\n" +database.getCurrentUser().Balance+ " Bitcoin/-s,"
										+ "\nwhich is the same as:"
										+ "\n"+ btcKroner+ " DKK.");

						
						
						String choise2 = JOptionPane.showInputDialog("\n1 - Main menu\n2 - Log off\n3 - Exit", "Choose a number: ");
						int valg4 = Integer.parseInt(choise2);
						if(valg4 > 3 | valg4 == 0){
							JOptionPane.showMessageDialog(null, "\nThe number cannot be chosen."
									+ "\nYou are now at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
							Exit2 = true;
							break;
						}
						switch (valg4){
						case 1: 
							Exit2 = true;
							break;
						case 2:
							JOptionPane.showMessageDialog(null, "\nGoodbye. Logout succeeded!", "",JOptionPane.PLAIN_MESSAGE);
							Exit2 = true;				//	Afslutter while loppet
							Exit = true;
							RunATM.login();				//	Returnerer bruger til start
							break;
						case 3:
							JOptionPane.showMessageDialog(null, "\nGoodbye!", "",JOptionPane.PLAIN_MESSAGE);
							Exit = true;
							Exit2 = true;
							break;
			}
		}
	}
					
					break;
				case 3:
					while(!Exit3){
						
						String choise3 = JOptionPane.showInputDialog("Deposit funds\n\nHow many DKK whould you"
								+ "\nlike to deposit?:", "Choose a number: ");
						double valg6 = Double.parseDouble(choise3);
						
						if(valg6 <= 0){
							
							String bla3 = JOptionPane.showInputDialog("You cannot deposit 0 or less\n1 - Try again\n2 - Main menu\n3 - Log off\n4 - Exit","Choose a number: ");

							
							int valg7 = Integer.parseInt(bla3);
							if(valg7 > 4 || valg7 == 0){
								JOptionPane.showMessageDialog(null, "\nThe number cannot be chosen."
										+ "\nYou are now at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
								Exit3 = true;
								break;
							}
							switch (valg7){
							case 1:
								break;
							case 2: 
								Exit3 = true;
								break;
							case 3:
								JOptionPane.showMessageDialog(null, "\nGoodbye. Logout succeeded!", "",JOptionPane.PLAIN_MESSAGE);
								Exit = true;				//	Afslutter while loppet
								Exit3 = true;
								RunATM.login();				//	Returnerer bruger til start
								break;
							case 4:
								JOptionPane.showMessageDialog(null, "\nGoodbye!", "",JOptionPane.PLAIN_MESSAGE);
								Exit = true;
								Exit3 = true;
								break;
							}
						}else{
							kronerBTC = valg6 / database.getBtcRate();		//	Henter indbetalingsbeløb i kroner
							JOptionPane.showMessageDialog(null, "You have deposited:"
									+ "\n" +valg6+ " DKK,"
									+ "\nwhich is the same as:"
									+ "\n"+ kronerBTC+ " Bitcoin/-s.");

							database.getCurrentUser().Balance += kronerBTC;		//	Lægger pengene ind pÂ nuværende balance
							btcKroner = database.getCurrentUser().Balance * database.getBtcRate();
							JOptionPane.showMessageDialog(null, "Your current balance is now:"
									+ "\n" +database.getCurrentUser().Balance+ " Bitcoin/-s,"
											+ "\nwhich is the same as:"
											+ "\n"+ btcKroner+ " DKK.");
							//	Henter indbetalingsbeløb i bitcoins
							//	Henter balance i BTC

							
						
							String choise4 = JOptionPane.showInputDialog("\n1 - Main menu\n2 - Log off\n3 - Exit","Choose a number: ");
							int valg8 = Integer.parseInt(choise4);
							if(valg8 > 3 | valg8 == 0){
								JOptionPane.showMessageDialog(null, "\nThe number cannot be chosen. "
										+ "\nYou are now at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
								Exit3 = true;
								break;
							}
							switch (valg8){
							case 1: 
								Exit3 = true;
								break;
							case 2:
								JOptionPane.showMessageDialog(null, "\nGoodbye. Logout succeeded!", "",JOptionPane.PLAIN_MESSAGE);
								Exit = true;				//	Afslutter while loppet
								Exit3 = true;
								RunATM.login();				//	Returnerer bruger til start
								break;
							case 3:
								JOptionPane.showMessageDialog(null, "\nGoodbye!", "",JOptionPane.PLAIN_MESSAGE);
								Exit = true;
								Exit3 = true;
								break;
			}
		}
	}
					
					break;
					
				case 4:										//	Overførsel af penge til konto
					while(!Exit4){
					String name =
					JOptionPane.showInputDialog("Transfer Bitcoins\n\n"
							+ "Who would you like to"
							+ "\ntransfer to?", "Enter the persons full name (Big initials):");
					//	Lader brugeren skrive Hvem han vil overføre penge til
					
					if(database.TransferUser(name)){		//	Henter muligt match fra database
					database.setTransferUser(database.getTransfer(name));
					
					String choise5 = JOptionPane.showInputDialog("How many Bitcoins would you"
							+ "\nlike to tranfer "
							+ "\nto "+ database.getTransferUser().Name +"?", "Choose a number: ");
					//	Lader brugeren skrive hvilket beløb han vil overføre
					double valg9 = Double.parseDouble(choise5);
					
					if(valg9 <= 0 || valg9 > database.getCurrentUser().Balance){	//	Hvis transferbeløb er 0 eller mindre eller større en CurrentUser balance
						
						String choise6 = JOptionPane.showInputDialog("You cannot transfer 0 or less"
								+ "\nor more than you have"
								+ "\non your balance.\n1 - Try again\n2 - Main menu\n3 - Log off\n4 - Exit","Choose a number: ");
						int valg10 = Integer.parseInt(choise6);
						
						if(valg10 > 4 || valg10 == 0){
							
							JOptionPane.showMessageDialog(null, "\nThe number cannot be chosen."
									+ "\nYou are now at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
							Exit4 = true;
							break;
						}
							switch (valg10){
							case 1:
								break;
							case 2: 
								Exit4 = true;
								break;
							case 3:
								JOptionPane.showMessageDialog(null, "\nGoodbye. Logout succeeded!", "",JOptionPane.PLAIN_MESSAGE);
								Exit = true;				//	Afslutter while loppet
								Exit4 = true;
								RunATM.login();				//	Returnerer bruger til start
								break;
							case 4:
								JOptionPane.showMessageDialog(null, "\nGoodbye!", "",JOptionPane.PLAIN_MESSAGE);
								Exit = true;
								Exit4 = true;
								break;
							}
											
						}else{
							
							btcKroner = valg9 * database.getBtcRate();		//	Henter transferbeløb i BTC
							JOptionPane.showMessageDialog(null, "You have transfered:"
									+ "\n" +valg9+ " Bitcoin/-s,"
									+ "\nwhich is the same as:"
									+ "\n"+ btcKroner+ " DKK."
											+ "\nto "+ database.getTransferUser().Name +"?");	

							
							database.getCurrentUser().Balance -= valg9;		// Henter balance og trækker fra beløb
							
							btcKroner = database.getCurrentUser().Balance * database.getBtcRate();		//	Henter balance i kroner
							JOptionPane.showMessageDialog(null, "Your current balance is now:"
									+ "\n" +database.getCurrentUser().Balance+ " Bitcoin/-s,"
											+ "\nwhich is the same as:"
											+ "\n"+ btcKroner+ " DKK.");

							
							database.getTransferUser().Balance += valg9;
							
							
							
							
							String choise7 = JOptionPane.showInputDialog("\n1 - Main menu\n2 - Log off\n3 - Exit","Choose a number: ");
							int valg11 = Integer.parseInt(choise7);
							
							if(valg11 > 3 | valg11 == 0){
								JOptionPane.showMessageDialog(null, "\nThe number cannot be chosen."
										+ "\nYou are now at the main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
								Exit4 = true;
								break;
							}
							switch (valg11){
							case 1: 
								Exit4 = true;
								break;
							case 2:
								JOptionPane.showMessageDialog(null, "\nGoodbye. Logout succeeded!", "",JOptionPane.PLAIN_MESSAGE);
								Exit = true;				//	Afslutter while loppet
								Exit4 = true;
								RunATM.login();				//	Returnerer bruger til start
								break;		
							case 3:
								JOptionPane.showMessageDialog(null, "\nGoodbye!", "",JOptionPane.PLAIN_MESSAGE);
								Exit = true;
								Exit4 = true;
								break;
			}
		}
	
					}else{
						
						String choise8 = JOptionPane.showInputDialog("\nThe user dosn't exist. \n1 - Try again\n2 - Main menu"
								+ "\n3 - Log off","Choose a number: ");
						int valg12 = Integer.parseInt(choise8);
						if(valg12 > 3 | valg12 == 0){
							JOptionPane.showMessageDialog(null, "\nThe number cannot be chosen."
									+ "\nYou are now at the nmain menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
							Exit4 = true;
							break;
						}
						switch (valg12){
						case 1:
							break;
						case 2: 
							Exit4 = true;
							break;
						case 3: 
							JOptionPane.showMessageDialog(null, "\nGoodbye. Logout succeeded!", "",JOptionPane.PLAIN_MESSAGE);
							Exit4 = true;
							Exit = true;
							RunATM.login();
							break;
				}
			}				   
		}
					
					break;
				case 5:
					JOptionPane.showMessageDialog(null, "\nGoodbye. Logout succeeded!", "",JOptionPane.PLAIN_MESSAGE);
					Exit = true;
					RunATM.login();
					break;
				case 6:
					JOptionPane.showMessageDialog(null, "\nGoodbye!", "",JOptionPane.PLAIN_MESSAGE);
					Exit = true;
					break;
		}			
	}		//	slutter try
				catch(Exception e){					//	Fanger alle fejl (exceptions)
					JOptionPane.showMessageDialog(null, "\nYou cannot type letters/signs"
							+ "\nor too high numbers."
							+ "\nYou are now back at "
							+ "\nthe main menu.", "Error message",JOptionPane.PLAIN_MESSAGE);
}
}
}
}
