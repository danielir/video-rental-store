package divorra.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import divorra.core.FilmRentRequest;
import divorra.core.RentRequest;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/rent")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RentResource {
	
	@POST
	@UnitOfWork
	public int rent(RentRequest rentRequest) {
		System.out.println("Rent request for customerId: " + rentRequest.getCustomerId());
		
		for (FilmRentRequest f : rentRequest.getFilmRentRequests()) {
			System.out.println("RentResource.rent() FilmRentRequest received: " + f.getFilmId() + ", "+f.getDays());
		}
		/*
		for (String s : rentRequest.getFilmRentRequests()) {
			System.out.println("RentResource.rent() string received: " + s);
		}*/
		return 0;
	}

}
