package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ss.utopia.entity.FlightSeats;


public class FlightSeatsDAO extends BaseDAO<FlightSeats> {
	//flight_seats columns
	//id
	//flight_id
	//first_total
	//first_reserved
	//first_price
	//business_total
	//buiness_reserved
	//business_price
	//economy_total
	//economy_reserved
	//economy_price

	public FlightSeatsDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public void add(FlightSeats seats) throws ClassNotFoundException, SQLException {
		save("insert into flight_seats values(?,?,?,?,?,?,?,?,?,?,?)",
				new Object[] {seats.getId(), seats.getFlight().getId(), seats.getFirstTotal(),
						seats.getFirstReserved(), seats.getFirstPrice(), seats.getBusinessTotal(), seats.getBusinessReserved(),
						seats.getBusinessPrice(), seats.getEconomyTotal(), seats.getEconomyReserved(), seats.getEconomyPrice()});
	}
	
	public void update(FlightSeats seats) throws ClassNotFoundException, SQLException {
		save("update flight_seats set flight_id=?, first_total=?, first_reserved=?, first_price=?, business_total=?, business_reserved=?, business_price=?, economy_total=?, economy_reserved=?, economy_price=? where id=?",
				new Object[] { seats.getFlight().getId(), seats.getFirstTotal(),
						seats.getFirstReserved(), seats.getFirstPrice(), seats.getBusinessTotal(), seats.getBusinessReserved(),
						seats.getBusinessPrice(), seats.getEconomyTotal(), seats.getEconomyReserved(), seats.getEconomyPrice(), seats.getId()});
	}
	
	public void delete(FlightSeats seats) throws ClassNotFoundException, SQLException {
		save("delete from flight_seats where id=?", new Object[] {seats.getId()});
	}
	
	public List<FlightSeats> readAll() throws ClassNotFoundException, SQLException {
		return read("select * from flight_seats", new Object[] {});
	}
	
	public FlightSeats readFlightSeatsByFlightId(int id) throws ClassNotFoundException, SQLException{
		//return null;
		return read("select * from flight_seats where flight_id=" + id,
				new Object[] {}).get(0);
	}


	@Override
	public List<FlightSeats> extractData(ResultSet rs) throws ClassNotFoundException, SQLException {
		List<FlightSeats> seats = new ArrayList<FlightSeats>();
		while(rs.next()) {
			FlightSeats s = new FlightSeats();
			s.setId(rs.getInt("id"));
			
			//Flight flight = new FlightDAO(connection).readFlightsById(rs.getInt("flight_id"));
			//s.setFlight(flight);
			
			s.setFirstTotal(rs.getInt("first_total"));
			s.setFirstReserved(rs.getInt("first_reserved"));
			s.setFirstPrice(rs.getInt("first_price"));
			
			s.setBusinessTotal(rs.getInt("business_total"));
			s.setBusinessReserved(rs.getInt("business_reserved"));
			s.setBusinessPrice(rs.getInt("business_price"));
			
			s.setEconomyTotal(rs.getInt("economy_total"));
			s.setEconomyReserved(rs.getInt("economy_reserved"));
			s.setEconomyPrice(rs.getInt("economy_price"));
			seats.add(s);
		}
		return seats;
	}

}
