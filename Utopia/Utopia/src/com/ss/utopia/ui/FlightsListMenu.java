package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.Util;

public class FlightsListMenu extends Menu {

	private List<Flight> flightsList = new ArrayList<Flight>();
	
	public FlightsListMenu() throws ClassNotFoundException, SQLException {
		this.menuDescription = "";
		this.setCancelMessage("Quit to Previous");
		this.buildFlightsMenu();
	}
	
	

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		if (choice-1 < flightsList.size()) {
			//pick corresponding flight and go to flight details menu
			FlightDetailsMenu menu = new FlightDetailsMenu(flightsList.get(choice-1));
			menu.setPreviousMenu(this);
			return menu;
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
	
}
