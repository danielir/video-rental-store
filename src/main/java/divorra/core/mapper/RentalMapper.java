package divorra.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import divorra.core.Rental;

public class RentalMapper implements ResultSetMapper<Rental> {

	@Override
	public Rental map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {
		return new Rental(resultSet.getInt("id"), resultSet.getInt("customer_id"), resultSet.getInt("film_id"));
	}

}
