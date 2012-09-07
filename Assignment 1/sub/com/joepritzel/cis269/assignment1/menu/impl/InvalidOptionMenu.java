package com.joepritzel.cis269.assignment1.menu.impl;

import com.joepritzel.cis269.assignment1.menu.Menu;

/**
 * This menu is used when you attempt to pick an invalid option.
 * 
 * @author Joe Pritzel
 * 
 */
public class InvalidOptionMenu implements Menu {

	/**
	 * The response.
	 */
	private final String response;

	/**
	 * The previous menu.
	 */
	private final Menu next;

	/**
	 * Uses a default response and ends.
	 */
	public InvalidOptionMenu() {
		response = "You have selected an invalid option.";
		next = null;
	}

	/**
	 * Uses a default responds and continues with the next menu.
	 * 
	 * @param m
	 *            - The next menu to display.
	 */
	public InvalidOptionMenu(Menu m) {
		response = "You have selected an invalid option. Try again."
				+ System.getProperty("line.separator") + m.display();
		next = m;
	}

	@Override
	public String display() {
		return response;
	}

	@Override
	public Menu react(String input) {
		if (next == null) {
			return null;
		}
		return next.react(input);
	}

}
