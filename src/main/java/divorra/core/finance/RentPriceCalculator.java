package divorra.core.finance;

import java.util.List;

import divorra.core.FilmRentRequest;
import divorra.core.RentRequest;

public class RentPriceCalculator {
	
	private RentPriceCalculator() {}
	
	public static int calculatePrice(RentRequest rentRequest) {
		List<FilmRentRequest> films = rentRequest.getFilmRentRequests();
		for (FilmRentRequest frr : films) {
			long filmId = frr.getFilmId();
			
		}
		return 0; 
	}

}
