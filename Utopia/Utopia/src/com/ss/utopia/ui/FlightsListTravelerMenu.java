package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.PassengerDAO;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.service.Admin;
import com.ss.utopia.service.Util;

public class FlightsListTravelerMenu extends Menu {

	private List<Flight> flightsList = new ArrayList<Flight>();
	private Booking booking;
	private boolean addingPassenger = true;
	
	public FlightsListTravelerMenu(Booking booking) throws ClassNotFoundException, SQLException {
		this.booking = booking;
		this.menuDescription = "Pick the Flight you want to book a ticket for:";
		this.setCancelMessage("Quit to Previous");
		this.buildFlightsMenu();
	}
	
	public void addingPassenger(boolean b) {
		this.addingPassenger = b;
	}
	

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		
		if (choice-1 < flightsList.size()) {
			if(addingPassenger) {
			//pick corresponding flight
			FlightDetailsTravelerMenu menu = new FlightDetailsTravelerMenu(flightsList.get(choice-1), booking);
			menu.setPreviousMenu(this);
			return menu;
			}
			else {
				try {
					deletePassengerFromFlight(flightsList.get(choice-1), booking);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		} else if (choice-1 == flightsList.size()) {
			return this.previousMenu;
		} else {
			System.out.println("Please enter a valid input");
			return this;
		}
	}


	public void addToFlightsList(Flight flight) {
		flightsList.add(flight);
	}

	private void buildFlightsMenu() throws ClassNotFoundException, SQLException {
		for (Flight flight : new FlightDAO(new Util().getConnection()).readAll()) {
			this.flightsList.add(flight);

			Airport origin = flight.getRoute().getOriginAirport();
			Airport destination = flight.getRoute().getDestinationAirport();

			String option = origin.getAirportCode() + ", " + origin.getCity() + " -> " + destination.getAirportCode()
					+ ", " + destination.getCity();
			
			this.menuOptions.add(option);
		}

	}
	
	private void deletePassengerFromFlight(Flight flight, Booking booking) throws ClassNotFoundException, SQLException {
		Passenger passenger = new PassengerDAO(new Util().getConnection()).readPassengerByBookingId(booking.getId());
		
		new Admin().removePassenger(passenger, flight);
		System.out.println("Removed successfully. Thank you, the program will now close.");
	}
}
