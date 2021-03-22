package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Airport;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.service.Admin;

public class FlightDetailsMenu extends Menu {

	private Flight flight;

	public FlightDetailsMenu(Flight flight) {
		this.flight = flight;

		List<String> options = Arrays.asList("View more details about the flight", "Update the details of the flight",
				"Add seats to flight");
		this.setMenuOptions(options);

		this.setMenuDescription("");
		this.setCancelMessage("Quit to Previous");
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {

		Menu menu;
		switch (choice) {
		case 1:
			// View flight details
			menu = new InDepthFlightDetailsMenu(this.flight);
			menu.setPreviousMenu(this);
			return menu;
		case 2:
			// update flight details
			this.updateFlight();
			return this;
		case 3:
			// add seats
			menu = new UpdateSeatsMenu(flight.getSeats());
			menu.setPreviousMenu(this);
			return menu;
		case 4:
			return this.previousMenu;
		default:
			System.out.println("Please enter a valid input");
			return this;
		}
	}

	@SuppressWarnings("resource")
	private void updateFlight() throws ClassNotFoundException, SQLException {
		printUpdateDescription();
		Scanner scanner = null;
		scanner = new Scanner(System.in);

		System.out.println(
				"Please enter a new Origin Airport and City (format: XYZ,City name) or enter N/A for no change");
		String newOrigin = scanner.nextLine();
		if (newOrigin.equals("quit"))
			return;

		System.out.println(
				"Please enter a new Destination Airport and City (format: XYZ,City name) or enter N/A for no change");
		String newDestination = scanner.nextLine();
		if (newDestination.equals("quit"))
			return;

		System.out.println("Please enter a new Departure Date or enter N/A for no change");
		String newDepartureDate = scanner.nextLine();
		if (newDepartureDate.equals("quit"))
			return;
		if (newDepartureDate.equals("N/A"))
			newDepartureDate = flight.departureDate();

		System.out.println("Please enter a new Departure Time or enter N/A for no change");
		String newDepartureTime = scanner.nextLine();
		if (newDepartureTime.equals("quit"))
			return;
		if (newDepartureTime.equals("N/A"))
			newDepartureTime = flight.departureTime();

		System.out.println("Please enter a new Arrival Date or enter N/A for no change");
		String newArrivalDate = scanner.nextLine();
		if (newArrivalDate.equals("quit"))
			return;
		if (newArrivalDate.equals("N/A"))
			newArrivalDate = flight.arrivalDate();

		System.out.println("Please enter a new Arrival Time or enter N/A for no change");
		String newArrivalTime = scanner.nextLine();
		if (newOrigin.equals("quit"))
			return;
		if (newArrivalTime.equals("N/A"))
			newArrivalTime = flight.arrivalTime();

		Airport newOriginAirport = newOrigin.equals("N/A") ? flight.getRoute().getOriginAirport()
				: getNewAirportFromString(newOrigin);
		flight.getRoute().setOriginAirport(newOriginAirport);

		Airport newDestinationAirport = newDestination.equals("N/A") ? flight.getRoute().getDestinationAirport()
				: getNewAirportFromString(newDestination);
		flight.getRoute().setDestinationAirport(newDestinationAirport);

		flight.setDepartureTime(newDepartureDate + " " + newDepartureTime);
		flight.setArrivalTime(newArrivalDate + " " + newArrivalTime);

		new Admin().updateFlight(flight);
		System.out.println("Flight updated successfully");
	}

	private Airport getNewAirportFromString(String string) {
		Airport airport = new Airport();
		String[] split = string.split(",");
		airport.setAirportCode(split[0]);
		airport.setCity(split[1]);
		return airport;
	}

	private void printUpdateDescription() {
		StringBuilder s = new StringBuilder();
		s.append("You have chosen to update the Flight with Flight ID: ");
		s.append(flight.getId());
		String origin = flight.getRoute().getOriginAirport().getAirportCode();
		String destination = flight.getRoute().getDestinationAirport().getAirportCode();
		s.append(" and Departure Airport: " + origin);
		s.append(" and Arrival Airport: " + destination);
		System.out.println(s);
		System.out.println("Enter 'quit' at any prompt to cancel this operation.");
	}

}
