package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Flight;

public class FlightDAO extends BaseDAO<Flight> {
	//flight columns
	//id
	//route_id
	//airplane_id
	//departure_time
	//reserved_seats
	//seat_price
	public FlightDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public void add(Flight flight) throws ClassNotFoundException, SQLException{
		save("insert into flight values(?,?,?,?,?,?)",
				new Object[] {flight.getId(), flight.getRouteId(), flight.getAirplaneId(),
						flight.getDepartureTime(), flight.getReservedSeats(), flight.getSeatPrice()});
	}
	
	public void update(Flight flight) throws ClassNotFoundException, SQLException{
		save("update flight set route_id=?, airplane_id=?, departure_time=?, reserved_seats=?, seat_price=? where id=?",
				new Object[] { flight.getRouteId(), flight.getAirplaneId(), flight.getDepartureTime(),
						flight.getReservedSeats(), flight.getSeatPrice(), flight.getId()});
	}
	
	public void delete(Flight flight) throws ClassNotFoundException, SQLException{
		save("delete from flight where id=?", new Object[] {flight.getId()});
	}
	
	public List<Flight> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from flight", new Object[] {});
	}

	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<Flight>();
		while(rs.next()) {
			Flight flight = new Flight();
			flight.setId(rs.getInt("id"));
			flight.setRouteId(rs.getInt("route_id"));
			flight.setAirplaneId(rs.getInt("airplane_id"));
			flight.setDepartureTime(rs.getString("departure_time"));
			flight.setReservedSeats(rs.getInt("reserved_seats"));
			flight.setSeatPrice(rs.getFloat("seat_price"));
			flights.add(flight);
		}
		return flights;
	}

}
