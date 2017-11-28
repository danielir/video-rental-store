package divorra.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import divorra.core.FilmRentRequest;
import divorra.core.RentRequest;
import divorra.core.RentResponse;
import divorra.core.Rental;
import divorra.core.finance.RentPriceCalculator;
import divorra.db.FilmDAO;
import divorra.db.PriceDAO;
import divorra.db.RentalDAO;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/rent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RentResource {
	
	private final FilmDAO filmDAO;	
	private final PriceDAO priceDAO;
	private final RentalDAO rentalDAO;
	
	public RentResource(FilmDAO filmDAO, PriceDAO priceDAO, RentalDAO rentalDAO) {
		this.filmDAO = filmDAO;
		this.priceDAO = priceDAO;
		this.rentalDAO = rentalDAO;
	}
	
	@POST
	@UnitOfWork
	public RentResponse rent(RentRequest rentRequest) {
		System.out.println("Rent request for customerId: " + rentRequest.getCustomerId());
		
		
		RentPriceCalculator priceCalculator = new RentPriceCalculator(filmDAO, priceDAO);
		double price = priceCalculator.calculatePrice(rentRequest);
		
		for (FilmRentRequest f : rentRequest.getFilmRentRequests()) {
			System.out.println("RentResource.rent() FilmRentRequest received: " + f.getFilmId() + ", "+f.getDays());
			Rental rental = new Rental();
			rental.setCustomer_id(rentRequest.getCustomerId());
			rental.setFilm_id(f.getFilmId());
			this.rentalDAO.create(rental);
		}
		
		// create rent on database
		
		return new RentResponse(price);
	}

}
