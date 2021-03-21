package com.ss.utopia.ui;

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
			} catch (Exception e) {
				System.out.println("Please enter a valid input");
			}

		} while (currentMenu != null);

		if (scanner != null)
			scanner.close();
	}

}
