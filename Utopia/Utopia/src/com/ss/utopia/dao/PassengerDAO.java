package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Passenger;

public class PassengerDAO extends BaseDAO<Passenger> {

	// passenger columns
	// id
	// booking_id
	// given_name
	// family_name
	// dob
	// gender
	// address
	// seat_type
	public PassengerDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public void add(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("insert into passenger(booking_id, given_name, family_name, dob, gender, address, seat_type) values(?,?,?,?,?,?,?)",
				new Object[] { passenger.getBookingId(), passenger.getGivenName(), passenger.getFamilyName(),
						passenger.getDateOfBirth(), passenger.getGender(), passenger.getAddress(),
						passenger.getSeatType() });
	}

	public void update(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("update passenger set booking_id=?, given_name=?, family_name=?, dob=?, gender=?, address=?, seat_type=? where id=?",
				new Object[] { passenger.getBookingId(), passenger.getGivenName(), passenger.getFamilyName(),
						passenger.getDateOfBirth(), passenger.getGender(), passenger.getAddress(),
						passenger.getSeatType(), passenger.getId() });
	}

	public void delete(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("delete from passenger where id=?", new Object[] { passenger.getId() });
	}

	public List<Passenger> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from passenger", new Object[] {});
	}

	public Passenger readPassengerByBookingId(int id) throws ClassNotFoundException, SQLException {
		return read("select * from passenger where booking_id=?", new Object[] { id }).get(0);
	}

	public Passenger readPassengerById(int id) throws ClassNotFoundException, SQLException {
		return read("select * from passenger where id=?", new Object[] { id }).get(0);
	}

	@Override
	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<Passenger>();
		while (rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setId(rs.getInt("id"));
			passenger.setBookingId(rs.getInt("booking_id"));
			passenger.setGivenName(rs.getString("given_name"));
			passenger.setFamilyName(rs.getString("family_name"));
			passenger.setDateOfBirth(rs.getString("dob"));
			passenger.setGender(rs.getString("gender"));
			passenger.setAddress(rs.getString("address"));
			passenger.setSeatType(rs.getString("seat_type"));
			passengers.add(passenger);
		}
		return passengers;
	}

}
