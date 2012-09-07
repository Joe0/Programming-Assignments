package com.joepritzel.cis269.assignment1.util;

/**
 * A utility for all things String.
 * 
 * @author Joe Pritzel
 * 
 */
public class StringUtil {

	private static final String newLine = System.getProperty("line.separator");

	/**
	 * Adds new lines between all arguments.
	 * 
	 * @param args
	 *            - The things to add new lines between.
	 * @return A string with new lines between all arguments.
	 */
	public static String addNewLines(String... args) {
		// Uses a StringBuilder instead of constantly calling addNewLine because
		// it's faster this way. Not using it would create a StringBuilder
		// for each new line we wanted to add.
		StringBuilder sb = new StringBuilder();
		for (String s : args) {
			sb.append(s).append(newLine);
		}
		sb.delete(sb.length() - newLine.length(), sb.length());
		return sb.toString();
	}

	/**
	 * A string of 'stars'.
	 * 
	 * @return "*********************************"
	 */
	public static String stars() {
		return "*********************************";
	}

	/**
	 * Adds a new line to the given string.
	 * 
	 * @param string
	 *            - The string to add a new line to.
	 * @return A string with a new line on the end.
	 */
	public static String addNewLine(String string) {
		return string + newLine;
	}

}
