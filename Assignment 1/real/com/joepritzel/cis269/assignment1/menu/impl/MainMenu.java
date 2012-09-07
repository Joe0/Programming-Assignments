package com.joepritzel.cis269.assignment1.menu.impl;

import com.joepritzel.cis269.assignment1.agg.AccountAggregate;
import com.joepritzel.cis269.assignment1.menu.Menu;
import com.joepritzel.cis269.assignment1.util.StringUtil;

/**
 * This is the main menu.
 * 
 * @author Joe Pritzel
 * 
 */
public class MainMenu implements Menu {

	/**
	 * The accounts.
	 */
	private final AccountAggregate accounts;

	/**
	 * @param data
	 *            - The accounts to use.
	 */
	public MainMenu(AccountAggregate data) {
		this.accounts = data;
	}

	@Override
	public String display() {
		return StringUtil.addNewLines("Enter one of the following",
				"1) Deposit", "2) Withdrawal", "3) Display All Accounts",
				"4) Calculate Daily Interest", "5) Exit");
	}

	@Override
	public Menu react(String input) {
		switch (input) {
		case "1":
			return new DepositMenu(this, accounts);
		case "2":
			return new WithdrawlMenu(this, accounts);
		case "3":
			return new DisplayAccountsMenu(this, accounts);
		case "4":
			return new CalcDailyInterestMenu(this, accounts);
		case "5":
			return new ExitMenu(accounts);
		default:
			return new InvalidOptionMenu(this);
		}
	}

}
