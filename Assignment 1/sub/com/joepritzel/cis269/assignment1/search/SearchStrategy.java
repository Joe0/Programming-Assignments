package com.joepritzel.cis269.assignment1.search;

/**
 * An interface for searching strategies.
 * 
 * @author Joe Pritzel
 * 
 * @param <AccColl>
 *            - The type of collection that holds the accounts.
 * @param <Acc>
 *            - The type of account.
 * @param <Id>
 *            - The type that represents the id of an account.
 */
public interface SearchStrategy<AccColl, Acc, Id> {

	/**
	 * Attempts to find the given account number.
	 * 
	 * @param data
	 *            - The set of data to search.
	 * @param accountNumber
	 *            - The account number to find.
	 * @return The account.
	 */
	// We will need to change this... We will use generics later on.
	public Id find(AccColl data, Acc accountNumber);
}
