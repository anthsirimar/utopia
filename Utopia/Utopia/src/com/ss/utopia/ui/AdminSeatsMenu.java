package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.ss.utopia.dao.FlightSeatsDAO;
import com.ss.utopia.entity.FlightSeats;
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
			return this;
		case 2:
			return this;
		case 3:
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
	
	private void readSeats() throws ClassNotFoundException, SQLException {
		List<FlightSeats> seats = new FlightSeatsDAO(new Util().getConnection()).readAll();
		for(FlightSeats s : seats) {
			System.out.println(s.toString());
		}
	}

}
