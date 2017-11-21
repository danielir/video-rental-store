package divorra.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import divorra.core.Customer;
import divorra.db.CustomerDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
	
	private final CustomerDAO customerDAO;
	
	public CustomerResource(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@POST
	@UnitOfWork
	public Customer createCustomer(Customer customer) {
		return customerDAO.create(customer);
	}
	
	
	@GET
	@UnitOfWork
	public List<Customer> listCustomers() {
		return customerDAO.findAll();
	}
	
	@Path("/{customerId}")
	@GET
	@UnitOfWork
	public Customer getCustomer(@PathParam("customerId") LongParam customerId) {
		return customerDAO.findById(customerId.get()).orElseThrow(() -> new NotFoundException("No such customer."));
	}
	
	
}
