package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Movie {

    private String title;
    private int year;
    private int number;
    private int type;
    private String location;
    private String language;
    @Id
    private int idmovies;
    private String[] aka_titles;

    public Movie(String title, int year, int number, int type, String location, String language, int idmovies) {
	this.title = title;
	this.year = year;
	this.number = number;
	this.type = type;
	this.location = location;
	this.language = language;
	this.idmovies = idmovies;
    }

    public Movie(String title, int year, int number, int type, String location, String language, int idmovies,
	    String[] aka_titles) {
	this.title = title;
	this.year = year;
	this.number = number;
	this.type = type;
	this.location = location;
	this.language = language;
	this.idmovies = idmovies;
	this.aka_titles = aka_titles;
    }

    public Movie() {
	// TODO Auto-generated constructor stub
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getTitle() {
	return title;
    }

    public void setYear(int year) {
	this.year = year;
    }

    public int getYear() {
	return year;
    }

    public void setNumber(int number) {
	this.number = number;
    }

    public int getNumber() {
	return number;
    }

    public void setType(int type) {
	this.type = type;
    }

    public int getType() {
	return type;
    }

    public void setLocation(String location) {
	this.location = location;
    }

    public String getLocation() {
	return location;
    }

    public void setLanguage(String language) {
	this.language = language;
    }

    public String getLanguage() {
	return language;
    }

    public int getIdmovies() {
	return idmovies;
    }

    public void setIdmovies(int idmovies) {
	this.idmovies = idmovies;
    }

    public String[] getAka_titles() {
	return aka_titles;
    }

    public void setAka_titles(String[] aka_titles) {
	this.aka_titles = aka_titles;
    }

}
