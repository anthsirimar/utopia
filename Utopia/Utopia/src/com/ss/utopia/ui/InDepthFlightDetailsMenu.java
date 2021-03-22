package com.ss.utopia.ui;

import java.sql.SQLException;

import com.ss.utopia.dao.FlightSeatsDAO;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.FlightSeats;
import com.ss.utopia.service.Util;

public class InDepthFlightDetailsMenu extends Menu {

	Flight flight;
	FlightSeats seats;
	
	public InDepthFlightDetailsMenu(Flight flight) throws ClassNotFoundException, SQLException {
		this.cancelMessage = "Return to previous menu";
		this.flight = flight;
		this.seats = new FlightSeatsDAO(new Util().getConnection()).readFlightSeatsByFlightId(flight.getId());
		
		
	}
	
	@Override
	public void printMenu() {
		StringBuilder s = new StringBuilder();
		s.append("You have chosen to view the Flight with Flight ID: ");
		s.append(flight.getId());
		String origin = flight.getRoute().getOriginAirport().getAirportCode();
		String destination = flight.getRoute().getDestinationAirport().getAirportCode();
		s.append(" and Departure Airport: " + origin);
		s.append(" and Arrival Airport: " + destination + "\n");
		System.out.println(s);
		
		System.out.println("Departure Airport: " + origin + " | " + "Arrival Airport: " + destination + " |");
		System.out.println("Departure Date: " + flight.departureDate() + " | " + "Departure Time: " + flight.departureTime() + " |");
		System.out.println("Arrival Date: " + flight.arrivalDate() + " | " + "Arrival Time: " + flight.arrivalTime() + " |");
		System.out.println();
		
		System.out.println("Available Seats by class:");
		System.out.println("-1- First -> " + (seats.getFirstTotal()-seats.getFirstReserved()));
		System.out.println("-2- Business -> " + (seats.getBusinessTotal()-seats.getBusinessReserved()));
		System.out.println("-3- Economy -> " + (seats.getEconomyTotal()-seats.getEconomyReserved()));
		
		System.out.println("1) " + cancelMessage);
	}
	

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		switch(choice) {
		case 1:
			return this.previousMenu;
		default:
			System.out.println("Please enter a valid input");
			return this;
		}
	}

}
