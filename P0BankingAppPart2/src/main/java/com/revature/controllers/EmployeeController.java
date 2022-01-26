package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.CustomerDao;
import com.revature.models.Customer;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeeController {
	
	private static final Logger logger = LogManager.getLogger(EmployeeController.class);
	
	Javalin app;
	CustomerDao dao;
	
	public EmployeeController(Javalin app) {
		this.app = app;
		dao = new CustomerDao();
		
		app.post("/employee/create", createNewCustomerRecord);
		app.get("/employee/{username}", getCustomerByUsername);
		app.put("/employee/{username}/{approvalStatus}", setApprovalStatus);
		app.delete("/employee/delete", deleteCustomer);
	}
	
	// Create a new customer using the data provided in the body as JSON
	public Handler createNewCustomerRecord = ctx -> {
		Customer customer = ctx.bodyAsClass(Customer.class);
		int rowsAffected = dao.createNewCustomerRecord(customer.getUsername(), customer.getPassword());
				
		if (rowsAffected == 0) {
			// Status code 400 means "Error occurred"
			ctx.status(400);
			ctx.result("Error occurred.");
		} else if (rowsAffected > 1) {
			// Status code 400 means "Error occurred"
			ctx.status(400);
			ctx.result("Error occurred.");
		} else {
			// Status code 201 means "created"
			ctx.status(201);
			ctx.result("Created new customer (balance = 0, approval status = false).");
			logger.info("AdminController createNewCustomerRecord: " + new Customer(customer.getUsername(), customer.getPassword(), 0, false).toString());
		}
	};
	
	// Retrieve a customer based on their username
	public Handler getCustomerByUsername = ctx -> {
		//Access via localhost:7070/employee/username
		Customer customer = dao.getCustomerByUsername(ctx.pathParam("username"));
			
		if (customer.getUsername() == null) {
			// Status code 400 means "Error occurred"
			ctx.status(400);
			ctx.result("Error occurred.");
		} else if (customer.getUsername().equals(null)) {
			ctx.status(400);
			ctx.result("Error occurred.");
		} else {	
			// Status code 200 means "OK"
			ctx.status(200);
			ctx.json(customer);
		    logger.info("EmployeeController getCustomerByUsername: " + customer.toString());
		}

	};
	
	// Update a customer by approval/denial
	public Handler setApprovalStatus = ctx -> {
		//Access via http put localhost:7070/employee/username/approvalStatus
		
		Customer customer = dao.getCustomerByUsername(ctx.pathParam("username"));
		if (customer.getUsername() != null && (ctx.pathParam("approvalStatus").equals("true") || ctx.pathParam("approvalStatus").equals("false"))) {
			customer.setApprovalStatus(Boolean.parseBoolean(ctx.pathParam("approvalStatus")));
			int rowsAffected = dao.updateCustomer(customer);
			
			if (rowsAffected == 0) {
				// Status code 400 means "Error occurred"
				ctx.status(400);
				ctx.result("Error occurred.");
			} else if (rowsAffected > 1) {
				// Status code 400 means "Error occurred"
				ctx.status(400);
				ctx.result("Error occurred.");
			} else {
				// Status code 204 means "Successfully updated"
			    ctx.status(204);
				ctx.result("Changed approval status of " + customer.getUsername() + " to " + customer.getApprovalStatus());
				logger.info("EmployeeController updateCustomer: " + customer.toString());
			}
		} else {
			ctx.status(400);
			ctx.result("Error occurred.");
		}
	};
	
	// Delete a customer using the data provided in the body as JSON
	public Handler deleteCustomer = ctx -> {
		Customer customer = ctx.bodyAsClass(Customer.class);
		int rowsAffected = dao.deleteCustomer(customer);
			
		if (rowsAffected == 0) {
			// Status code 400 means "Error occurred"
			ctx.status(400);
			ctx.result("Error occurred.");
		} else if (rowsAffected > 1) {
			// Status code 400 means "Error occurred"
			ctx.status(400);
			ctx.result("Error occurred.");
		} else {
		    logger.info("AdminController deleteCustomer: " + customer.toString());
		    // Status code 204 means "Successfully updated"
		     ctx.status(204);
		     ctx.result("Successfully updated.");
		}
	};

}
