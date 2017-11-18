package divorra.db;

import java.util.List;

import org.hibernate.SessionFactory;

import divorra.core.Film;
import io.dropwizard.hibernate.AbstractDAO;

public class FilmDAO extends AbstractDAO<Film> {

	public FilmDAO(SessionFactory factory) {
		super(factory);
	}
	
	public List<Film> findAll() {
		return list(namedQuery("findAll"));
	}

}
