package divorra.core;

public enum FilmType {
	
	NEW_RELEASE("NEW_RELEASE"), REGULAR("REGULAR"), OLD("OLD");
	
	private String type;
	FilmType(String type) {
		this.type = type;
	}

}
