package divorra.core.finance;

import java.util.List;
import java.util.Optional;

import divorra.core.Film;
import divorra.core.FilmRentRequest;
import divorra.core.RentRequest;
import divorra.db.FilmDAO;

public class RentPriceCalculator {
	
	private final FilmDAO filmDAO;
	
	public RentPriceCalculator(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}
	
	public int calculatePrice(RentRequest rentRequest) {
		List<FilmRentRequest> films = rentRequest.getFilmRentRequests();
		for (FilmRentRequest frr : films) {
			long filmId = frr.getFilmId();
			Optional<Film> film = filmDAO.findById(filmId);
			if (film.isPresent()) {
				// todo add gettype
				String type = film.get().getType();
				System.out.println("RentPriceCalculator.calculatePrice() FOUND film of type:"+type);
			}
			
		}
		return 0; 
	}

}
