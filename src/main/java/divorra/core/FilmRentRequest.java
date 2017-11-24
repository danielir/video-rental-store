package divorra.core;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmRentRequest {
	
	@NotNull
    @JsonProperty
	private long filmId;
	
	@NotNull
    @JsonProperty
	private short days;
	
	public FilmRentRequest() {
		
	}
	
	public FilmRentRequest(long filmId, short days) {
		this.filmId = filmId;
		this.days = days;
	}	
	
	public long getFilmId() {
		return filmId;
	}
	public void setFilmId(long filmId) {
		this.filmId = filmId;
	}
	public short getDays() {
		return days;
	}
	public void setDays(short days) {
		this.days = days;
	}
	

}
