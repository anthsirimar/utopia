package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.Util;

public class AdminFlightMenu extends Menu {

	public AdminFlightMenu() {
		menuOptions = Arrays.asList("Add", "Update", "Delete", "Read");
		cancelMessage = "Quit to previous";
	}

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		switch (choice) {
		case 1:
			return this;
		case 2:
			updateFlight();
			return this;
		case 3:
			return this;
		case 4:
			readFlights();
			return this;
		case 5:
			// Quit
			return previousMenu;
		default:
			System.out.println("Please enter a valid input.");
			return this;
		}
	}

	private void updateFlight() throws ClassNotFoundException, SQLException {
		FlightDAO dao = new FlightDAO(new Util().getConnection());
		Flight flight;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ID of flight to update");
		flight = dao.readFlightsById(scanner.nextInt());
		
	}

	private void readFlights() throws ClassNotFoundException, SQLException {
		List<Flight> flights = new FlightDAO(new Util().getConnection()).readAll();
		for (Flight flight : flights) {
			System.out.println(flight.toString());
		}
	}

}
