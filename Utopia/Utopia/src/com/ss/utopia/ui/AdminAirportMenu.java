package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.entity.Airport;
import com.ss.utopia.service.Admin;
import com.ss.utopia.service.Util;

public class AdminAirportMenu extends Menu {

	public AdminAirportMenu() {
		menuOptions = Arrays.asList("Add", "Update", "Delete", "Read");
		cancelMessage = "Quit to previous";
	}

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		switch (choice) {
		case 1:
			addAirport();
			return this;
		case 2:
			updateAirport();
			return this;
		case 3:
			deleteAirport();
			return this;
		case 4:
			readAirports();
			return this;
		case 5:
			return previousMenu;
		default:
			System.out.println("Please enter a valid input.");
			return this;
		}
	}

	private void updateAirport() throws ClassNotFoundException, SQLException {
		Airport airport = new Airport();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter three-digit airport code");
		airport.setAirportCode(scanner.nextLine());
		System.out.println("Enter airport city");
		airport.setCity(scanner.nextLine());
		new Admin().updateAirport(airport);
		System.out.println("Successfully updated: " + airport);
	}
	
	private void deleteAirport() throws ClassNotFoundException, SQLException {
		Airport airport = new Airport();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter three-digit airport code of airport to delete");
		airport.setAirportCode(scanner.nextLine());
		new Admin().deleteAirport(airport);
		System.out.println("Successfully deleted: " + airport.getAirportCode());
	}

	private void addAirport() throws ClassNotFoundException, SQLException {
		Airport airport = new Airport();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter three-digit airport code");
		airport.setAirportCode(scanner.nextLine());
		System.out.println("Enter airport city");
		airport.setCity(scanner.nextLine());
		new Admin().addAirport(airport);
		System.out.println("Successfully added: " + airport);
	}

	private void readAirports() throws ClassNotFoundException, SQLException {
		List<Airport> airports = new AirportDAO(new Util().getConnection()).readAll();
		for (Airport airport : airports) {
			System.out.println(airport.toString());
		}
	}

}
