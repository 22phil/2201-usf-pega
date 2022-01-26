package com.revature.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.CustomerDao;

public class Employee {
	
	private static final Logger logger = LogManager.getLogger(Employee.class);
	
	// Constructor
	public Employee() {
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
		    logger.info("Employee setApprovalStatus " + bool + ": " + customer.toString());
		    System.out.println("Changed approval status of " + customer.getUsername() + " to " + customer.getApprovalStatus());
		}
	}

}
