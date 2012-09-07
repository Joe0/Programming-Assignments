package com.joepritzel.cis269.assignment1.search;

/**
 * A linear search.
 * 
 * @author Joe Pritzel
 * 
 */
public class LinearSearchStrategy implements
		SearchStrategy<String[], String, Integer> {

	/**
	 * @return The index of the account or -1 if not found.
	 */
	@Override
	public Integer find(String[] data, String accNumber) {
		// Basic linear search. =(
		for (int i = 0; i < data.length; i++) {
			if (data[i].equals(accNumber)) {
				return i;
			}
		}
		return -1;
	}

}
