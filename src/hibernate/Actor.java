package hibernate;

public class Actor {

    private String fname;
    private String lname;
    private String mname;
    private int gender;
    private int number;
    private int idactors;
    private String[] aka_names;

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

    public String[] getAka_names() {
	return aka_names;
    }

    public void setAka_names(String[] aka_names) {
	this.aka_names = aka_names;
    }

}
