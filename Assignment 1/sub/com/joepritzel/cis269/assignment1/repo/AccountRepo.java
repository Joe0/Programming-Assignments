package com.joepritzel.cis269.assignment1.repo;

import java.io.IOException;

import com.joepritzel.cis269.assignment1.valueobject.AccountData;

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
	 * @return An object containing the data.
	 * @throws IOException
	 *             - Caused by an error that can't be handled appropriately.
	 */
	public AccountData read() throws IOException;

	/**
	 * Persists the given data.
	 * 
	 * @param data
	 *            - The data to persist.
	 * @throws IOException
	 *             - Caused by an error that can't be handled appropriately.
	 */
	public void persist(AccountData data) throws IOException;
}