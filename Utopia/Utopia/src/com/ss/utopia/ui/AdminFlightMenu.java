package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.FlightSeats;
import com.ss.utopia.entity.Route;
import com.ss.utopia.service.Admin;
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
			addFlight();
			return this;
		case 2:
			updateFlight();
			return this;
		case 3:
			deleteFlight();
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

	private void deleteFlight() {
		System.out.println("Delete flight");
		
	}

	@SuppressWarnings("resource")
	private void addFlight() throws ClassNotFoundException, SQLException {
		Flight flight = new Flight();
		flight.setRoute(new Route());
		flight.setSeats(new FlightSeats());
		flight.getSeats().setFlight(flight);
		Scanner scanner = new Scanner(System.in);
		AirportDAO dao = new AirportDAO(new Util().getConnection());
		System.out.println("Enter the ID for this new flight");
		flight.setId(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Enter the Airport code of the origin of this new flight");
		flight.getRoute().setOriginAirport(dao.readAirportsById(scanner.nextLine()));
		
		System.out.println("Enter the Airport code of the destination of this new flight");
		flight.getRoute().setDestinationAirport(dao.readAirportsById(scanner.nextLine()));
		
		System.out.println("Enter a departure time (format: YYYY-MM-DD HH:MM:SS)");
		flight.setDepartureTime(scanner.nextLine());
		System.out.println("Enter an arrival time (format: YYYY-MM-DD HH:MM:SS)");
		flight.setArrivalTime(scanner.nextLine());
		
		System.out.println("Enter an airplane ID");
		flight.setAirplaneId(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Enter the total number of first class seats");
		flight.getSeats().setFirstTotal(Integer.parseInt(scanner.nextLine()));
		System.out.println("Enter the total number of business class seats");
		flight.getSeats().setBusinessTotal(Integer.parseInt(scanner.nextLine()));
		System.out.println("Enter the total number of first class seats");
		flight.getSeats().setEconomyTotal(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Enter the price of a first class seat");
		flight.getSeats().setFirstPrice(Float.parseFloat(scanner.nextLine()));
		System.out.println("Enter the price of a business class seat");
		flight.getSeats().setBusinessPrice(Float.parseFloat(scanner.nextLine()));
		System.out.println("Enter the price of a economy class seat");
		flight.getSeats().setEconomyPrice(Float.parseFloat(scanner.nextLine()));

		
		new Admin().addFlight(flight);
		System.out.println("Flight added successfully");
		
	}

	@SuppressWarnings("resource")
	private void updateFlight() throws ClassNotFoundException, SQLException {
		FlightDAO dao = new FlightDAO(new Util().getConnection());
		Flight flight;
		Scanner scanner = new Scanner(System.in);
		String input = "";
		System.out.println("Enter ID of flight to update");
		flight = dao.readFlightsById(Integer.parseInt(scanner.nextLine()));
		System.out.println("Enter the new airplane ID, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			flight.setAirplaneId(Integer.parseInt(input));
		
		System.out.println("Enter the new departure date and time, or enter nothing to not change it");
		System.out.println("Current date: " + flight.getDepartureTime());
		input = scanner.nextLine();
		if(input != "")
			flight.setDepartureTime(input);
			
		System.out.println("Enter the new arrival date and time, or enter nothing to not change it");
		System.out.println("Current date: " + flight.getArrivalTime());
		input = scanner.nextLine();
		if(input != "")
			flight.setArrivalTime(input);
		
		new Admin().updateFlight(flight);
		System.out.println("Updated flight successfully");
	}

	private void readFlights() throws ClassNotFoundException, SQLException {
		List<Flight> flights = new FlightDAO(new Util().getConnection()).readAll();
		for (Flight flight : flights) {
			System.out.println(flight.toString());
		}
	}

}
