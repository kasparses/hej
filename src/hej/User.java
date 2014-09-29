package hej;

public class User {
	//	Initialisering af variable
    String Username;
    String Password;
    double Balance;
    String Type;
    String Name;
    String Gender;

    // get og set metoder af de forskellige objekter
	public String getType() {
		return Type;
	}


	public void setType(String Type) {
		this.Type = Type;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String Username) {
		this.Username = Username;
	}

	
	public String getPassword() {
		return Password;
	}


	public void setPassword(String Password) {
		this.Password = Password;
	}


	public double getBalance() {
		return Balance;
	}


	public void setBalance(double Balance) {
		this.Balance = Balance;
	}

	

	public String getName() {
		return Name;
	}


	public void setName(String Name) {
		this.Name = Name;
	}

	

	public String getGender() {
		return Gender;
	}


	public void setGender(String Gender) {
		this.Gender = Gender;
	}


	public User(String Username, String Password, double Balance,String Type, String Name, String Gender) {
        this.Username = Username;
        this.Password = Password;
        this.Balance = Balance;
        this.Type = Type;
        this.Name = Name;
        this.Gender = Gender;
    }

}
