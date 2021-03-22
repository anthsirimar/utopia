package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.dao.FlightSeatsDAO;
import com.ss.utopia.entity.FlightSeats;
import com.ss.utopia.service.Admin;
import com.ss.utopia.service.Util;

public class AdminSeatsMenu extends Menu {

	public AdminSeatsMenu() {
		menuOptions = Arrays.asList("Add", "Update", "Delete", "Read");
		cancelMessage = "Quit to previous";
	}

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		switch(choice) {
		case 1:
			System.out.println("To create a new flightSeats entry, create a new Flight");
			return this;
		case 2:
			updateSeats();
			return this;
		case 3:
			System.out.println("To delete flightSeats entry, delete its corresponding Flight");
			return this;
		case 4:
			readSeats();
			return this;
		case 5:
			return previousMenu;
		default:
			System.out.println("Please enter a valid input.");
			return this;
		}
	}
	
	@SuppressWarnings("resource")
	private void updateSeats() throws NumberFormatException, ClassNotFoundException, SQLException {
		FlightSeats seats;
		FlightSeatsDAO dao = new FlightSeatsDAO(new Util().getConnection());
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the new user's role");
		String input = "";
		System.out.println("Enter the flight ID associated with these seats");
		seats = dao.readFlightSeatsByFlightId(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Enter the new total first class seats, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			seats.setFirstTotal(Integer.parseInt(input));
		
		System.out.println("Enter the new reserved first class seats, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			seats.setFirstReserved(Integer.parseInt(input));
		
		System.out.println("Enter the new price of a first class seat, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			seats.setFirstPrice(Float.parseFloat(input));
		
		System.out.println("Enter the new total business class seats, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			seats.setBusinessTotal(Integer.parseInt(input));
		
		System.out.println("Enter the new reserved business class seats, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			seats.setBusinessReserved(Integer.parseInt(input));
		
		System.out.println("Enter the new price of a business class seat, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			seats.setBusinessPrice(Float.parseFloat(input));
		
		System.out.println("Enter the new total economy class seats, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			seats.setEconomyTotal(Integer.parseInt(input));
		
		System.out.println("Enter the new reserved economy class seats, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			seats.setEconomyReserved(Integer.parseInt(input));
		
		System.out.println("Enter the new price of an economy class seat, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			seats.setEconomyPrice(Float.parseFloat(input));
		
		new Admin().updateFlightSeats(seats);
		System.out.println("Flight seat information updated successfully");
		
	}

	private void readSeats() throws ClassNotFoundException, SQLException {
		List<FlightSeats> seats = new FlightSeatsDAO(new Util().getConnection()).readAll();
		for(FlightSeats s : seats) {
			System.out.println(s.toString());
		}
	}

}
