package divorra.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;

import divorra.core.RentalForJdbi;
import io.dropwizard.hibernate.AbstractDAO;

public class RentalDAO extends AbstractDAO<RentalForJdbi> {

	public RentalDAO(SessionFactory factory) {
		super(factory);
	}
	
	public RentalForJdbi create(RentalForJdbi rental) {
		return persist(rental);
	}
	
	public List<RentalForJdbi> findAll() {
		return list(namedQuery("findAll"));
	}
	
	public Optional<RentalForJdbi> findById(Long id) {
        return Optional.ofNullable(get(id));
    }
	
	
}
