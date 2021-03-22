package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;

public class AdminMenu extends Menu {

	public AdminMenu() {
		String s = "Add/Update/Delete/Read";
		this.menuOptions  = Arrays.asList(s+" Flights", s+" Seats",
				s+" Passengers", s+" Airports", s+" Users",
				 "Over-ride trip cancellation for a ticket");
		this.cancelMessage = "Quit to previous";
	}
	
	
	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		Menu nextMenu;
		
		switch(choice) {
		case 1:
			nextMenu = new AdminFlightMenu();
			nextMenu.setPreviousMenu(this);
			return nextMenu;
		case 2:
			nextMenu = new AdminSeatsMenu();
			nextMenu.setPreviousMenu(this);
			return nextMenu;
		case 3:
			nextMenu = new AdminPassengerMenu();
			nextMenu.setPreviousMenu(this);
			return nextMenu;
		case 4:
			nextMenu = new AdminAirportMenu();
			nextMenu.setPreviousMenu(this);
			return nextMenu;
		case 5:
			nextMenu = new AdminUserMenu();
			nextMenu.setPreviousMenu(this);
			return nextMenu;
		case 6:
			//Override cancellation
			return this;
		case 7:
			return this.previousMenu;
		default:
			System.out.println("Please pick a valid input");
			return this;
		}
	}

}
