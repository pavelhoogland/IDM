package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate.Actor;

public class Application {
    public static void main(String[] args) {
	Actor arnold = getActor("Arnold", "Schwarzenegger");
	System.out.println("" + arnold.getFname());
    }

    public static Actor getActor(String fname, String lname) {
	Actor result = null;

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("IMDB");

	EntityManager entitymanager = emfactory.createEntityManager();
	entitymanager.getTransaction().begin();

	Actor newActor = new Actor();
	newActor.setFname("Arnold");

	newActor.setLname("Schwarzenegger");
	entitymanager.persist(newActor);
	entitymanager.getTransaction().commit();

	Query q = entitymanager
		.createQuery("SELECT * FROM actors WHERE fname = '" + fname + "' AND lname = '" + lname + "';");
	result = (Actor) q.getSingleResult();
	entitymanager.close();
	emfactory.close();
	return result;
    }

    public static Movie getMovie(String title) {
	Movie result = null;

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("IMDB");

	EntityManager entitymanager = emfactory.createEntityManager();
	entitymanager.getTransaction().begin();

	Movie newMovie = new Movie();
	newMovie.setTitle("The Terminator");

	entitymanager.persist(newMovie);
	entitymanager.getTransaction().commit();

	Query q = entitymanager.createQuery("SELECT * FROM movies WHERE title = '" + title + "';");
	result = (Movie) q.getSingleResult();
	entitymanager.close();
	emfactory.close();
	return result;
    }

    public static void printFilmography(String fname, String lname) {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("IMDB");

	EntityManager entitymanager = emfactory.createEntityManager();

	Query q = entitymanager.createQuery("SELECT year, title FROM movies WHERE movies.idmovies IN "
		+ "(SELECT movies.idmovies FROM movies JOIN acted_in ON acted_in.idmovies = movies.idmovies "
		+ "JOIN actors ON actors.idactors = acted_in.idactors WHERE actors.fname = '" + fname
		+ "' AND actors.lname = '" + lname + "' ) ;");
	List result = q.getResultList();

	for (int i = 0; i < result.size(); i++) {
	    System.out.println(result.get(i));
	}

	entitymanager.close();
	emfactory.close();
    }

    public static void printCast(String title) {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("IMDB");

	EntityManager entitymanager = emfactory.createEntityManager();

	Query q = entitymanager.createQuery(
		"SELECT fname,lname, character FROM actors " + "JOIN acted_in ON acted_in.idactors = actors.idactors "
			+ "JOIN movies ON acted_in.idmovies = movies.idmovies WHERE movies.title= '" + title + "';");
	List result = q.getResultList();

	for (int i = 0; i < result.size(); i++) {
	    System.out.println(result.get(i));
	}

	entitymanager.close();
	emfactory.close();
    }
}
