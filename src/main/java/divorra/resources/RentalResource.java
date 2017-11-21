package divorra.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import divorra.core.Customer;
import divorra.core.Film;
import divorra.core.Rental;
import divorra.db.MyDAO;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/rentals")
@Produces(MediaType.APPLICATION_JSON)
public class RentalResource {
	
	private final MyDAO myDAO;
	
	public RentalResource(MyDAO myDAO) {
		this.myDAO = myDAO;
	}
	
	@POST
	@UnitOfWork
	public int rent(Rental rental) {
		return myDAO.insert(rental);
	}
	
	
	@GET
	@UnitOfWork
	public List<Rental> listRentals() {
		return myDAO.findAll();
	}
	
	
	
}
