package divorra.db;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;

import divorra.core.Price;
import io.dropwizard.hibernate.AbstractDAO;

public class PriceDAO extends AbstractDAO<Price> {

	public PriceDAO(SessionFactory factory) {
		super(factory);
	}
	
	public Price create(Price price) {
		return persist(price);
	}
	
	public List<Price> findAll() {
		return list(namedQuery("Price.findAll"));
	}
	
	public Optional<Price> findById(Long id) {
        return Optional.ofNullable(get(id));
    }	
	
	public List<Price>findByFilmType(String filmType) {
		return list(namedQuery("Price.findByFilmType").setParameter("filmType", filmType));		
	}
	
	
}
