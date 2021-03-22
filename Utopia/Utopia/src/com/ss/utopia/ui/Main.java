package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Menu currentMenu = new MainMenu();
		Scanner scanner = null;
		int userInput = 0;

		// Main program loop
		do {
			currentMenu.printMenu();
			try {
				scanner = new Scanner(System.in);
				userInput = scanner.nextInt();
				currentMenu = currentMenu.pickMenuOption(userInput);
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Something went wrong with trying to access the database.");
			}
			
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Please enter a valid input");
			}

		} while (currentMenu != null);

		if (scanner != null)
			scanner.close();
	}

}
