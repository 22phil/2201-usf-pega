package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionManager {

	private static final Logger logger = LogManager.getLogger(ConnectionManager.class);
	private static Connection connection;
	
	// "jdbc:postgresql://Server:port/dbname"
	private static String connectionString = "jdbc:postgresql://ella.db.elephantsql.com:5432/douqpsad",
							username = "douqpsad",
							password = "1y9WhZtZSIu9sVgzHaLLL8YuL7HQDSU4";
	
	
	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
			
				// Class.forName ensures this class is loaded and avoids a ClassNotFoundException
				Class.forName("org.postgresql.Driver");
				
				// Connection object is used to manage the network connection with the database
				connection = DriverManager.getConnection(connectionString, username, password);
			}
			
			return connection;
		} catch (ClassNotFoundException e) {
			logger.error("ClassNotFoundException", e);
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error("SQLException", e);
			e.printStackTrace();
		}
		
		return null;
	}
	
	// When the program is stopped, this will trigger and close the connection
	// You have to use the stop button in your IDE. Similar to finally clause in main()
	@Override
	public void finalize() {
		try {
			ConnectionManager.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
