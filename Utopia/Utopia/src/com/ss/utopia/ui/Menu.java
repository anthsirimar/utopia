package com.ss.utopia.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public abstract class Menu {

	protected String menuDescription = "";
	protected List<String> menuOptions = new ArrayList<String>();
	protected Menu previousMenu = null;
	protected String cancelMessage;
	

	protected Menu() {
	}
	
//--------Getters and setters---------
	public String getMenuDescription() {
		return menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public List<String> getMenuOptions() {
		return menuOptions;
	}


	public void setMenuOptions(List<String> menuOptions) {
		this.menuOptions = menuOptions;
	}
	
	public Menu getPreviousMenu() {
		return previousMenu;
	}
	public void setPreviousMenu(Menu previousMenu) {
		this.previousMenu = previousMenu;
	}
	
	public String getCancelMessage() {
		return cancelMessage;
	}

	public void setCancelMessage(String cancelMessage) {
		this.cancelMessage = cancelMessage;
	}
	
//---------------------------
	
	public abstract Menu pickMenuOption (int choice) throws ClassNotFoundException, SQLException;
	
	public void printMenu() {
		System.out.println(menuDescription);
		
		int i = 1;
		for(String option : menuOptions) {
			System.out.println(i + ") " + option);
			i++;
		}
		System.out.println(i + ") " + cancelMessage);
	}
}
