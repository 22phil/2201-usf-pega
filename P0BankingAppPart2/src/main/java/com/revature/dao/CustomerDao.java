package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Customer;

public class CustomerDao {
	
	private static final Logger logger = LogManager.getLogger(CustomerDao.class);

	public Customer getCustomerByUsername(String username) {
		
		try {
			// 1. Create a Statement
			Connection c = ConnectionManager.getConnection();
			
			PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM customer WHERE username = ?");
			preparedStatement.setString(1, username);
			
			// 2. Run a query using the statement to find any records with the given username
			ResultSet result = preparedStatement.executeQuery();
			
			// 3. If there is more than 0 records, we'll return false. Otherwise true.
			if (result.next())
				return new Customer(result.getString("username"), result.getString("password"), result.getDouble("balance"), result.getBoolean("approvalstatus"));
			
		return new Customer(null, null, 0, false);
			
		} catch (SQLException e) {
			logger.error("SQLException", e);
			e.printStackTrace();
		}
		
		return new Customer(null, null, 0, false);
	}
	
	public int createNewCustomerRecord(String username, String password) {

		try {
			Connection c = ConnectionManager.getConnection();
			Statement statement = c.createStatement();
			
			// Returns int rowsAffected
			return statement.executeUpdate("INSERT INTO customer VALUES (\'" + username 
					+ "\', \'" + password + "\', \'" + 0 + "\', \'" + false + "\')");
		} catch (SQLException e) {
			logger.error("SQLException", e);
			e.printStackTrace();
		}
		return 0;
	}
	
	public Customer readDatabase(String username, String password) {
		
		try {
			// Create statement
			Connection c = ConnectionManager.getConnection();
			
			PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM customer WHERE username = ? AND password = ?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			// Execute query
			ResultSet result = preparedStatement.executeQuery();
			
			// If the result set is not empty, return result
			if (result.next())
				return new Customer(result.getString("username"), result.getString("password"), result.getDouble("balance"), result.getBoolean("approvalstatus"));
						
			return new Customer(null, null, 0, false);
			
		} catch (SQLException e) {
			logger.error("SQLException", e);
			e.printStackTrace();
		}
		
		return new Customer(null, null, 0, false);
	}
	
	public int updateCustomer(Customer customer) {
		
		try {
			// Create statement
			Connection c = ConnectionManager.getConnection();
			
			Statement statement = c.createStatement();
			
			
			// Returns int rowsAffected
			return statement.executeUpdate("UPDATE customer SET balance = \'"
					+ customer.getBalance() + "\', approvalstatus = \'" 
					+ customer.getApprovalStatus() + "\' WHERE username = \'" 
					+ customer.getUsername() + "\' AND password = \'" 
					+ customer.getPassword() + "\'");
			
		} catch (SQLException e) {
			logger.error("SQLException", e);
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteCustomer(Customer customer) {
		
		try {
			// Create statement
			Connection c = ConnectionManager.getConnection();
			
			Statement statement = c.createStatement();
			
			// Returns int rowsAffected
			return statement.executeUpdate("DELETE FROM customer WHERE username = \'"
					+ customer.getUsername() + "\' AND password = \'" 
					+ customer.getPassword() + "\'");
			
		} catch (SQLException e) {
			logger.error("SQLException", e);
			e.printStackTrace();
		}
		return 0;
	}

}