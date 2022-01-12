package com.revature;

public class Employee {
	
	// Constructor
	public Employee() {
	}
	
	// View customer information
	public void customerInfo(Customer customer) {
		System.out.println("Name: " + customer.getUsername());
		System.out.println("Password: " + customer.getPassword());
		System.out.println("Balance: " + customer.getBalance());
	}

}
