package com.ss.utopia.ui;

import java.util.Arrays;
import java.util.List;

public class TravelerMenu extends Menu {

	public TravelerMenu() {
		String description = "";
		List<String> options = Arrays.asList("Book a Ticket","Cancel an Upcoming Trip");
		this.setMenuDescription(description);
		this.setMenuOptions(options);
		this.setCancelMessage("Quit to Previous");
	}
	
	@Override
	public Menu pickMenuOption(int choice) {
		switch(choice) {
		case 1:
			//Book a Ticket
			break;
		case 2:
			//Cancel an Upcoming Trip
		case 3:
			return this.getPreviousMenu();
		default:
			//Invalid input. Do nothing.
			System.out.println("Please enter a valid input");
			return this;
		}

		return null;
	}

}
