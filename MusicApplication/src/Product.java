
public class Product {

	    private String title;
	    private String artist;
	    private double price;
	    
	 
	    public Product(String title, String artist, double price) {
	        this.title = title;
	        this.artist = artist;
	        this.price = price;

	    }
	    public String getTitle() {
	        return title;
	    }
	    
	    public void setTitle(String title) {
	        this.title = title;
	    }
	    
	    public String getArtist() {
	        return artist;
	    }
	    
	    public void setArtist(String artist) {
	        this.artist = artist;
	    }
	    
	    public double getPrice() {
	        return price;
	    }
	    
	    public void setPrice(double price) {
	        this.price = price;
	    }
	    
	    
	    @Override
	    public String toString() {
	        return "Title: " + title + ", Artist: " + artist + ", Price: $" + price;
	    }
	}
