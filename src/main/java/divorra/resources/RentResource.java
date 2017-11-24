package divorra.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import divorra.core.FilmRentRequest;
import divorra.core.RentRequest;
import divorra.core.finance.RentPriceCalculator;
import divorra.db.FilmDAO;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/rent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RentResource {
	
	private final FilmDAO filmDAO;	
	
	public RentResource(FilmDAO filmDAO) {
		this.filmDAO = filmDAO;
	}
	
	@POST
	@UnitOfWork
	public int rent(RentRequest rentRequest) {
		System.out.println("Rent request for customerId: " + rentRequest.getCustomerId());
		
		
		RentPriceCalculator priceCalculator = new RentPriceCalculator(filmDAO);
		priceCalculator.calculatePrice(rentRequest);
		
		for (FilmRentRequest f : rentRequest.getFilmRentRequests()) {
			System.out.println("RentResource.rent() FilmRentRequest received: " + f.getFilmId() + ", "+f.getDays());			
		}
		
		// create rent on database
		
		return 0;
	}

}
