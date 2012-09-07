package com.joepritzel.cis269.assignment1.menu.impl;

import com.joepritzel.cis269.assignment1.agg.AccountAggregate;
import com.joepritzel.cis269.assignment1.ann.Print;
import com.joepritzel.cis269.assignment1.menu.Menu;

/**
 * The menu that deposits funds.
 * 
 * @author Joe Pritzel
 * 
 */
@Print
public class DepositMenu implements Menu {

	/**
	 * The previous menu.
	 */
	protected final Menu prev;

	/**
	 * The accounts to use.
	 */
	protected final AccountAggregate accounts;

	/**
	 * The account to deposit funds into.
	 */
	protected String acc;

	/**
	 * The amount to deposit into the account.
	 */
	protected double amount;

	/**
	 * @param prev
	 *            - The previous menu.
	 * @param accounts
	 *            - The accounts to be used.
	 */
	public DepositMenu(Menu prev, AccountAggregate data) {
		this.prev = prev;
		this.accounts = data;
	}

	@Override
	public String display() {
		if (acc == null) {
			return "Account number: ";
		} else {
			return "Amount of deposit: ";
		}
	}

	@Override
	public Menu react(String input) {

		if (acc == null) {
			acc = input;
			try {
				amount = accounts.getBalance(acc);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				acc = null;
			}
		} else {
			try {
				amount += Double.parseDouble(input);
				accounts.setBalance(acc, amount);
				acc = null;
				amount = 0;
				return prev;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number...");
			}
		}
		return this;
	}
}
