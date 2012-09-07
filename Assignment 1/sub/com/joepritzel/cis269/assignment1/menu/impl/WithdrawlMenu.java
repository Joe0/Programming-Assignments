package com.joepritzel.cis269.assignment1.menu.impl;

import com.joepritzel.cis269.assignment1.agg.AccountAggregate;
import com.joepritzel.cis269.assignment1.ann.Print;
import com.joepritzel.cis269.assignment1.menu.Menu;

/**
 * This is the withdraw menu.
 * 
 * @author Joe Pritzel
 * 
 */
@Print
public class WithdrawlMenu extends DepositMenu { // Withdrawing is just a
													// negative deposit.

	/**
	 * @param prev
	 *            - The previous menu.
	 * @param accounts
	 *            - The accounts to use.
	 */
	public WithdrawlMenu(Menu prev, AccountAggregate accounts) {
		super(prev, accounts);
	}

	@Override
	public String display() {
		if (acc == null) {
			return "Account number: ";
		} else {
			return "Amount of withdrawl: ";
		}
	}

	@Override
	public Menu react(String input) {
		if (acc != null) {
			return super.react("-" + input);
		}
		return super.react(input);
	}

}
