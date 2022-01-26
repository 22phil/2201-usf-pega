package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.CustomerDao;
import com.revature.models.Customer;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class CustomerController {
	
	private static final Logger logger = LogManager.getLogger(CustomerController.class);

	Javalin app;
	CustomerDao dao;
	
	public CustomerController(Javalin app) {
		this.app = app;
		dao = new CustomerDao();
		
		app.post("/customer/form", createNewCustomerRecord);
		app.get("/customer/{username}/{password}", readDatabase);
		app.put("/customer/update", updateCustomer);
		app.delete("/customer/delete", deleteCustomer);
	}
	
	// Create a new customer from the html form
	public Handler createNewCustomerRecord = ctx -> {
		//Access via localhost:7070 or http://localhost:7070/index.html
		int rowsAffected = dao.createNewCustomerRecord(ctx.formParam("username"), ctx.formParam("password"));
		
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
			logger.info("CustomerController createNewCustomerRecord: " + new Customer(ctx.formParam("username"), ctx.formParam("password"), 0, false).toString());
	        ctx.status(201);
	        ctx.redirect("/index.html");
		}
	};
	
	// Retrieve a customer based on their username and password
	public Handler readDatabase = ctx -> {
		//Access via localhost:7070/customer/username/password
		Customer customer = dao.readDatabase(ctx.pathParam("username"), ctx.pathParam("password"));
		
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
	        logger.info("CustomerController readDatabase: " + customer.toString());
		}
	};
	
	// Update a customer using the data provided in the body
	public Handler updateCustomer = ctx -> {
		Customer customer = ctx.bodyAsClass(Customer.class);
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
	        logger.info("CustomerController updateCustomer: " + customer.toString());
	        // Status code 204 means "Successfully updated"
	     	ctx.status(204);
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
			logger.info("CustomerController deleteCustomer: " + customer.toString());
		    // Status code 204 means "Successfully updated"
		    ctx.status(204);
		    ctx.result("Successfully updated.");
		}
	};

}
