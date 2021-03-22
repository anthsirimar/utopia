package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.service.Util;

public class MainMenu extends Menu {

	protected MainMenu() {
		String description = "Welcome to the Utopia Airlines Management System. Which category of a user are you";
		List<String> options = Arrays.asList("Employee", "Administrator", "Traveler");
		this.setMenuDescription(description);
		this.setMenuOptions(options);
		this.setCancelMessage("Quit application");
	}

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		Menu nextMenu = null;
		switch (choice) {
		case 1:
			// Go to employee menu
			nextMenu = new EmployeeMenu();
			nextMenu.setPreviousMenu(this);
			return nextMenu;
		case 2:
			// Go to admin menu
			nextMenu = new AdminMenu();
			nextMenu.setPreviousMenu(this);
			return nextMenu;
		case 3:
			// Go to traveler menu
			Booking booking = checkIfValidTraveler();
			if(booking == null)
				return this;
			nextMenu = new TravelerMenu(booking);
			nextMenu.setPreviousMenu(this);
			return nextMenu;
		case 4:
			// Quit
			return null;
		default:
			// Invalid input. Do nothing.
			System.out.println("Please enter a valid input");
			return this;
		}

	}

	private Booking checkIfValidTraveler() {
		Booking booking = null;
		try {
			booking = confirmPassengerConfirmationCode();
			if (booking==null) {
				System.out.println("Not a valid confirmation code");
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return booking;
	}

	private Booking confirmPassengerConfirmationCode() throws ClassNotFoundException, SQLException {
		System.out.println("Enter your Membership/Confirmation Number");
		Scanner scanner = null;
		String userInput = "";

		try {
			scanner = new Scanner(System.in);
			userInput = scanner.next();
		} catch (Exception e) {
			System.out.println("Please enter a valid input");
		}

		List<Booking> bookings = new BookingDAO(new Util().getConnection()).readBookingByConfirmationCode(userInput);
			if (bookings.isEmpty())// || bookings.get(0).getIsActive())
				return null;
		return bookings.get(0);
	}

}
