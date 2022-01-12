package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTests {
	
	Customer customer = new Customer("Alice", "password", 100, true);
	
	@Test
	public void test_getUsername() {
		String username = customer.getUsername();
		assertEquals(username, "Alice");
	}
	@Test
	public void test_setUsername() {
		String newUsername = "Bob";
		customer.setUsername(newUsername);
		assertEquals(customer.getUsername(), "Bob");
	}
	@Test
	public void test_getPassword() {
		String password = customer.getPassword();
		assertEquals(password, "password");
	}
	@Test
	public void test_setPassword() {
		String newPassword = "passwordpassword";
		customer.setPassword(newPassword);
		assertEquals(customer.getPassword(), "passwordpassword");
	}
	@Test
	public void test_getBalance() {
		double balance = customer.getBalance();
		assertEquals(balance, 100);
	}
	@Test
	public void test_setBalance() {
		double newBalance = 1000;
		customer.setBalance(newBalance);
		assertEquals(customer.getBalance(), 1000);
	}
	@Test
	public void test_approvalStatus() {
		boolean approvalStatus = customer.getApprovalStatus();
		assertEquals(approvalStatus, "true");
	}
	@Test
	public void test_setApprovalStatus() {
		boolean newApprovalStatus = false;
		customer.setApprovalStatus(newApprovalStatus);
		assertEquals(customer.getApprovalStatus(), false);
	}

}
