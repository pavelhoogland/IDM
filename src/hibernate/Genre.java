package hibernate;

public class Genre {

    private String genre;
    private int idgenres;

    public void setGenre(String genre) {
	this.genre = genre;
    }

    public Genre(String genre, int idgenres) {
	this.genre = genre;
	this.idgenres = idgenres;
    }

    public String getGenre() {
	return genre;
    }

    public int getIdgenres() {
	return idgenres;
    }

    public void setIdgenres(int idgenres) {
	this.idgenres = idgenres;
    }
}
