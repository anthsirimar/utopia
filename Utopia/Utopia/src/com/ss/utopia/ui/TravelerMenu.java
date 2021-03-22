package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.ss.utopia.entity.Booking;

public class TravelerMenu extends Menu {

	Booking booking;

	public TravelerMenu(Booking booking) {
		this.booking = booking;
		String description = "";
		List<String> options = Arrays.asList("Book a Ticket", "Cancel an Upcoming Trip");
		this.setMenuDescription(description);
		this.setMenuOptions(options);
		this.setCancelMessage("Quit to Previous");
	}

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		FlightsListTravelerMenu nextMenu;
		switch (choice) {
		case 1:
			// Book a Ticket
			nextMenu = new FlightsListTravelerMenu(booking);
			nextMenu.setPreviousMenu(this);
			nextMenu.setMenuDescription("Pick the flight you want to book a ticket for");
			return nextMenu;
		case 2:
			// Cancel an Upcoming Trip

			nextMenu = new FlightsListTravelerMenu(booking);
			nextMenu.setPreviousMenu(this);
			nextMenu.setMenuDescription("Pick the flight for which you want to cancel your reservation");
			nextMenu.addingPassenger(false);
			return nextMenu;

		case 3:
			return this.getPreviousMenu();
		default:
			// Invalid input. Do nothing.
			System.out.println("Please enter a valid input");
			return this;
		}

	}

}
