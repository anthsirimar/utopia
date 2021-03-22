package com.ss.utopia.ui;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;


import com.ss.utopia.entity.FlightSeats;
import com.ss.utopia.service.Admin;


public class UpdateSeatsMenu extends Menu {

	private FlightSeats seats;

	public UpdateSeatsMenu(FlightSeats seats) {
		this.seats = seats;
		this.menuDescription = "Pick the Seat Class you want to add seats of, to your flight:";
		this.menuOptions = Arrays.asList("First", "Business", "Economy");
		this.cancelMessage = "Quit to cancel operation";
	}

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		switch (choice) {
		
		case 1:
			//First class
			System.out.println("Existing number of total first class seats: " + seats.getFirstTotal());
			seats.setFirstTotal(this.getUserInput());
			new Admin().updateFlightSeats(seats);
			System.out.println("Seats info updated successfully");
			return this.previousMenu;
		case 2:
			//Business class
			System.out.println("Existing number of total business seats: " + seats.getBusinessTotal());
			seats.setBusinessTotal(this.getUserInput());
			new Admin().updateFlightSeats(seats);
			System.out.println("Seats info updated successfully");
			return this.previousMenu;
		case 3:
			//Economy class
			System.out.println("Existing number of total economy class seats: " + seats.getEconomyTotal());
			seats.setEconomyTotal(this.getUserInput());
			new Admin().updateFlightSeats(seats);
			System.out.println("Seats info updated successfully");
			return this.previousMenu;
		case 4:
			//Quit
			return this.previousMenu;
		default:
			System.out.println("Please enter a valid input");
			return this;
		}
	}



	private int getUserInput() {
		System.out.println("Enter a new number of seats:");
		Scanner scanner = null;
		int userInput = 0;

		try {
			scanner = new Scanner(System.in);
			userInput = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter a valid input");
		}
		return userInput;
	}

}
