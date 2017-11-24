package divorra.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import divorra.core.Customer;
import divorra.core.Film;
import divorra.core.RentalForJdbi;
import divorra.db.MyDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/rentals")
@Produces(MediaType.APPLICATION_JSON)
public class RentalResourceUsingJdbi {
	
	private final MyDAO myDAO;
	
	public RentalResourceUsingJdbi(MyDAO myDAO) {
		this.myDAO = myDAO;
	}
	
	@POST
	@UnitOfWork
	public int rent(RentalForJdbi rental) {
		return myDAO.insert(rental);
	}
	
	
	@GET
	@UnitOfWork
	public List<RentalForJdbi> listRentals() {
		return myDAO.findAll();
	}
	
	@Path("/customer/{customerId}")
	@GET
	@UnitOfWork
	public List<RentalForJdbi> listRentalsByUser(@PathParam("customerId") LongParam customerId) {
		return myDAO.findRentalsByCustomerId(customerId.get());
	}
	
	
	
	
}
