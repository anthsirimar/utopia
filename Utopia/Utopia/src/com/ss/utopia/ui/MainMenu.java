package com.ss.utopia.ui;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {
	
	protected MainMenu() {
		String description = "Welcome to the Utopia Airlines Management System. Which category of a user are you";
		List<String> options = Arrays.asList("Employee","Administrator","Traveler");
		this.setMenuDescription(description);
		this.setMenuOptions(options);
		this.setCancelMessage("Quit application");
	}

	@Override
	public Menu pickMenuOption(int choice) {
		Menu nextMenu = null;
		switch(choice) {
		case 1:
			//Go to employee menu
			nextMenu = new EmployeeMenu();
			nextMenu.setPreviousMenu(this);
			return nextMenu;
		case 2:
			//Go to admin menu
			System.out.println("admin menu");
			break;
		case 3:
			//Go to traveler menu
			nextMenu = new TravelerMenu();
			nextMenu.setPreviousMenu(this);
			return nextMenu;
		case 4:
			//Quit
			break;
		default:
			//Invalid input. Do nothing.
			System.out.println("Please enter a valid input");
			return this;
		}
		return null;


	}

}
