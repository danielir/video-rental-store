package divorra.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import divorra.core.Film;
import divorra.core.Price;
import divorra.db.PriceDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import io.dropwizard.jersey.params.NonEmptyStringParam;

@Path("/prices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PriceResource {
	
	private final PriceDAO priceDAO;
	
	public PriceResource(PriceDAO priceDAO) {
		this.priceDAO = priceDAO;
	}
	
	@POST
	@UnitOfWork
	public Price createPrice(Price price) {
		return priceDAO.create(price);
	}
	
	
	@GET
	@UnitOfWork
	public List<Price> listPrices() {
		return priceDAO.findAll();
	}
	
	@Path("/{priceId}")
	@GET
	@UnitOfWork
	public Price getPrice(@PathParam("priceId") LongParam priceId) {
		return priceDAO.findById(priceId.get()).orElseThrow(() -> new NotFoundException("No such film."));
	}

}
