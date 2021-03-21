package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.FlightBooking;

public class FlightBookingDAO extends BaseDAO<FlightBooking> {
	//flight_bookings columns
	//flight_id
	//booking_id
	

	public FlightBookingDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public void add(FlightBooking booking) throws ClassNotFoundException, SQLException{
		save("insert into flight_bookings values (?,?)",
				new Object[] {booking.getFlightId(), booking.getBookingId()});
	}
	
	public void update(FlightBooking booking) throws ClassNotFoundException, SQLException{
		
	}
	
	public void delete(FlightBooking booking) throws ClassNotFoundException, SQLException{
		save("delete from flight_bookings where flight_id=? and booking_id=?",
				new Object[] {booking.getFlightId(), booking.getBookingId()});
	}
	
	public List<FlightBooking> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from flight_bookings",
				new Object[] {});
	}

	@Override
	public List<FlightBooking> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<FlightBooking> bookings = new ArrayList<FlightBooking>();
		while(rs.next()) {
			FlightBooking booking = new FlightBooking();
			booking.setBookingId(rs.getInt("booking_id"));
			booking.setFlightId(rs.getInt("flight_id"));
			bookings.add(booking);
		}
		return bookings;
	}

}
