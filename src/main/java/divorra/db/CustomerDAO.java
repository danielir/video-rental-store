package divorra.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;

import divorra.core.Customer;
import io.dropwizard.hibernate.AbstractDAO;

public class CustomerDAO extends AbstractDAO<Customer> {

	public CustomerDAO(SessionFactory factory) {
		super(factory);
	}
	
	public Customer create(Customer customer) {
		return persist(customer);
	}
	
	public List<Customer> findAll() {
		return list(namedQuery("customer.findAll"));
	}
	
	public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(get(id));
    }
	
	
}
