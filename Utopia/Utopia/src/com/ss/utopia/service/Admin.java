package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.FlightSeatsDAO;
import com.ss.utopia.dao.PassengerDAO;
import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.FlightSeats;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.entity.User;

public class Admin {

	public void addAirport(Airport airport) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		new AirportDAO(connection).add(airport);
		connection.commit();
	}
	
	public void updateAirport(Airport airport) throws ClassNotFoundException, SQLException{
		Connection connection = new Util().getConnection();
		new AirportDAO(connection).update(airport);
		connection.commit();
	}
	
	public void deleteAirport(Airport airport) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		//delete routes with this airport in it, flights with those route, and bookings on those flights
		new AirportDAO(connection).delete(airport);
		
		connection.commit();
	}

	public void updateFlightSeats(FlightSeats seats) throws SQLException, ClassNotFoundException {
		Connection connection = new Util().getConnection();

		new FlightSeatsDAO(connection).update(seats);
		connection.commit();
	}

	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();

		new FlightDAO(connection).update(flight);
		new RouteDAO(connection).update(flight.getRoute());

		connection.commit();
	}

	public void addPassenger(Passenger passenger, Flight flight) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		FlightSeats seats = flight.getSeats();
		if (passenger.getSeatType() == "first") {
			seats.setFirstReserved(seats.getFirstReserved() + 1);
		} else if (passenger.getSeatType() == "business") {
			seats.setBusinessReserved(seats.getBusinessReserved() + 1);
		} else if (passenger.getSeatType() == "economy") {
			seats.setEconomyReserved(seats.getEconomyReserved() + 1);
		}

		new PassengerDAO(connection).add(passenger);
		new FlightDAO(connection).update(flight);

		connection.commit();
	}

	public void removePassenger(Passenger passenger, Flight flight) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		FlightSeats seats = flight.getSeats();
		if (passenger.getSeatType() == "first") {
			seats.setFirstReserved(seats.getFirstReserved() - 1);
		} else if (passenger.getSeatType() == "business") {
			seats.setBusinessReserved(seats.getBusinessReserved() - 1);
		} else if (passenger.getSeatType() == "economy") {
			seats.setEconomyReserved(seats.getEconomyReserved() - 1);
		}

		new PassengerDAO(connection).delete(passenger);
		new FlightDAO(connection).update(flight);

		connection.commit();
	}
	
	public void addUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		new UserDAO(connection).add(user);
		
		connection.commit();
	}
	
	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		new UserDAO(connection).update(user);
		
		connection.commit();
	}
	
	public void deleteUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		new UserDAO(connection).delete(user);
		
		connection.commit();	
	}
}
