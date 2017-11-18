package divorra.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import divorra.core.Film;
import divorra.db.FilmDAO;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/films")
@Produces(MediaType.APPLICATION_JSON)
public class FilmResource {
	
	private final FilmDAO filmDAO;
	
	public FilmResource(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}
	
	@GET
	@UnitOfWork
	public List<Film> listFilms() {
		return filmDAO.findAll();
	}
	
}
