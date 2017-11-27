package divorra.core;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "films")
@NamedQueries({
	@NamedQuery(
			name="findAll", 
			query="SELECT f from Film f")	
})

public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private FilmType type;
	
	
	public Film() {
		
	}
	
	public Film(long id, String name, FilmType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
        if (!(o instanceof Film)) {
            return false;
        }

        final Film that = (Film) o;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	public FilmType getType() {
		return type;
	}

	public void setType(FilmType type) {
		this.type = type;
	}

	
}
