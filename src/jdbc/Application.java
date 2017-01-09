package jdbc;

import java.sql.*;

public class Application {

    private Connection connection = null;

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
	    Connection db = DriverManager.getConnection(url, username, password);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public Actor getActor(String fname, String lname) {
	Actor result = null;
	Statement stmt = null;
	try {
	    stmt = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

	    ResultSet rs = stmt.executeQuery("SELECT * FROM actors WHERE fname=" + fname + "AND lname=" + lname);

	    while (rs.next()) {
		result = new Actor(rs.getString("fname"), rs.getString("lname"), rs.getString("mname"),
			rs.getInt("gender"), rs.getInt("number"), rs.getInt("idactors"), rs.getArray("aka_names"));
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return result;
    }

}
