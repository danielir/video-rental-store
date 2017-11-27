package divorra.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;

import divorra.core.Film;
import io.dropwizard.hibernate.AbstractDAO;

public class FilmDAO extends AbstractDAO<Film> {

	public FilmDAO(SessionFactory factory) {
		super(factory);
	}
	
	public Film create(Film film) {
		return persist(film);
	}
	
	public List<Film> findAll() {
		return list(namedQuery("findAll"));
	}
	
	public Optional<Film> findById(Long id) {
        return Optional.ofNullable(get(id));
    }	
	
	
}
