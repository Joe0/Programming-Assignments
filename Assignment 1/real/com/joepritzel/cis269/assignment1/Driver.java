package com.joepritzel.cis269.assignment1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.joepritzel.cis269.assignment1.agg.AccountAggregate;
import com.joepritzel.cis269.assignment1.agg.MappedAccountAggregate;
import com.joepritzel.cis269.assignment1.ann.Print;
import com.joepritzel.cis269.assignment1.menu.Menu;
import com.joepritzel.cis269.assignment1.menu.impl.MainMenu;
import com.joepritzel.cis269.assignment1.repo.FileBasedRepo;

/**
 * This is the 'driver'.
 * 
 * @author Joe Pritzel
 * 
 */
public class Driver {

	/**
	 * @param args
	 *            - The first argument should be the data file to be read.
	 * @throws IOException
	 *             - An exception thrown due to there being an issue reading the
	 *             file.
	 */
	public static void main(String[] args) throws IOException {

		// Use the given file, if one is given.
		File dataFile = null;
		try {
			dataFile = new File(args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No file specified. Defaulting to bank.dat");
			dataFile = new File("bank.dat");
		}

		// Create a new data object using the given file
		AccountAggregate data = new MappedAccountAggregate(new FileBasedRepo(
				dataFile));

		// Creates the main menu.
		Menu menu = new MainMenu(data);

		// Creates a new scanner to read input.
		Scanner in = new Scanner(System.in);

		// Displays the main menu
		System.out.println(menu.display());

		// Continually display and react to menus and input
		while (menu != null) {

			// We only want to display the MainMenu once, so we exclude it.
			if (!(menu instanceof MainMenu)) {
				String s = menu.display();
				if (s != null) {
					if (menu.getClass().isAnnotationPresent(Print.class)) {
						System.out.print(s); // Display the current menu using
												// print.
					} else {
						System.out.println(s); // Display the current menu.
					}
				} else {
					break;
				}
			}
			menu = menu.react(in.nextLine()); // React to the input supplied by
												// the user.
		}

		in.close(); // Close the scanner.
	}
}
