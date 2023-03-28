import java.util.ArrayList;

public class Basket {

	 private ArrayList<Product> products;
	    private double total;
	    	
	    public Basket() {
	        products = new ArrayList<Product>();
	        total = 0;
	    }
	    
	    public void addProduct(Product product) {
	        products.add(product);
	        total += product.getPrice();
	    }
	    
	    public void removeProduct(Product product) {
	        products.remove(product);
	        total -= product.getPrice();
	    }
	    
	    public ArrayList<Product> getProducts() {
	        return products;
	    }
	    
	    public double getTotal() {
	        return total;
	    }
	    public void clear() {
	        products.clear();
	        total = 0;
	    }
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("Basket:\n");
	        for (Product p : products) {
	            sb.append(p.toString() + "\n");
	        }
	        sb.append("Total: $" + total);
	        return sb.toString();
	    }
	}
