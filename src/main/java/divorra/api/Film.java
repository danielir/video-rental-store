package divorra.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Film {
	private long id;
	private String name;
	
	public Film() {
		
	}
	
	public Film(long id, String name) {
		this.id = id;
		this.name = name;
	}

	@JsonProperty
	public long getId() {
		return id;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

}
