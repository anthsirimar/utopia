package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Passenger;

public class PassengerDAO extends BaseDAO<Passenger> {

	//passenger columns
	//id
	//booking_id
	//given_name
	//family_name
	//dob
	//gender
	//address
	public PassengerDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public void add(Passenger passenger) throws ClassNotFoundException, SQLException{
		save("insert into passenger values(?,?,?,?,?,?,?)",
				new Object[] {passenger.getId(), passenger.getBookingId(), passenger.getGivenName(),
						passenger.getFamilyName(), passenger.getDateOfBirth(), passenger.getGender(), passenger.getAddress()});
	}
	
	public void update(Passenger passenger) throws ClassNotFoundException, SQLException{
		save("update passenger set booking_id=?, given_name=?, family_name=?, dob=?, gender=?, address=? where id=?",
				new Object[] {passenger.getBookingId(), passenger.getGivenName(), passenger.getFamilyName(),
						passenger.getDateOfBirth(), passenger.getGender(), passenger.getAddress(), passenger.getId()});
	}
	
	public void delete(Passenger passenger) throws ClassNotFoundException, SQLException{
		save("delete from passenger where id=?",
				new Object[] {passenger.getId()});
	}
	
	public List<Passenger> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from passenger", new Object[] {});
	}

	@Override
	public List<Passenger> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<Passenger>();
		while(rs.next()) {
			Passenger passenger = new Passenger();
			passenger.setId(rs.getInt("id"));
			passenger.setBookingId(rs.getInt("booking_id"));
			passenger.setGivenName(rs.getString("given_name"));
			passenger.setFamilyName(rs.getString("family_name"));
			passenger.setDateOfBirth(rs.getString("dob"));
			passenger.setGender(rs.getString("gender"));
			passenger.setAddress(rs.getString("address"));
			passengers.add(passenger);
		}
		return passengers;
	}

}
