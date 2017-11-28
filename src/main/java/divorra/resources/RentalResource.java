package divorra.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import divorra.core.Rental;
import divorra.db.RentalDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/rentals")
@Produces(MediaType.APPLICATION_JSON)
public class RentalResource {
	
	private final RentalDAO myDAO;
	
	public RentalResource(RentalDAO myDAO) {
		this.myDAO = myDAO;
	}
	
	@POST
	@UnitOfWork
	public Rental rent(Rental rental) {
		return myDAO.create(rental);
	}
	
	
	@GET
	@UnitOfWork
	public List<Rental> listRentals() {
		return myDAO.findAll();
	}
	
	@Path("/customer/{customerId}")
	@GET
	@UnitOfWork
	public List<Rental> listRentalsByUser(@PathParam("customerId") LongParam customerId) {
		return myDAO.findRentalsByCustomerId(customerId.get());
	}
	
	
	
	
}
