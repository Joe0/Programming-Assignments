package com.joepritzel.cis269.assignment1.menu.impl;

import com.joepritzel.cis269.assignment1.agg.AccountAggregate;
import com.joepritzel.cis269.assignment1.menu.Menu;
import com.joepritzel.cis269.assignment1.util.StringUtil;

/**
 * This menu displays the accounts.
 * 
 * @author Joe Pritzel
 * 
 */
public class DisplayAccountsMenu implements Menu {

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
	public DisplayAccountsMenu(Menu prev, AccountAggregate data) {
		this.prev = prev;
		this.accounts = data;
	}

	@Override
	public String display() {
		String s = StringUtil.addNewLine(StringUtil.stars());

		for (String acc : accounts.getAccountNumbers()) {
			s += String.format("Account %s has balance $%.2f%n", acc,
					accounts.getBalance(acc));
		}

		s += StringUtil.stars();
		return s;
	}

	@Override
	public Menu react(String input) {
		return prev.react(input);
	}

}
