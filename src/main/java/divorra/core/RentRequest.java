package divorra.core;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RentRequest {
	
	@NotNull
    @JsonProperty
	private long customerId;
	
	
	@NotNull
    @JsonProperty
    private List<FilmRentRequest> filmRentRequests;
	
	
	public RentRequest() {
		
	}
	
	public RentRequest(long customerId, List<FilmRentRequest> filmRentrequests) {
		this.customerId = customerId;
		this.filmRentRequests = filmRentrequests;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/*
	public List<String> getFilmRentRequests() {
		return filmRentRequests;
	}

	public void setFilmRentRequests(List<String> filmRentRequests) {
		this.filmRentRequests = filmRentRequests;
	}*/
	
	///*
	public List<FilmRentRequest> getFilmRentRequests() {
		return filmRentRequests;
	}
	public void setFilmRentRequests(List<FilmRentRequest> filmRentRequests) {
		this.filmRentRequests = filmRentRequests;
	}//*/
	

}
