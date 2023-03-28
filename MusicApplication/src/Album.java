import java.util.ArrayList;

public class Album extends Product{


	    private int releaseYear;
	    private ArrayList<Song> songs;
	    
	    public Album(String title, String artist, double price, int releaseYear, ArrayList<Song> songs) {
	        super(title, artist, price);
	        this.releaseYear = releaseYear;
	        this.songs = songs;
	    }
	    
	    public int getReleaseYear() {
	        return releaseYear;
	    }
	    
	    public void setReleaseYear(int releaseYear) {
	        this.releaseYear = releaseYear;
	    }
	    
	    public ArrayList<Song> getSongs() {
	        return songs;
	    }
	    
	    public void setSongs(ArrayList<Song> songs) {
	        this.songs = songs;
	    }
	    
	    @Override
	    public String toString() {
	        return super.toString() + ", Release Year: " + releaseYear + ", Songs: " + songs.size();
	    }
	}
