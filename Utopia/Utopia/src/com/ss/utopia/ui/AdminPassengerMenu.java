package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.PassengerDAO;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Passenger;
import com.ss.utopia.service.Admin;
import com.ss.utopia.service.Util;

public class AdminPassengerMenu extends Menu {

	public AdminPassengerMenu() {
		menuOptions = Arrays.asList("Add", "Update", "Delete", "Read");
		cancelMessage = "Quit to previous";
	}

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		switch(choice) {
		case 1:
			addPassenger();
			return this;
		case 2:
			updatePassenger();
			return this;
		case 3:
			deletePassenger();
			return this;
		case 4:
			readPassengers();
			return this;
		case 5:
			return previousMenu;
		default:
			System.out.println("Please enter a valid input.");
			return this;
		}
	}

	@SuppressWarnings("resource")
	private void addPassenger() throws NumberFormatException, ClassNotFoundException, SQLException {
		Flight flight;
		Passenger passenger = new Passenger();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the flight id to of the flight to add this passenger to.");
		flight = new FlightDAO(new Util().getConnection()).readFlightsById(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Enter the passenger's booking id");
		passenger.setBookingId(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Enter the passenger's first name");
		passenger.setGivenName(scanner.nextLine());
		
		System.out.println("Enter the passenger's last name");
		passenger.setFamilyName(scanner.nextLine());
		
		System.out.println("Enter the passenger's date of birth (YYYY-MM-DD)");
		passenger.setDateOfBirth(scanner.nextLine());
		
		System.out.println("Enter the passenger's gender");
		passenger.setGender(scanner.nextLine());
		
		System.out.println("Enter the passenger's address");
		passenger.setAddress(scanner.nextLine());
		
		System.out.println("Enter the passenger's seat type (first, business, economy");
		passenger.setSeatType(scanner.nextLine());
		
		new Admin().addPassenger(passenger, flight);
		System.out.println("Passenger added to flight successfully");
		
	}

	@SuppressWarnings("resource")
	private void updatePassenger() throws ClassNotFoundException, SQLException {
		System.out.println("Enter the id of the passenger to update");
		Scanner scanner = new Scanner(System.in);
		String input = "";
		Passenger passenger = new PassengerDAO(new Util().getConnection()).readPassengerById(Integer.parseUnsignedInt(scanner.nextLine()));
		
		System.out.println("Enter passenger's first name, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			passenger.setGivenName(input);
		
		System.out.println("Enter passenger's last name, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			passenger.setFamilyName(input);
		
		System.out.println("Enter passenger's date of birth (YYYY-MM-DD), or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			passenger.setDateOfBirth(input);
		
		System.out.println("Enter passenger's gender, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			passenger.setGender(input);
		
		System.out.println("Enter passenger's address, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			passenger.setAddress(input);
		
		new Admin().updatePassenger(passenger);
		System.out.println("Passenger updated successfully");
	}

	@SuppressWarnings("resource")
	private void deletePassenger() throws NumberFormatException, ClassNotFoundException, SQLException {
		Flight flight;
		Passenger passenger;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the flight id for which this passenger is booked for");
		flight = new FlightDAO(new Util().getConnection()).readFlightsById(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Enter the passenger's id");
		passenger = new PassengerDAO(new Util().getConnection()).readPassengerById(Integer.parseInt(scanner.nextLine()));
		
		new Admin().removePassenger(passenger, flight);
		System.out.println("Passenger removed successfully");
	}

	private void readPassengers() throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new PassengerDAO(new Util().getConnection()).readAll();
		for (Passenger  passenger : passengers) {
			System.out.println(passenger.toString());
		}
	}

}
