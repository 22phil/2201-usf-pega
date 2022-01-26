package com.revature.models;

import com.revature.dao.CustomerDao;

public interface Account {
	
	// Every interface should have withdraw and deposit methods
	public void withdraw(Customer customer, double balance, CustomerDao dao);
	public void deposit(Customer customer, double balance, CustomerDao dao);

}
