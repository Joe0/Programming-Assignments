package com.joepritzel.cis269.assignment1.agg;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.joepritzel.cis269.assignment1.repo.AccountRepo;

/**
 * This is an account aggregate that uses a map.
 * 
 * @author Joe Pritzel
 * 
 */
public class MappedAccountAggregate extends AccountAggregate {

	/**
	 * Map backing this aggregate.
	 */
	private final Map<String, Double> accounts = new HashMap<String, Double>();

	public MappedAccountAggregate(AccountRepo repo) throws IOException {
		super(repo);
	}

	@Override
	public Set<String> getAccountNumbers() {
		return accounts.keySet();
	}

	@Override
	public double getBalance(String accountNumber) {
		try {
			return accounts.get(accountNumber);
		} catch (NullPointerException | ClassCastException e) {
			throw new IllegalArgumentException("No such account.");
		}
	}

	@Override
	public void setBalance(String accountNumber, double balance) {
		try {
			accounts.put(accountNumber, balance);
		} catch (RuntimeException e) {
			throw new IllegalArgumentException("No such account.");
		}
	}

}
