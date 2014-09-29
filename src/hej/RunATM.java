package hej;
import hej.MATM;
import hej.SATM;


public class RunATM {
	
	public static void main(String[] args) {		// main metoden
				login();							//	login metode bliver navngivet
	}
	
	
	public static void login(){						// login metode k�res
		Database database = new Database();			//	Lader programmet hente fra databasen

		LoginMenu loginMenu = new LoginMenu(database);		//	Lader programmet hente fra loginmenu
		
		if(database.getCurrentUser().getType().equals("user")){		//	Hvis brugeren er user �bner MATM
		MATM matm = new MATM(database);						//	Henter MATM og k�rer
		matm.run();
	  	}else if (database.getCurrentUser().getType().equals("administrator")){		// Hvis brugeren er administrator �bner SATM
	  	SATM satm = new SATM(database);						// Henter SATM og k�rer
	  	satm.run();
	  	}
	
		  }
	
	
	}
