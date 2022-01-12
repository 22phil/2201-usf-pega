package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admin implements Account{
	
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
	// Constructor
	public Admin() {
	}
	
	// Approve/deny customer account
	public void setApprovalStatus(Customer customer, boolean bool, IO io) {
				
		String oldLedgerEntry = io.ledgerEntry(customer);
		customer.setApprovalStatus(bool);
				
		// Update ledger file with new customer ledger entry
		io.updateFile(oldLedgerEntry, io.ledgerEntry(customer));
        logger.info("Admin setApprovalStatus " + bool + ": " + customer.getUsername() + ", " + customer.getPassword() + ", " + customer.getBalance() + ", " + customer.getApprovalStatus());

	}
	
	// Withdraw from customer account
	public void withdraw(Customer customer, double amount, IO io) {
		
		if (customer.getApprovalStatus() == false) {
			System.out.println("Error: Account is not approved.");
		} else if (customer.getBalance() < amount) {
			System.out.println("Error: Insufficient funds."); 
		} else {
			String oldLedgerEntry = io.ledgerEntry(customer);
			customer.setBalance(customer.getBalance() - amount);
			
			// Update ledger file with new customer ledger entry
	        io.updateFile(oldLedgerEntry, io.ledgerEntry(customer));
	        logger.info("Admin withdraw " + amount + ": " + customer.getUsername() + ", " + customer.getPassword() + ", " + customer.getBalance() + ", " + customer.getApprovalStatus());
	        System.out.println("Successfully withdrew " + amount + "$");
		}
	}
	
	// Deposit to customer account
	public void deposit(Customer customer, double amount, IO io) {
		
		if (customer.getApprovalStatus() == false) {
			System.out.println("Error: Account is not approved.");
		} else {
			String oldLedgerEntry = io.ledgerEntry(customer);
			customer.setBalance(customer.getBalance() + amount);
	        
			// Update ledger file with new customer ledger entry
	        io.updateFile(oldLedgerEntry, io.ledgerEntry(customer));
	        logger.info("Admin deposit " + amount + ": " + customer.getUsername() + ", " + customer.getPassword() + ", " + customer.getBalance() + ", " + customer.getApprovalStatus());
	        System.out.println("Successfully deposited " + amount + "$");
		}
	}
	
	// Delete customer from ledger
	public void deleteAccount(Customer customer, IO io) {
			
		String oldLedgerEntry = io.ledgerEntry(customer);
			
		// Update ledger
		io.updateFile(oldLedgerEntry, "null:null:0.0:false");
        logger.info("Admin deleted: " + customer.getUsername() + ", " + customer.getPassword() + ", " + customer.getBalance() + ", " + customer.getApprovalStatus());

	}
	
}
