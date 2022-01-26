package com.revature.models;

import com.revature.dao.CustomerDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admin implements Account{
	
	private static final Logger logger = LogManager.getLogger(Admin.class);
	
	// Constructor
	public Admin() {
	}
	
	// Approve/deny customer account
	public void setApprovalStatus(Customer customer, boolean bool, CustomerDao dao) {
		
		if (customer.getUsername() == null) {
			System.out.println("Error occurred.");
		} else if (customer.getUsername().equals(null)) {
			System.out.println("Error occurred.");
		} else {
			customer.setApprovalStatus(bool);
			
			// Update customer database
			dao.updateCustomer(customer);
	        logger.info("Admin setApprovalStatus " + bool + ": " + customer.toString());
	        System.out.println("Changed approval status of " + customer.getUsername() + " to " + customer.getApprovalStatus());
		}
	}
	
	// Withdraw from customer account
	public void withdraw(Customer customer, double amount, CustomerDao dao) {
		
		if (customer.getApprovalStatus() == false) {
			System.out.println("Error: Account is not approved.");
		} else if (customer.getBalance() < amount) {
			System.out.println("Error: Insufficient funds."); 
		} else {
			customer.setBalance(customer.getBalance() - amount);
			
			// Update customer database
			dao.updateCustomer(customer);
	        logger.info("Admin withdraw " + amount + ": " + customer.toString());
	        System.out.println("Successfully withdrew " + amount + " to " + customer.getUsername());
		}
	}
	
	// Deposit to customer account
	public void deposit(Customer customer, double amount, CustomerDao dao) {
		
		if (customer.getApprovalStatus() == false) {
			System.out.println("Error: Account is not approved.");
		} else {
			customer.setBalance(customer.getBalance() + amount);
	        
			/// Update customer database
			dao.updateCustomer(customer);
	        logger.info("Admin deposit " + amount + ": " + customer.toString());
	        System.out.println("Successfully deposited " + amount + " to " + customer.getUsername());
		}
	}
	
	// Delete customer record in database
	public void deleteAccount(Customer customer, CustomerDao dao) {
			
		// Delete customer record
		dao.deleteCustomer(customer);
        logger.info("Admin deleted: " + customer.toString());
        System.out.println("Deleted " + customer.getUsername());
	}
	
}
