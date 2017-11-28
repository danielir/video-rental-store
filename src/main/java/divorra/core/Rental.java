package divorra.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rentals")
@NamedQueries({
	@NamedQuery(
			name="Rental.findAll", 
			query="SELECT r from Rental r")	
})

public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(name = "customer_id", nullable = false)
	private long customer_id;
    
	@Column(name = "film_id", nullable = false)
    private long film_id;
    

    public Rental(long id, long customer_id, long film_id) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.film_id = film_id;
	}


	public Rental() {
        // Jackson deserialization
    }


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}


	public long getFilm_id() {
		return film_id;
	}


	public void setFilm_id(long film_id) {
		this.film_id = film_id;
	}

    
	
}