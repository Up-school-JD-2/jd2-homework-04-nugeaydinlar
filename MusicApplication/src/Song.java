
public class Song extends Product{
	
	 private int length;
	    private Album album;
	    
	    public Song(String title, String artist, double price,int length, Album album) {
	        super(title, artist, price);
	        this.length = length;
	        this.album = album;
	    }
	    
	    public int getLength() {
	        return length;
	    }
	    
	    public void setLength(int length) {
	        this.length = length;
	    }
	    
	    public Album getAlbum() {
	        return album;
	    }
	    
	    public void setAlbum(Album album) {
	        this.album = album;
	    }
	    
	    @Override
	    public String toString() {
	        return super.toString() + ", Length: " + length;
	    }

}
