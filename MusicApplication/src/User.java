
public class User {

	private String username;
    private String password;
    private Basket basket;
    private double balance;
    
    public User(String username, String password,double balance) {
        this.username = username;
        this.password = password;
        this.balance=balance;
        this.basket = new Basket();
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    


    
  
    public Basket getBasket() {
        return basket;
    }
    
    public void setBasket(Basket basket) {
        this.basket = basket;
    }
    
    @Override
    public String toString() {
        return "Username: " + username +  "Balance: " + balance;
    }

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
    
}
