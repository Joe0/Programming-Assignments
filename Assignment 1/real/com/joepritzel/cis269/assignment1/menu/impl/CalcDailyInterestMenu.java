package com.joepritzel.cis269.assignment1.menu.impl;

import com.joepritzel.cis269.assignment1.agg.AccountAggregate;
import com.joepritzel.cis269.assignment1.menu.Menu;

/**
 * The menu that calculates daily interest.
 * 
 * @author Joe Pritzel
 * 
 */
public class CalcDailyInterestMenu implements Menu {

	/**
	 * The previous menu.
	 */
	private final Menu prev;

	/**
	 * The accounts to use.
	 */
	private final AccountAggregate accounts;

	/**
	 * @param prev
	 *            - The previous menu.
	 * @param accounts
	 *            - The accounts to be used.
	 */
	public CalcDailyInterestMenu(Menu prev, AccountAggregate accounts) {
		this.prev = prev;
		this.accounts = accounts;
	}

	@Override
	public String display() {

		for (String acc : accounts.getAccountNumbers()) {
			accounts.setBalance(acc, accounts.getBalance(acc) * 1.03);
		}
		return new DisplayAccountsMenu(this, accounts).display();
	}

	@Override
	public Menu react(String input) {
		return prev.react(input);
	}

}
