import java.util.ArrayList;
import java.util.Scanner;


public class Test {
	 private static Scanner scanner = new Scanner(System.in);
	    private static User currentUser;
	    private static Basket basket = new Basket();
	    private static ArrayList<User> users = new ArrayList<User>();
	    private static ArrayList<Product> products = new ArrayList<Product>();
	    
	    public static void main(String[] args) {
	    	 
	    	Song song1 = new Song("Try Me", "The Weeknd", 1.99, 180, null);
	        Song song2 = new Song("Song 2", "Artist 2", 2.49, 240, null);
	        Song song3 = new Song("Song 3", "Artist 1", 0.99, 120, null);
	  
	    	
	        Album album = new Album("Currents", "Tame Impala", 19.99, 1982, new ArrayList<>());
	        Song song4 = new Song("Let It Happen'", "Tame Impala", 1.29, 386, album);
	        Song song5 = new Song("Nangs", "Tame Impala", 1.29, 258, album);
	        album.getSongs().add(song4);
	        album.getSongs().add(song5);
	        
	        products.add(song1);
	        products.add(song2);
	        products.add(song3);
	        products.add(song4);
	        products.add(song5);
	        products.add(album);
		
	    	
	    	 boolean exit = false;
	         while (!exit) {
	             System.out.println("***** Music Store *****");
	             System.out.println("Please login to the system to see the options.");
	             
	             if (currentUser == null) {
	                 System.out.println("1. Create an account");
	                 System.out.println("2. Log in");
	             } else {
	                 System.out.println("1. Search products");
	                 System.out.println("2. Add product to  basket");
	                 System.out.println("3. Checkout");
	                 System.out.println("4. View Basket");
	                 System.out.println("5. Log out");
	             }
	             System.out.println("0. Exit");
	             System.out.print("Please select an option: ");
	             
	             
	             
	             
	             int option = scanner.nextInt();
	             scanner.nextLine();
	             switch (option) {
	                 case 0:
	                     exit = true;
	                     break;
	                 case 1:
	                     if (currentUser == null) {
	                    	 createAccount();
	                     } else {
	                    	 searchProduct();
	                     }
	                     break;
	                 case 2:
	                     if (currentUser == null) {
	                    	 login();
	                     } else {
	                         addToBasket();
	                         break;
	                         
	                     }
	                 case 3:
	                     if (currentUser != null) {
	                    
	                    	 checkout(currentUser);
	                    	 break;
	                     }
	                     break;
	                 case 4:
	                     if (currentUser != null) {
	                         viewBasket(currentUser);
	                         break;
	                     }
	                     break;
	                 case 5:
	                     if (currentUser != null) {
	                         currentUser = null;
	                         basket = new Basket();
	                     }
	                     break;
	                 default:
	                     System.out.println("Invalid option. Please try again.");
	                     break;
	             }
	             System.out.println();
	         }
	    }
	    public static void createAccount() {
	        System.out.println("Please enter your name:");
	        String name = scanner.nextLine();
	        System.out.println("Please enter your password:");
	        String password = scanner.nextLine();
	        System.out.println("Please enter your balance:");
	        double balance = scanner.nextDouble();
	        scanner.nextLine();
	        User user = new User(name, password,balance);
	        users.add(user);
	        System.out.println("Account created successfully!");
	    }
	    
	    
	    public static void login() {
	        System.out.println("Please enter your username:");
	        String username = scanner.nextLine();
	        System.out.println("Please enter your password:");
	        String password = scanner.nextLine();
	        for (User user : users) {
	            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
	                currentUser = user;
	                System.out.println("Login successful!");
	                return;
	            }
	        }
	        System.out.println("Incorrect email or password.");
	    }
	    public static void searchProduct() {
	        System.out.println("Please enter the name of the product:");
	        String productName = scanner.nextLine();
	        for (Product product : products) {
	            if (product.getTitle().equalsIgnoreCase(productName)) {
	                System.out.println("Product found!");
	                System.out.println(product);
	                return;
	            }
	        }
	        System.out.println("Product not found.");
	    }
	    public static void addToBasket() {
	        System.out.println(" ");	 System.out.println(" ");
	        for (Product product : products) {
	                System.out.println(product.getTitle()+" "+ product.getPrice()+"TL");
	            }
	        System.out.println(" ");	 System.out.println(" ");
	        
	        System.out.println("Please enter the name of the product to add to your basket:");
	        String productName = scanner.nextLine();
	        for (Product product : products) {
	            if (product.getTitle().equalsIgnoreCase(productName)) {
	                if (product instanceof Album) {
	                    System.out.println("The album contains the following songs:");
	                    for (Song song : ((Album) product).getSongs()) {
	                        System.out.println(song.getTitle());
	                    }
	                    System.out.println("Enter the name of the song you would like to add to your basket:");
	                    String songName = scanner.nextLine();
	                    for (Song song : ((Album) product).getSongs()) {
	                        if (song.getTitle().equalsIgnoreCase(songName)) {
	                            basket.addProduct(song);
	                            System.out.println("Song added to basket successfully!");
	                            return;
	                        }
	                    }
	                } else if (product instanceof Song) {
	                    basket.addProduct(product);
	                    System.out.println("Product added to basket successfully!");
	                    return;
	                }
	            }
	        }
	        System.out.println("Product not found.");
	    }

	    public static void checkout(User user) {
	        if (basket.getProducts().size() == 0) {
	            System.out.println("Basket is empty. Please add products to the basket first.");
	            return;
	        }
	        double totalPrice = basket.getTotal();
	        if (user.getBalance() < totalPrice) {
	            System.out.println("Insufficient balance. Please add funds to your account.");
	            return;
	        }
	        user.setBalance(user.getBalance() - totalPrice);
	        basket.clear();
	        System.out.println("Checkout successful. Your new balance is " + user.getBalance());
	        System.out.println(" ");	 System.out.println(" ");
	    }
	    public static void viewBasket(User user) {
	    	  System.out.println(" ");	 System.out.println(" ");
	        System.out.println("***** Basket *****");
	        for (Product product : basket.getProducts()) {
	            System.out.println(product.getTitle() + " - " + product.getPrice() + " TL");
	        }
	        System.out.println("Total Price: " + basket.getTotal() + " TL");
	        System.out.println(" ");	 System.out.println(" ");
	    }

	}

