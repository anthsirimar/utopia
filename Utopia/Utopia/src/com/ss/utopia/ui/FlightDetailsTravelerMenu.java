package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.FlightSeats;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.service.Admin;

public class FlightDetailsTravelerMenu extends Menu {

	private Flight flight;
	private Booking booking;

	public FlightDetailsTravelerMenu(Flight flight, Booking booking) {

		this.flight = flight;
		this.booking = booking;
		this.menuOptions = buildOptionsMenu();

		this.setMenuDescription("Pick the seat you want to book a ticket for");
		this.setCancelMessage("Quit to cancel opetation");
	}

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		System.out.println(menuOptions.size());
		if (choice == 1) {
			InDepthFlightDetailsMenu menu;
			menu = new InDepthFlightDetailsMenu(this.flight);
			menu.setPreviousMenu(this);
			return menu;
		} else if (choice - 1 == menuOptions.size()) {
			// Quit
			return this.previousMenu;
		} else if (choice - 1 > menuOptions.size()) {
			System.out.println("Please enter a valid input");
			return this;
		} else if (menuOptions.get(choice - 1) == "First") {
			bookTicket("first");
			System.out.println("Revervation added. Thank you, the program will now close.");
			return null;
		} else if (menuOptions.get(choice - 1) == "Business") {
			bookTicket("business");
			System.out.println("Revervation added. Thank you, the program will now close.");
			return null;
		} else if (menuOptions.get(choice - 1) == "Economy") {
			bookTicket("economy");
			System.out.println("Revervation added. Thank you, the program will now close.");
			return null;
		}
		return null;
	}

	@SuppressWarnings("resource")
	private void bookTicket(String seatType) throws ClassNotFoundException, SQLException {
		Passenger passenger = new Passenger();
		passenger.setBookingId(booking.getId());
		passenger.setBooking(booking);
		Scanner scanner = null;
		scanner = new Scanner(System.in);
		System.out.println("Enter your first name:");
		passenger.setGivenName(scanner.nextLine());
		System.out.println("Enter your last name:");
		passenger.setFamilyName(scanner.nextLine());
		System.out.println("Enter your date of birth (format: YYYY-MM-DD)");
		passenger.setDateOfBirth(scanner.nextLine());
		System.out.println("Enter your gender:");
		passenger.setGender(scanner.nextLine());
		System.out.println("Enter your address:");
		passenger.setAddress(scanner.nextLine());
		passenger.setSeatType(seatType);
		new Admin().addPassenger(passenger, flight);

	}

	private List<String> buildOptionsMenu() {
		List<String> options = new ArrayList<String>();
		options.add("View flight details");
		FlightSeats seats = flight.getSeats();
		if (seats.getFirstTotal() - seats.getFirstReserved() > 0)
			options.add("First");
		if (seats.getBusinessTotal() - seats.getBusinessReserved() > 0)
			options.add("Business");
		if (seats.getEconomyTotal() - seats.getEconomyReserved() > 0)
			options.add("Economy");

		return options;
	}

}
