package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.FlightSeats;
import com.ss.utopia.entity.Route;

public class FlightDAO extends BaseDAO<Flight> {
	//flight columns
	//id
	//route_id
	//airplane_id
	//departure_time
	//arrival_time
	public FlightDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public void add(Flight flight) throws ClassNotFoundException, SQLException{
		save("insert into flight values(?,?,?,?,?)",
				new Object[] {flight.getId(), flight.getRouteId(), flight.getAirplaneId(),
						flight.getDepartureTime(), flight.getArrivalTime()});
	}
	
	public void update(Flight flight) throws ClassNotFoundException, SQLException{
		save("update flight set route_id=?, airplane_id=?, departure_time=?, arrival_Time=? where id=?",
				new Object[] { flight.getRouteId(), flight.getAirplaneId(), flight.getDepartureTime(),
						flight.getArrivalTime(), flight.getId()});
	}
	
	public void delete(Flight flight) throws ClassNotFoundException, SQLException{
		save("delete from flight where id=?", new Object[] {flight.getId()});
	}
	
	public List<Flight> readAll() throws ClassNotFoundException, SQLException{
		return read("select * from flight", new Object[] {});
	}
	
	public Flight readFlightsById(int id) throws ClassNotFoundException, SQLException{
		return read("select * from flight where id=?",
				new Object[] {id}).get(0);
	}

	@Override
	public List<Flight> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<Flight>();
		while(rs.next()) {
			Flight flight = new Flight();
			int id = rs.getInt("id");
			flight.setId(id);
			flight.setRouteId(rs.getInt("route_id"));
			
			Route route = new RouteDAO(connection).readRouteById(rs.getInt("route_id"));
			flight.setRoute(route);
			
			FlightSeats seats = new FlightSeatsDAO(connection).readFlightSeatsByFlightId(id);
			seats.setFlight(flight);
			flight.setSeats(seats);
			
			flight.setAirplaneId(rs.getInt("airplane_id"));
			flight.setDepartureTime(rs.getString("departure_time"));
			flight.setArrivalTime(rs.getString("arrival_time"));
			flights.add(flight);
		}
		return flights;
	}

}
