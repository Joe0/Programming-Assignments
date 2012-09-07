package com.joepritzel.cis269.assignment1.repo;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.joepritzel.cis269.assignment1.valueobject.AccountData;

/**
 * A basic file based implementation.
 * 
 * @author Joe Pritzel
 * 
 */
public class FileBasedRepo implements AccountRepo {

	/**
	 * The file that must be used.
	 */
	private final File file;

	/**
	 * @param f
	 *            - The file to use.
	 */
	public FileBasedRepo(File f) {
		this.file = f;
	}

	/*
	 * Consider using a memory mapped file. Doing so would make saving and
	 * writing nicer and potentially faster. Though, if memory is concerned we
	 * could stream it, so that the entire file isn't loaded into memory, and
	 * this approach would be the most memory efficient.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.joepritzel.cis269.assignment1.repo.FileBasedRepo#read()
	 * 
	 * @see com.joepritzel.cis269.assignment1.repo.FileBasedRepo#persist()
	 */

	@Override
	public AccountData read() throws IOException {

		// All this array crap needs to be put into it's own class
		// to allow for easily swapping out data structures.
		// But doing so at this would make it seem like a different data
		// structure, making it very unclear what is actually going on.
		// So, I'm leaving it for now, even though it is painful.

		// To make this independent of the data structure everything
		// will be done through a common interface and the implementation
		// will be injected via this classes constructor or the read
		// method itself. Basically, implementing manual dependency injection,
		// using constructor or method injection.

		// All future versions will have these changes, seeing they would be
		// considered 'best practices'. And the only reason it's not being done
		// now is because it would be on the verge of breaking some guidelines
		// in the assignment.

		String[] accountNumbers = new String[1]; // Size must start at > 0.
		double[] balances = new double[1]; // Size must start at > 0.

		int count = 0;
		// This could still be improved if we didn't need to use a random access
		// file.
		try (RandomAccessFile f = new RandomAccessFile(file, "r")) {
			while (true) {
				String acc = f.readUTF();
				double bal = f.readDouble();
				count++;

				// Arrays.copyOf is the fastest way to do this.
				// The array grows very aggressively, to minimize the number of
				// calls to copyOf.
				if (accountNumbers.length <= count) {
					accountNumbers = copyOf(accountNumbers, count * 2);
					balances = copyOf(balances, count * 2);
				}

				accountNumbers[count - 1] = acc;
				balances[count - 1] = bal;
			}
		} catch (EOFException e) {
			// Do nothing, because we expect this...
		}

		// Trim to size.
		if (accountNumbers.length != count) {
			accountNumbers = copyOf(accountNumbers, count);
			balances = copyOf(balances, count);
		}
		return new AccountData(accountNumbers, balances);
	}

	@Override
	public void persist(AccountData data) throws IOException {
		// This could still be improved if we didn't need to use a random access
		// file.
		try (RandomAccessFile f = new RandomAccessFile(file, "rw")) {
			for (int i = 0; i < data.accountNumbers.length; i++) {
				f.writeUTF(data.accountNumbers[i]);
				f.writeDouble(data.balances[i]);
			}
		}

	}

	/**
	 * Creates an array of the given length and copies the data from the
	 * original.
	 * 
	 * @param array
	 *            - The original.
	 * @param length
	 *            - The new length.
	 * @return A new array of given size with the elements of the original.
	 */
	// Should be Array.newInstance, but really this method is essentially
	// Arrays.copyOf but super slow and isn't generic.
	private String[] copyOf(String[] array, int length) {
		String[] a = new String[length];

		for (int i = 0; i < length && i < array.length; i++) {
			a[i] = array[i];
		}

		return a;
	}

	/**
	 * Creates an array of the given length and copies the data from the
	 * original.
	 * 
	 * @param array
	 *            - The original.
	 * @param length
	 *            - The new length.
	 * @return A new array of given size with the elements of the original.
	 */
	// Should be Array.newInstance, but really this method is essentially
	// Arrays.copyOf but super slow and isn't generic.
	private double[] copyOf(double[] array, int length) {
		double[] a = new double[length];

		for (int i = 0; i < length && i < array.length; i++) {
			a[i] = array[i];
		}

		return a;
	}

}