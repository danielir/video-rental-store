package divorra.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;

import divorra.core.Rental;
import io.dropwizard.hibernate.AbstractDAO;

public class RentalDAO extends AbstractDAO<Rental> {

	public RentalDAO(SessionFactory factory) {
		super(factory);
	}
	
	public Rental create(Rental rental) {
		return persist(rental);
	}
	
	public List<Rental> findAll() {
		return list(namedQuery("Rental.findAll"));
	}
	
	public Optional<Rental> findById(Long id) {
        return Optional.ofNullable(get(id));
    }
	
	public List<Rental> findRentalsByCustomerId(Long id) {
		return list(namedQuery("Rental.findAll"));
	}
	
	
}
