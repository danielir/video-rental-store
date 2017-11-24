package divorra.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class RentalForJdbi {

    @NotNull
    @JsonProperty
    private Integer id;

    @NotNull
    @JsonProperty
    private Integer customer_id;
    
    @NotNull
    @JsonProperty
    private Integer film_id;
    

    public RentalForJdbi() {
        // Jackson deserialization
    }

    public RentalForJdbi(int id, int customer_id, int film_id) {
        this.id = id;
        this.customer_id = customer_id;
        this.film_id = film_id;
    }

    public Integer getId() {
        return id;
    }
    
    public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public Integer getFilm_id() {
		return film_id;
	}

	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentalForJdbi)) return false;

        RentalForJdbi that = (RentalForJdbi) o;

        if (!getId().equals(that.getId())) return false;
        if (!getFilm_id().equals(that.getFilm_id())) return false;
        if (!getCustomer_id().equals(that.getCustomer_id())) return false;

        return true;
    }

	
}