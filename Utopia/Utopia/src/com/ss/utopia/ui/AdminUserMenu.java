package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.entity.User;
import com.ss.utopia.service.Admin;
import com.ss.utopia.service.Util;

public class AdminUserMenu extends Menu {

	public AdminUserMenu() {
		menuOptions = Arrays.asList("Add", "Update", "Delete", "Read");
		cancelMessage = "Quit to previous";
	}

	@Override
	public Menu pickMenuOption(int choice) throws ClassNotFoundException, SQLException {
		switch (choice) {
		case 1:
			addUser();
			return this;
		case 2:
			updateUser();
			return this;
		case 3:
			deleteUser();
			return this;
		case 4:
			readUsers();
			return this;
		case 5:
			return previousMenu;
		default:
			System.out.println("Please enter a valid input.");
			return this;
		}
	}

	private void addUser() throws ClassNotFoundException, SQLException {
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the new user's role");
		user.setRoleId(Integer.parseInt(scanner.nextLine()));
		System.out.println("Enter the new user's first name");
		user.setGivenName(scanner.nextLine());
		System.out.println("Enter the new user's last name");
		user.setFamilyName(scanner.nextLine());
		System.out.println("Enter the new user's username");
		user.setUsername(scanner.nextLine());
		System.out.println("Enter the new user's email");
		user.setEmail(scanner.nextLine());
		System.out.println("Enter the new user's password");
		user.setPassword(scanner.nextLine());
		System.out.println("Enter the new user's phone number");
		user.setPhone(scanner.nextLine());
		
		new Admin().addUser(user);
		System.out.println("User created successfully");
	}

	private void updateUser() throws ClassNotFoundException, SQLException {
		User user;
		UserDAO dao = new UserDAO(new Util().getConnection());
		Scanner scanner = new Scanner(System.in);
		String input = "";
		System.out.println("Enter the user's id to update");
		user = dao.readUsersById(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("Enter the user's role, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			user.setRoleId(Integer.parseInt(input));
		
		System.out.println("Enter the user's first name, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			user.setGivenName(input);
		
		System.out.println("Enter the user's last name, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			user.setFamilyName(input);
		
		System.out.println("Enter the user's username, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			user.setUsername(input);
		
		System.out.println("Enter the user's email, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			user.setEmail(input);
		
		System.out.println("Enter the user's password, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			user.setPassword(input);
		
		System.out.println("Enter the user's phone number, or enter nothing to not change it");
		input = scanner.nextLine();
		if(input != "")
			user.setPhone(input);
		
		new Admin().updateUser(user);
		System.out.println("User updated successfully");
	}

	private void deleteUser() throws ClassNotFoundException, SQLException {
		User user;
		UserDAO dao = new UserDAO(new Util().getConnection());
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the user's id to delete");
		user = dao.readUsersById(Integer.parseInt(scanner.nextLine()));
		
		new Admin().deleteUser(user);
		System.out.println("User deleted successfully");
	}

	private void readUsers() throws ClassNotFoundException, SQLException {
		List<User> users = new UserDAO(new Util().getConnection()).readAll();
		for(User user : users) {
			System.out.println(user.toString());
		}

	}

}
