package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class EmployeeMenu extends Menu {

	public EmployeeMenu() {
		String description = "";
		List<String> options = Arrays.asList("Enter Flights You Manage");
		this.setMenuDescription(description);
		this.setMenuOptions(options);
		this.setCancelMessage("Quit to Previous");
	}

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		switch (choice) {
		case 1:
			// Go to flights menu
			FlightsListMenu menu = new FlightsListMenu();
			menu.setPreviousMenu(this);
			return menu;
		case 2:
			// Return to previous
			return this.getPreviousMenu();
		default:
			// Invalid input. Do nothing.
			System.out.println("Please enter a valid input");
			return this;
		}
	}

}
