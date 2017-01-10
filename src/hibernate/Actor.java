package hibernate;

import java.sql.Array;

public class Actor {

    private String fname;
    private String lname;
    private String mname;
    private int gender;
    private int number;
    private int idactors;
    private Array aka_names;

    public Actor(String fname, String lname, String mname, int gender, int number, int idactors) {
	this.fname = fname;
	this.lname = lname;
	this.mname = mname;
	this.gender = gender;
	this.number = number;
	this.idactors = idactors;
    }

    public Actor(String fname, String lname, String mname, int gender, int number, int idactors, Array aka_names) {
	this.fname = fname;
	this.lname = lname;
	this.mname = mname;
	this.gender = gender;
	this.number = number;
	this.idactors = idactors;
	this.aka_names = aka_names;
    }

    public Actor() {

    }

    public String getFname() {
	return fname;
    }

    public void setFname(String fname) {
	this.fname = fname;
    }

    public String getLname() {
	return lname;
    }

    public void setLname(String lname) {
	this.lname = lname;
    }

    public String getMname() {
	return mname;
    }

    public void setMname(String mname) {
	this.mname = mname;
    }

    public int getGender() {
	return gender;
    }

    public void setGender(int gender) {
	this.gender = gender;
    }

    public int getNumber() {
	return number;
    }

    public void setNumber(int number) {
	this.number = number;
    }

    public int getIdactors() {
	return idactors;
    }

    public void setIdactors(int idactors) {
	this.idactors = idactors;
    }

    public Array getAka_names() {
	return aka_names;
    }

    public void setAka_names(Array aka_names) {
	this.aka_names = aka_names;
    }

}
