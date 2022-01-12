package com.revature;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void loginMenu() {
	    System.out.println ( "1: Sign in\n2: Sign up\n3: Quit" );
	}
	
	public static void accountMenu() {
	    System.out.println ( "1: Deposit\n2: Withdraw\n3: Transfer\n4: Quit" );
	}
	
	public static void employeeMenu() {
		System.out.println ( "1: Show customer info\n2: Quit" );
	}
	
	public static void adminMenu() {
		System.out.println ("1: Approve/Deny account\n2: Deposit\n3: Withdraw\n4: Delete account\n5: Quit" );
	}
	
	public static String wordInput(Scanner in) {
		
		// Only alphabetic characters are allowed
		while (!in.hasNext("[A-Za-z]+")) {
            System.out.println("Invalid input. Try again.");
            in.next();
        }
		String word = in.next();
		
		// The string "null" is not allowed
		if (word.equals("null")) {
			System.out.println("Invalid input. Try again.");
			return wordInput(in);
		}
		return word;
	}
	
	public static double doubleInput(Scanner in) {
		
		// Input must be of type double
		while (!in.hasNextDouble()) {
            System.out.println("Invalid input. Try again.");
            in.next();
        }
		double d = in.nextDouble();
		return d;
	}
	
	public static boolean booleanInput(Scanner in) {
		
		// Input must be of type boolean
		while (!in.hasNextBoolean()) {
            System.out.println("Invalid input. Try again.");
            in.next();
        }
		boolean b = in.nextBoolean();
		return b;
	}
	
	public static void main(String[] args) {
		
		// Initialize variables
		IO io = new IO();
		String username, password;
        double amount;
		Scanner in = new Scanner(System.in);
		Customer customer = null;
		Employee employee = null;
		Admin admin = null;
		
		// Start user interaction with the login menu
		loginMenu();
		if (in.hasNextInt()) {
			switch (in.nextInt()) {
	        	case 1:
	        		boolean LoginValid = false;
	        		while (!LoginValid) {
	        			System.out.println ("Enter username:");
	        			username = wordInput(in);
	        			System.out.println("Enter password: ");
	        			password = wordInput(in);
	        			ArrayList<Customer> customerList = io.readFile();
	        			for (int i = 0; i < customerList.size(); i++) {
	        				if (customerList.get(i).getUsername().equals(username) && customerList.get(i).getPassword().equals(password)) {
	        					LoginValid = true;
	        					customer = new Customer(username, password, customerList.get(i).getBalance(), customerList.get(i).getApprovalStatus());
	        					System.out.println("Login successful.");
	        					break;
	        				}
	        			}
	        			if (!LoginValid) {
	        				System.out.println("Wrong username/password. Try again.");
	        			}
	    		
	        		}
	        		break;
	        	case 2:
	        		boolean accValid = false;
	        		while (!accValid) {
	        			System.out.println ("Enter username:");
	        			username = wordInput(in);
	        			System.out.println("Enter password: ");
	        			password = wordInput(in);
	        			ArrayList<Customer> customerList = io.readFile();
	        			for (int i = 0; i < customerList.size(); i++) {
	        				if (customerList.get(i).getUsername().equals(username)) {
	        					accValid = true;
	        				}
	        			}
	        			if (!accValid) {
	        				customer = new Customer(username, password, io);
	        				System.out.println("Account created.");
	        				accValid = true;
	        			} else {
	        				System.out.println("Username not available. Try again.");
	        				accValid = false;
	        			}
		    		
	        		}
	        		break;
	        	case 3:
	        		System.err.println ("Exiting.");
	        		System.exit(0);
	        		break;
	        	case 99:
	        		employee = new Employee();
	        		break;
	        	case 999:
	        		admin = new Admin();
	        		break;
	        	default:
	        		System.err.println ("Unrecognized option. Exiting.");
	        		break;
					}
		} else {
		System.err.println ("Unrecognized option. Exiting.");
		System.exit(0);
		}
		
		// Employee and admin menu
		if (employee != null) {
			while(true) {
				employeeMenu();
				if (in.hasNextInt()) {
					switch (in.nextInt()) {
			        	case 1:
			        		System.out.println ("Enter customer name:");
			        		String customerName = wordInput(in);
			        		ArrayList<Customer> customerList = io.readFile();
		        			for (int i = 0; i < customerList.size(); i++) {
		        				if (customerList.get(i).getUsername().equals(customerName)) {
		        					customer = new Customer(customerName, customerList.get(i).getPassword(), customerList.get(i).getBalance(), customerList.get(i).getApprovalStatus());
		        					employee.customerInfo(customer);
		        					break;
		        				}
		        			}
			        		break;
			        	case 2:
			        		System.err.println ("Exiting.");
			        		System.exit(0);
			        		break;
			        	default:
			        		System.err.println ("Unrecognized option. Try again.");
			        		break;
							}
				} else {
				System.err.println ("Unrecognized option. Exiting.");
				System.exit(0);
				}
				}
		} else if (admin != null) {
			while(true) {
				adminMenu();
				if (in.hasNextInt()) {
					switch (in.nextInt()) {
			        	case 1:
			        		System.out.println ("Enter customer name:");
			        		String customerName = wordInput(in);
			        		System.out.println ("Enter approval status (true or false):");
			        		boolean isApproved = booleanInput(in);
			        		ArrayList<Customer> customerList = io.readFile();
		        			for (int i = 0; i < customerList.size(); i++) {
		        				if (customerList.get(i).getUsername().equals(customerName)) {
		        					customer = new Customer(customerName, customerList.get(i).getPassword(), customerList.get(i).getBalance(), customerList.get(i).getApprovalStatus());
		        					admin.setApprovalStatus(customer, isApproved, io);
		        					break;
		        				}
		        			}
			        		break;
			        	case 2:
			        		System.out.println ("Enter customer name:");
			        		String customerName2 = wordInput(in);
			        		System.out.println ("Enter amount:");
			        		amount = doubleInput(in);
			        		ArrayList<Customer> customerList2 = io.readFile();
		        			for (int i = 0; i < customerList2.size(); i++) {
		        				if (customerList2.get(i).getUsername().equals(customerName2)) {
		        					customer = new Customer(customerName2, customerList2.get(i).getPassword(), customerList2.get(i).getBalance(), customerList2.get(i).getApprovalStatus());
		        					admin.deposit(customer, amount, io);
		        					break;
		        				}
		        			}
			        		break;
			        	case 3:
			        		System.out.println ("Enter customer name:");
			        		String customerName3 = wordInput(in);
			        		System.out.println ("Enter amount:");
			        		amount = doubleInput(in);
			        		ArrayList<Customer> customerList3 = io.readFile();
		        			for (int i = 0; i < customerList3.size(); i++) {
		        				if (customerList3.get(i).getUsername().equals(customerName3)) {
		        					customer = new Customer(customerName3, customerList3.get(i).getPassword(), customerList3.get(i).getBalance(), customerList3.get(i).getApprovalStatus());
		        					admin.withdraw(customer, amount, io);
		        					break;
		        				}
		        			}
			        		break;
			        	case 4:
			        		System.out.println ("Enter customer name:");
			        		String customerName4 = wordInput(in);
			        		ArrayList<Customer> customerList4 = io.readFile();
		        			for (int i = 0; i < customerList4.size(); i++) {
		        				if (customerList4.get(i).getUsername().equals(customerName4)) {
		        					customer = new Customer(customerName4, customerList4.get(i).getPassword(), customerList4.get(i).getBalance(), customerList4.get(i).getApprovalStatus());
		        					admin.deleteAccount(customer, io);
		        					break;
		        				}
		        			}
			        		break;
			        	case 5:
			        		System.err.println ("Exiting.");
			        		System.exit(0);
			        		break;
			        	default:
			        		System.err.println ("Unrecognized option. Try again.");
			        		break;
							}
				} else {
				System.err.println ("Unrecognized option. Exiting.");
				System.exit(0);
				}
				}
		}
		
		// Customer account menu
		while(true) {
		accountMenu();
		if (in.hasNextInt()) {
			switch (in.nextInt()) {
	        	case 1:
	        		System.out.println ("Enter amount:");
	        		amount = doubleInput(in);
	        		customer.deposit(customer, amount, io);
	        		break;
	        	case 2:
	        		System.out.println ("Enter amount:");
	        		amount = doubleInput(in);
	        		customer.withdraw(customer, amount, io);
	        		break;
	        	case 3:
	        		System.out.println ("Enter amount:");
	        		amount = doubleInput(in);
	        		System.out.println ("Enter recipient:");
	        		String recipientName = wordInput(in);
	        		Customer recipient = null;
	        		ArrayList<Customer> customerList = io.readFile();
        			for (int i = 0; i < customerList.size(); i++) {
        				if (customerList.get(i).getUsername().equals(recipientName)) {
        					recipient = new Customer(recipientName, customerList.get(i).getPassword(), customerList.get(i).getBalance(), customerList.get(i).getApprovalStatus());
        					break;
        				}
        			}
        			if (recipient == null) {
        				System.out.println("Recipient not found.");
        				break;
        			}
        			if (customer.getBalance() > amount) {
        				customer.withdraw(customer, amount, io);
            			recipient.deposit(recipient, amount, io);
        			} else {
        				System.out.println("Insufficient funds.");
        			}
	        		break;
	        	case 4:
	        		System.err.println ("Exiting.");
	        		System.exit(0);
	        		break;
	        	default:
	        		System.err.println ("Unrecognized option. Try again.");
	        		break;
					}
		} else {
		System.err.println ("Unrecognized option. Exiting.");
		System.exit(0);
		}
		}		

	}

}
