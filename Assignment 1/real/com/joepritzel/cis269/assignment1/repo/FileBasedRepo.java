package com.joepritzel.cis269.assignment1.repo;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.joepritzel.cis269.assignment1.agg.AccountAggregate;

/**
 * A basic file based implementation.
 * 
 * @author Joe Pritzel
 * 
 */
public class FileBasedRepo implements AccountRepo {

	/**
	 * The path that must be used.
	 */
	private final File file;

	/**
	 * @param f
	 *            - The file to use.
	 */
	public FileBasedRepo(File f) {
		this.file = f;
	}

	@Override
	public AccountAggregate read(AccountAggregate accounts) throws IOException {
		try (RandomAccessFile f = new RandomAccessFile(file, "r")) {
			while (true) {
				accounts.setBalance(f.readUTF(), f.readDouble());
			}
		} catch (EOFException e) {
			// Do nothing, because we expect this...
		}
		return accounts;
	}

	@Override
	public void persist(AccountAggregate data) throws IOException {
		try (RandomAccessFile f = new RandomAccessFile(file, "rw")) {
			for (String acc : data.getAccountNumbers()) {
				f.writeUTF(acc);
				f.writeDouble(data.getBalance(acc));
			}
		}
	}

}