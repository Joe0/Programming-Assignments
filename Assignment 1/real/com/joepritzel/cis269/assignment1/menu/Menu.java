package com.joepritzel.cis269.assignment1.menu;

/**
 * An interface for menus.
 * 
 * @author Joe Pritzel
 * 
 */
public interface Menu {

	/**
	 * When null is returned, the program will terminate.
	 * 
	 * @return A string representation of the menu.
	 */
	public String display();

	/**
	 * Reacts to a given input. Terminal nodes that are not meant to end the
	 * program should call the react method of the menu that the current menu
	 * was accessed by. If they are meant to terminate the program, return null.
	 * 
	 * @param input
	 *            - The input.
	 * @return A menu that acts as a response to the given input.
	 */
	public Menu react(String input);
}
