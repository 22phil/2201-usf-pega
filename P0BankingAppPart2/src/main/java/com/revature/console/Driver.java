package com.revature.console;

import com.revature.controllers.AdminController;
import com.revature.controllers.CustomerController;
import com.revature.controllers.EmployeeController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Driver {

	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create( config -> {
			config.addStaticFiles("/", Location.CLASSPATH);
		}).start(7070);
		
		CustomerController customerController = new CustomerController(app);
		EmployeeController employeeController = new EmployeeController(app);
		AdminController adminController = new AdminController(app);
			
		Menu menu = new Menu();
		menu.menu();

	}

}
