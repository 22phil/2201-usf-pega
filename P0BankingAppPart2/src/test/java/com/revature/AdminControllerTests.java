package com.revature;

import io.javalin.Javalin;
import io.javalin.http.Context;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.controllers.AdminController;
import com.revature.dao.CustomerDao;
import com.revature.models.Customer;

public class AdminControllerTests {
	// enabled "mock-maker-inline" at src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker
	// https://javalin.io/tutorials/mockito-testing
	
	private Context ctx = Mockito.mock(Context.class);
	static String username = "TestCustomerCreatedOnlyForUnitTesting123";
	static CustomerDao dao = new CustomerDao();
	
	static Javalin app = Javalin.create().start(7070);
	static AdminController adminController = new AdminController(app);
    
    // Make sure test customer is not in database
	@BeforeAll
	public static void setupAllTests(){
    	
    	Customer customer = dao.getCustomerByUsername(username);
    	if (customer.getUsername() != null) {
    		dao.deleteCustomer(customer);
		}
    	
	}
	
	// Test Handler createNewCustomerRecord by verifying status code 201
	@Test
	public void test_Handler_createNewCustomerRecord() throws Exception{
				
		Customer customer = new Customer(username, "password", 0, false);
    	
		// Mock ctx.bodyAsClass(Customer.class) to return test customer
    	Mockito.when(ctx.bodyAsClass(Customer.class)).thenReturn(customer);
		
		adminController.createNewCustomerRecord.handle(ctx);
		Mockito.verify(ctx).status(201);
	}
	
	// Test Handler getCustomerByUsername by verifying status code 200
	@Test
	public void test_Handler_getCustomerByUsername() throws Exception{
				
		// Mock ctx.pathParam("username") to return test customer username
		Mockito.when(ctx.pathParam("username")).thenReturn(username);
				
		adminController.getCustomerByUsername.handle(ctx);
		Mockito.verify(ctx).status(200);
	}
    
	// Test Handler updateCustomer by verifying status code 204
	@Test
    public void test_Handler_updateCustomer() throws Exception{
    	
    	Customer customer = new Customer(username, "password", 0, false);
		
    	// Mock ctx.bodyAsClass(Customer.class) to return test customer
    	Mockito.when(ctx.bodyAsClass(Customer.class)).thenReturn(customer);
		
    	adminController.updateCustomer.handle(ctx);
		Mockito.verify(ctx).status(204);
    }
    
	// Test Handler deleteCustomer by verifying status code 204
	@Test
    public void test_Handler_deleteCustomer() throws Exception {
    	
    	Customer customer = new Customer(username, "password", 0, false);
		
    	// Mock ctx.bodyAsClass(Customer.class) to return test customer
    	Mockito.when(ctx.bodyAsClass(Customer.class)).thenReturn(customer);
		
    	adminController.deleteCustomer.handle(ctx);
		Mockito.verify(ctx).status(204);
    }

}
