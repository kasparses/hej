package hej;
import hej.MATM;
import hej.SATM;


public class RunATM {
	
	public static void main(String[] args) {		// main metoden
				login();							//	login metode bliver navngivet
	}
	
	
	public static void login(){						// login metode køres
		Database database = new Database();			//	Lader programmet hente fra databasen

		LoginMenu loginMenu = new LoginMenu(database);		//	Lader programmet hente fra loginmenu
		
		if(database.getCurrentUser().getType().equals("user")){		//	Hvis brugeren er user åbner MATM
		MATM matm = new MATM(database);						//	Henter MATM og kører
		matm.run();
	  	}else if (database.getCurrentUser().getType().equals("administrator")){		// Hvis brugeren er administrator åbner SATM
	  	SATM satm = new SATM(database);						// Henter SATM og kører
	  	satm.run();
	  	}
	
		  }
	
	
	}
