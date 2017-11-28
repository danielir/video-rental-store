package divorra.core.finance;

import java.util.List;
import java.util.Optional;

import divorra.core.Film;
import divorra.core.FilmRentRequest;
import divorra.core.Price;
import divorra.core.RentRequest;
import divorra.db.FilmDAO;
import divorra.db.PriceDAO;

public class RentPriceCalculator {
	
	private final FilmDAO filmDAO;
	private final PriceDAO priceDAO;
	
	public RentPriceCalculator(FilmDAO filmDAO, PriceDAO priceDAO) {
		this.filmDAO = filmDAO;
		this.priceDAO = priceDAO;
	}
	
	public double calculatePrice(RentRequest rentRequest) {
		double price = 0.0;
		List<FilmRentRequest> films = rentRequest.getFilmRentRequests();
		for (FilmRentRequest frr : films) {
			long filmId = frr.getFilmId();
			Optional<Film> film = filmDAO.findById(filmId);
			if (film.isPresent()) {
				String filmType = film.get().getType().toString();
				System.out.println("RentPriceCalculator.calculatePrice() FOUND film of type:"+filmType);
				List<Price> prices = priceDAO.findByFilmType(filmType);
				if (prices.size() == 1) {
					System.out.println("Price: "+prices.get(0).getPrice());
					int daysAllowed = prices.get(0).getDays();
					int days = frr.getDays();					
					price = price + prices.get(0).getPrice();
				}
				
			}
			
		}
		return price; 
	}

}
