package com.joepritzel.cis269.assignment1.agg;

import java.io.IOException;

import com.joepritzel.cis269.assignment1.repo.AccountRepo;
import com.joepritzel.cis269.assignment1.search.SearchStrategy;
import com.joepritzel.cis269.assignment1.valueobject.AccountData;

/**
 * This is a aggregate of accounts.
 * 
 * @author Joe Pritzel
 * 
 */
public class AccountAggregate {

	/**
	 * The repo that must be used.
	 */
	private final AccountRepo repo;

	/**
	 * The account data.
	 */
	private final AccountData data;

	/**
	 * The strategy that must be used to find an account.
	 */
	private final SearchStrategy<String[], String, Integer> searchStrategy;

	/**
	 * @param repo
	 *            - The repo to use.
	 * @param strat
	 *            - The {@link SearchStrategy} to use.
	 * @throws IOException
	 *             - Thrown when there is no appropriate way to handle the
	 *             exception.
	 */
	public AccountAggregate(AccountRepo repo,
			SearchStrategy<String[], String, Integer> strat) throws IOException {
		this.repo = repo;
		this.data = repo.read();
		this.searchStrategy = strat;
	}

	/**
	 * @return A list of account numbers.
	 */
	public String[] getAccountNumbers() { // This signature is potentially going
											// to need to be changed once
											// we improve this.
		return data.accountNumbers;
	}

	/**
	 * @param accountNumber
	 *            - The account number to get the balance of.
	 * @return The balance of the given account.
	 */
	public double getBalance(String accountNumber) {
		try {
			return data.balances[searchStrategy.find(getAccountNumbers(),
					accountNumber)];
		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("No such account.");
		}
	}

	/**
	 * Sets the balance to the given number for the account given.
	 * 
	 * @param accountNumber
	 *            - The account number of the account.
	 * @param balance
	 *            - The new balance of the account.
	 */
	public void setBalance(String accountNumber, double balance) {
		try {
			data.balances[searchStrategy.find(getAccountNumbers(),
					accountNumber)] = balance;
		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("No such account.");
		}
	}

	/**
	 * Persists accounts.
	 * 
	 * @throws IOException
	 *             - Thrown when there is an exception that is unable to be
	 *             appropriately handled.
	 */
	public void persist() throws IOException {
		repo.persist(data);
	}

}
