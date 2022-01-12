package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Customer implements Account{
	
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
	private String username;
	private String password;
	private double balance = 0;
	private boolean approvalStatus;

	// Constructor
	public Customer(String username, String password, IO io) {
		
		this.username = username;
		this.password = password;
		io.writeToFile(this);
        logger.info("Customer created: " + this.username + ", " + this.password + ", " + this.balance + ", " + this.approvalStatus);

	}
	
	// Overloaded constructor
	public Customer(String username, String password, double balance, boolean approvalStatus) {
		
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.approvalStatus = approvalStatus;
	}
	
	// Customer withdraw method
	public void withdraw(Customer customer, double amount, IO io) {
		
		if (customer.getApprovalStatus() == false) {
			System.out.println("Error: Account is not approved.");
		} else if (amount < 0){
			System.out.println("Error: Amount must be positive.");
		} else if (customer.getBalance() < amount) {
			System.out.println("Error: Insufficient funds."); 
		} else {
			String oldLedgerEntry = io.ledgerEntry(customer);
			customer.setBalance(customer.getBalance() - amount);
			
			// Update ledger file with new customer ledger entry
	        io.updateFile(oldLedgerEntry, io.ledgerEntry(customer));
	        logger.info("Customer withdraw " + amount + ": " + customer.username + ", " + customer.password + ", " + customer.balance + ", " + customer.approvalStatus);
	        System.out.println("Successfully withdrew " + amount + "$ from " + customer.getUsername());
		}
		
	}
	
	// Customer deposit method
	public void deposit(Customer customer, double amount, IO io) {
		
		if (customer.getApprovalStatus() == false) {
			System.out.println("Error: Account is not approved.");
		} else if (amount < 0) {
			System.out.println("Error: Amount must be positive.");
		} else {
			String oldLedgerEntry = io.ledgerEntry(customer);
			customer.setBalance(customer.getBalance() + amount);
	        
			// Update ledger file with new customer ledger entry
	        io.updateFile(oldLedgerEntry, io.ledgerEntry(customer));
	        logger.info("Customer deposit " + amount + ": " + customer.username + ", " + customer.password + ", " + customer.balance + ", " + customer.approvalStatus);
	        System.out.println("Successfully deposited " + amount + "$ to " + customer.getUsername());
		}
		
	}
	
	// Getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	

}
