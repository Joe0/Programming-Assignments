package com.joepritzel.cis269.assignment1.valueobject;

/**
 * Represents the accounts.
 * 
 * @author Joe Pritzel
 * 
 */
public class AccountData {

	/**
	 * The account numbers.
	 */
	public final String[] accountNumbers;

	/**
	 * The balances.
	 */
	public final double[] balances;

	public AccountData(String[] accountNumbers, double[] balances) {
		this.accountNumbers = accountNumbers;
		this.balances = balances;
	}

}
