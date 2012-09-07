package com.joepritzel.cis269.assignment1.menu.impl;

import java.io.IOException;

import com.joepritzel.cis269.assignment1.agg.AccountAggregate;
import com.joepritzel.cis269.assignment1.menu.Menu;

/**
 * Exits...
 * 
 * @author Joe Pritzel
 * 
 */
public class ExitMenu implements Menu {

	/**
	 * The accounts to use.
	 */
	private final AccountAggregate accounts;

	/**
	 * @param accounts
	 *            - The accounts to be used.
	 */
	public ExitMenu(AccountAggregate data) {
		this.accounts = data;
	}

	@Override
	public String display() {
		try {
			accounts.persist();
		} catch (IOException e) {
			throw new RuntimeException("Unable to save data.");
		}
		return null;
	}

	@Override
	public Menu react(String input) {
		return null;
	}

}
