package divorra.core;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "prices")
@NamedQueries({
	@NamedQuery(
			name="Price.findAll", 
			query="SELECT p from Price p"),
	@NamedQuery(
			name="Price.findByFilmType", 
			query="SELECT p from Price p "
			+ "where p.filmType like :filmType")
})

public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	@Column(name = "filmType", nullable = false)
	private String filmType;
	
	@Column(name = "price", nullable = false)
	private double price;
	
	@Column(name = "days", nullable = false)
	private int days;
	
	public Price() {}
	
	public Price(long id, String filmType, double price, int days) {
		super();
		this.id = id;
		this.filmType = filmType;
		this.price = price;
		this.days = days;
	}
	public String getFilmType() {
		return filmType;
	}
	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
        if (!(o instanceof Price)) {
            return false;
        }

        final Price that = (Price) o;

        return Objects.equals(this.id, that.id) &&
        		Objects.equals(this.price, that.price) &&
        		Objects.equals(this.filmType, that.filmType) &&
                Objects.equals(this.days, that.days);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, price, filmType, days);
	}

	public long getId() {
		return id;
	}
	
	
}
