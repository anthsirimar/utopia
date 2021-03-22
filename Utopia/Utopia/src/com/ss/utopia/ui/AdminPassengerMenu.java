package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.PassengerDAO;
import com.ss.utopia.entity.Flight;
import com.ss.utopia.entity.Passenger;
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

	private void addPassenger() {
		// TODO Auto-generated method stub
		
	}

	private void updatePassenger() {
		// TODO Auto-generated method stub
		
	}

	private void deletePassenger() {
		// TODO Auto-generated method stub
		
	}

	private void readPassengers() throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new PassengerDAO(new Util().getConnection()).readAll();
		for (Passenger  passenger : passengers) {
			System.out.println(passenger.toString());
		}
	}

}
