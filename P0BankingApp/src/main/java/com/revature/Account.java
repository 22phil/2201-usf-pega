package com.revature;

public interface Account {
	
	// Every interface should have withdraw and deposit methods
	public void withdraw(Customer customer, double balance, IO io);
	public void deposit(Customer customer, double balance, IO io);

}
