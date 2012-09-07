package com.joepritzel.cis269.assignment1.repo;

import java.io.IOException;

import com.joepritzel.cis269.assignment1.agg.AccountAggregate;

/**
 * Represents an account repository.
 * 
 * @author Joe Pritzel
 * 
 */
public interface AccountRepo {

	/**
	 * Reads the data from wherever.
	 * 
	 * @param agg
	 *            - The aggregate of accounts.
	 * @return An object containing the data.
	 * @throws IOException
	 *             - Caused by an error that can't be handled appropriately.
	 */
	public AccountAggregate read(AccountAggregate agg) throws IOException;

	/**
	 * Persists the given data.
	 * 
	 * @param data
	 *            - The data to persist.
	 * @throws IOException
	 *             - Caused by an error that can't be handled appropriately.
	 */
	public void persist(AccountAggregate data) throws IOException;
}