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
import com.ss.utopia.entity.Route;
import com.ss.utopia.entity.User;

public class Admin {

	public void addAirport(Airport airport) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		new AirportDAO(connection).add(airport);
		connection.commit();
		connection.close();
	}
	
	public void updateAirport(Airport airport) throws ClassNotFoundException, SQLException{
		Connection connection = new Util().getConnection();
		new AirportDAO(connection).update(airport);
		connection.commit();
		connection.close();
	}
	
	public void deleteAirport(Airport airport) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		//delete routes with this airport in it, flights with those route, and bookings on those flights
		new AirportDAO(connection).delete(airport);
		
		connection.commit();
		connection.close();
	}

	public void updateFlightSeats(FlightSeats seats) throws SQLException, ClassNotFoundException {
		Connection connection = new Util().getConnection();

		new FlightSeatsDAO(connection).update(seats);
		connection.commit();
		connection.close();
	}

	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();

		new FlightDAO(connection).update(flight);
		new RouteDAO(connection).update(flight.getRoute());

		connection.commit();
		connection.close();
	}
	
	public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		RouteDAO routeDAO = new RouteDAO(connection);
		routeDAO.add(flight.getRoute());
		Route newRoute =routeDAO.readRouteByAirportCodes(flight.getRoute().getOriginAirport().getAirportCode(), flight.getRoute().getDestinationAirport().getAirportCode());
		
		flight.setRouteId(newRoute.getId());
		
		FlightDAO flightDAO = new FlightDAO(connection);
		flightDAO.add(flight);
		
		flight.getSeats().setFlightId(flight.getId());
		
		new FlightSeatsDAO(connection).add(flight.getSeats());

		connection.commit();
		connection.close();
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
		connection.close();
	}
	
	public void updatePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		new PassengerDAO(connection).update(passenger);
		connection.commit();
		connection.close();
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
		connection.close();
	}
	
	public void addUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		new UserDAO(connection).add(user);
		
		connection.commit();
		connection.close();
	}
	
	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		new UserDAO(connection).update(user);
		
		connection.commit();
		connection.close();
	}
	
	public void deleteUser(User user) throws ClassNotFoundException, SQLException {
		Connection connection = new Util().getConnection();
		new UserDAO(connection).delete(user);
		
		connection.commit();
		connection.close();
	}
}
