package divorra.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import divorra.core.Rental;
import divorra.core.mapper.RentalMapper;

@RegisterMapper(RentalMapper.class)
public interface MyDAO {
	
	@SqlQuery("select * from rentals where customer_id = :customer_id")
	List<Rental> findRentalsByCustomerId(@Bind("customer_id") long id);
	
	@SqlQuery("select * from rentals")
	List<Rental> findAll();
	
	@SqlUpdate("insert into rentals (CUSTOMER_ID, FILM_ID) values (:customer_id, :film_id)")
    int insert(@BindBean Rental rental);	
	

}
