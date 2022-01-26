package com.revature.console;

import com.revature.dao.CustomerDao;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Admin;

import java.util.Scanner;

public class Menu {
	
	public static void loginMenu() {
	    System.out.println ( "1: Sign in\n2: Sign up\n3: Quit" );
	}
	
	public static void accountMenu() {
	    System.out.println ( "1: Deposit\n2: Withdraw\n3: Transfer\n4: Quit" );
	}
	
	public static void employeeMenu() {
		System.out.println ( "1: Show customer info\n2: Approve/Deny account\n3: Quit" );
	}
	
	public static void adminMenu() {
		System.out.println ("1: Approve/Deny account\n2: Deposit\n3: Withdraw\n4: Delete account\n5: Quit" );
	}
	
	public static String alphanumericInput(Scanner in) {
		
		// Only alphabetic characters are allowed
		while (!in.hasNext("[a-zA-Z0-9]+")) {
            System.out.println("Invalid input. Alphanumeric only. Try again.");
            in.next();
        }
		String word = in.next();
		
		// String should not be "null" and also not extend 50 characters
		if (word.equals("null") || word.length() > 50) {
			System.out.println("Invalid input. Alphanumeric only. Try again.");
			return alphanumericInput(in);
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
	
	public void menu() {
		
		// Initialize variables
		CustomerDao dao = new CustomerDao();
		String username, password;
        double amount;
		Scanner in = new Scanner(System.in);
		Customer customer = new Customer(null, null, 0, false);
		Employee employee = null;
		Admin admin = null;
		
		
		System.out.println(
			"\n\n" +
			"######                                             #                  \n" +
			"#     #   ##   #    # #    # # #    #  ####       # #   #####  #####  \n" +
			"#     #  #  #  ##   # #   #  # ##   # #    #     #   #  #    # #    # \n" +
			"######  #    # # #  # ####   # # #  # #         #     # #    # #    # \n" +
			"#     # ###### #  # # #  #   # #  # # #  ###    ####### #####  #####  \n" +
			"#     # #    # #   ## #   #  # #   ## #    #    #     # #      #      \n" +
			"######  #    # #    # #    # # #    #  ####     #     # #      #      \n"
		);
		
		// Start user interaction with the login menu
		while (customer.getUsername() == null && employee == null && admin == null) {
		loginMenu();
		if (in.hasNextInt()) {
			switch (in.nextInt()) {
	        	case 1:
	        		System.out.println ("Enter username:");
	        		username = alphanumericInput(in);
	        		System.out.println("Enter password: ");
	        		password = alphanumericInput(in);
	        		customer = dao.getCustomerByUsername(username);
	        		if (customer.getUsername() != null && customer.getPassword().equals(password)) {
	        			System.out.println("Login successful.");
	        			break;
	        		} else {
	        			customer.setUsername(null);
	        			System.out.println("Error: Wrong username/password.");
	        		}
	        		break;
	        	case 2:
	        		System.out.println ("Enter username:");
	        		username = alphanumericInput(in);
	        		System.out.println("Enter password: ");
	        		password = alphanumericInput(in);
	        		customer = dao.getCustomerByUsername(username);
	        		if (customer.getUsername() == null) {
	        			System.out.println("Account created.");
	        			dao.createNewCustomerRecord(username, password);
	        			customer.setUsername(null);
	        			break;
	        		} else {
	        			customer.setUsername(null);
	        			System.out.println("Error: Username not available.");
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
	        		System.err.println ("Unrecognized option. Try again.");
	        		break;
					}
		} else {
		System.err.println ("Unrecognized option. Exiting.");
		System.exit(0);
		}
		}
		
		// Employee and admin menu
		if (employee != null) {
			while(true) {
				employeeMenu();
				if (in.hasNextInt()) {
					switch (in.nextInt()) {
			        	case 1:
			        		System.out.println ("Enter customer name:");
			        		String customerName = alphanumericInput(in);
			        		customer = dao.getCustomerByUsername(customerName);
			        		if (customer.getUsername() != null) {
			        			// View customer information
			        			System.out.println(customer.toString());
			        		} else {
			        			System.out.println("Error: Customer not found.");
			        		}
			        		break;
			        	case 2:
			        		System.out.println ("Enter customer name:");
			        		String customerName2 = alphanumericInput(in);
			        		customer = dao.getCustomerByUsername(customerName2);
			        		if (customer.getUsername() != null) {
			        			System.out.println ("Enter approval status (true or false):");
				        		boolean isApproved = booleanInput(in);
			        			employee.setApprovalStatus(customer, isApproved, dao);
			        		} else {
			        			System.out.println("Error: Customer not found.");
			        		}
			        		break;
			        	case 3:
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
			        		String customerName = alphanumericInput(in);
			        		customer = dao.getCustomerByUsername(customerName);
			        		if (customer.getUsername() != null) {
			        			System.out.println ("Enter approval status (true or false):");
				        		boolean isApproved = booleanInput(in);
			        			admin.setApprovalStatus(customer, isApproved, dao);
			        		} else {
			        			System.out.println("Error: Customer not found.");
			        		}
			        		break;
			        	case 2:
			        		System.out.println ("Enter customer name:");
			        		String customerName2 = alphanumericInput(in);
			        		customer = dao.getCustomerByUsername(customerName2);
			        		if (customer.getUsername() != null) {
			        			System.out.println ("Enter amount:");
				        		amount = doubleInput(in);
			        			admin.deposit(customer, amount, dao);
			        		} else {
			        			System.out.println("Error: Customer not found.");
			        		}
			        		break;
			        	case 3:
			        		System.out.println ("Enter customer name:");
			        		String customerName3 = alphanumericInput(in);
			        		customer = dao.getCustomerByUsername(customerName3);
			        		if (customer.getUsername() != null) {
			        			System.out.println ("Enter amount:");
				        		amount = doubleInput(in);
			        			admin.withdraw(customer, amount, dao);
			        		} else {
			        			System.out.println("Error: Customer not found.");
			        		}
			        		break;
			        	case 4:
			        		System.out.println ("Enter customer name:");
			        		String customerName4 = alphanumericInput(in);
			        		customer = dao.getCustomerByUsername(customerName4);
			        		if (customer.getUsername() != null) {
			        			admin.deleteAccount(customer, dao);
			        		} else {
			        			System.out.println("Error: Customer not found.");
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
	        		customer.deposit(customer, amount, dao);
	        		break;
	        	case 2:
	        		System.out.println ("Enter amount:");
	        		amount = doubleInput(in);
	        		customer.withdraw(customer, amount, dao);
	        		break;
	        	case 3:
	        		System.out.println ("Enter amount:");
	        		amount = doubleInput(in);
	        		System.out.println ("Enter recipient:");
	        		String recipientName = alphanumericInput(in);
	        		Customer recipient = dao.getCustomerByUsername(recipientName);
        			if (recipient.getUsername() == null) {
        				System.out.println("Error: Recipient not found.");
        				break;
        			} else if (!recipient.getApprovalStatus()){
        				System.out.println("Error: Recipient is not approved.");
        				break;
        			}
        			if (customer.getBalance() > amount) {
        				customer.withdraw(customer, amount, dao);
            			recipient.deposit(recipient, amount, dao);
        			} else {
        				System.out.println("Error: Insufficient funds.");
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
