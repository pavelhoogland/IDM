package jdbc;

import java.sql.*;

public class Application {

    private static Connection connection = null;

    public static void main(String[] args) {
	try {
	    Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	String url = "jdbc:postgresql://localhost:5432/IMDB";
	String username = "postgres";
	String password = "password";

	try {
	    connection = DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	Actor Harrison = getActor("Harrison", "Ford");
	System.out.println("Get Actor on fname= 'Harrison' and lname= 'Ford' :\n" + Harrison.getFname() + "\n");

	Movie Terminator = getMovie("The Terminator");
	System.out.println("Get Movie on title= 'The Terminator' :\n" + Terminator.getTitle() + "\n");

	System.out.println("Filmography on 'Harrison' 'Ford'");
	printFilmography("Harrison", "Ford");
	System.out.println();

	System.out.println("Cast of 'The Terminator'");
	printCast("The Terminator");
	try {
	    connection.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public static Actor getActor(String fname, String lname) {
	Actor result = null;
	PreparedStatement stmt = null;
	try {
	    stmt = connection.prepareStatement("SELECT * FROM actors WHERE fname = ? AND lname = ?;",
		    ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
	    stmt.setString(1, fname);
	    stmt.setString(2, lname);

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		result = new Actor(rs.getString("fname"), rs.getString("lname"), rs.getString("mname"),
			rs.getInt("gender"), rs.getInt("number"), rs.getInt("idactors"));
		// break;
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return result;
    }

    public static Movie getMovie(String title) {
	Movie result = null;
	PreparedStatement stmt = null;
	try {
	    stmt = connection.prepareStatement("SELECT * FROM movies WHERE title =?;", ResultSet.TYPE_FORWARD_ONLY,
		    ResultSet.CONCUR_UPDATABLE);

	    stmt.setString(1, title);

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		result = new Movie(rs.getString("title"), rs.getInt("year"), rs.getInt("number"), rs.getInt("type"),
			rs.getString("location"), rs.getString("language"), rs.getInt("idmovies"));
		// break;
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return result;
    }

    public static void printFilmography(String fname, String lname) {
	PreparedStatement stmt = null;

	try {
	    stmt = connection.prepareStatement("SELECT year, title FROM movies WHERE movies.idmovies IN "
		    + "(SELECT movies.idmovies FROM movies JOIN acted_in ON acted_in.idmovies = movies.idmovies "
		    + "JOIN actors ON actors.idactors = acted_in.idactors WHERE actors.fname = ? AND actors.lname = ? ) ;");

	    stmt.setString(1, fname);
	    stmt.setString(2, lname);

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		System.out.println("(" + rs.getString("year") + ") " + rs.getString("title"));
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public static void printCast(String title) {
	PreparedStatement stmt = null;

	try {
	    stmt = connection.prepareStatement("SELECT fname,lname, character FROM actors "
		    + "JOIN acted_in ON acted_in.idactors = actors.idactors "
		    + "JOIN movies ON acted_in.idmovies = movies.idmovies WHERE movies.title= ?;");
	    stmt.setString(1, title);

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		System.out.println(
			"(" + rs.getString("character") + ")" + rs.getString("fname") + " " + rs.getString("lname"));

	    }

	} catch (SQLException e) {

	    e.printStackTrace();
	}
    }

}
