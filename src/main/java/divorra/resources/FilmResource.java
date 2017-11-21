package divorra.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import divorra.core.Film;
import divorra.db.FilmDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/films")
@Produces(MediaType.APPLICATION_JSON)
public class FilmResource {
	
	private final FilmDAO filmDAO;
	
	public FilmResource(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}
	
	@POST
	@UnitOfWork
	public Film createFilm(Film film) {
		return filmDAO.create(film);
	}
	
	
	@GET
	@UnitOfWork
	public List<Film> listFilms() {
		return filmDAO.findAll();
	}
	
	@Path("/{filmId}")
	@GET
	@UnitOfWork
	public Film getFilm(@PathParam("filmId") LongParam filmId) {
		return filmDAO.findById(filmId.get()).orElseThrow(() -> new NotFoundException("No such film."));
	}
	
	
}
