package com.joepritzel.cis269.assignment1.agg;

import java.io.IOException;
import java.util.Set;

import com.joepritzel.cis269.assignment1.repo.AccountRepo;

/**
 * This is a aggregate of accounts.
 * 
 * @author Joe Pritzel
 * 
 */
public abstract class AccountAggregate {

	/**
	 * The repo that must be used.
	 */
	private final AccountRepo repo;

	/**
	 * @param repo
	 *            - The repo to use.
	 * @param strat
	 *            - The {@link SearchStrategy} to use.
	 * @throws IOException
	 *             - Thrown when there is no appropriate way to handle the
	 *             exception.
	 */
	public AccountAggregate(AccountRepo repo) throws IOException {
		this.repo = repo;
	}

	/**
	 * @return A set of account numbers.
	 */
	public abstract Set<String> getAccountNumbers();

	/**
	 * @param accountNumber
	 *            - The account number to get the balance of.
	 * @return The balance of the given account.
	 * 
	 * @throws IllegalArgumentException
	 *             - Thrown when there is no account found.
	 */
	public abstract double getBalance(String accountNumber);

	/**
	 * Sets the balance to the given number for the account given.
	 * 
	 * @param accountNumber
	 *            - The account number of the account.
	 * @param balance
	 *            - The new balance of the account.
	 * @throws IllegalArgumentException
	 *             - Thrown when there is no account found.
	 */
	public abstract void setBalance(String accountNumber, double balance);

	/**
	 * Persists accounts.
	 * 
	 * @throws IOException
	 *             - Thrown when there is an exception that is unable to be
	 *             appropriately handled.
	 */
	public void persist() throws IOException {
		repo.persist(this);
	}

}
