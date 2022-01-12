package com.revature;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IO {
	
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
	// Path of the ledger.txt file
    static Path ledgerPath = Path.of("/path/to/ledger.txt");
	
	public ArrayList<Customer> readFile() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Scanner sc = null;
		try {
			sc = new Scanner(ledgerPath);
    	
			// Check for input
			while(sc.hasNextLine()){
				String str = sc.nextLine();
				// Call the parse method
				Customer customer = parseData(str);
				if (customer != null && !customer.getUsername().equals("null")) {
					customerList.add(customer);
				}
			}
		// Handle exceptions
		} catch (IOException  e) {
			logger.error("IOException for : " + ledgerPath, e);
			e.printStackTrace();
		} catch (InputMismatchException e) {
			logger.error("InputMismatchException for : " + ledgerPath, e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error("Exception for : " + ledgerPath, e);
			e.printStackTrace();
		}finally{
			if(sc != null) {
				sc.close();
			}
		}
		return customerList;	  		
    }
	
	// Parse ledger.txt file
	private static Customer parseData(String str){	
		String username = null, password = null;
		double balance = 0;
		boolean approvalStatus = false;
		Scanner scanner = new Scanner(str);
		scanner.useDelimiter(":");
		while(scanner.hasNext()){
			username = scanner.next();
			password = scanner.next();
			balance = Double.parseDouble(scanner.next());
			approvalStatus = Boolean.parseBoolean(scanner.next());
		}
		scanner.close();
		return new Customer(username, password, balance, approvalStatus);
	}
	
	public String ledgerEntry(Customer customer) {
		
		// Costumer ledger entry
		String s = "";
        s += customer.getUsername();
        s += ":";
        s += customer.getPassword();
        s += ":";
        s += customer.getBalance();
        s += ":";
        s += customer.getApprovalStatus();
        
        return s;
	}
	
	public void writeToFile(Customer customer) {
		
		try {
	 
	        // Write ledger entry
	        Files.writeString(ledgerPath, ledgerEntry(customer)+System.lineSeparator(), StandardOpenOption.APPEND);  
		    
		} catch (IOException e) {
		    logger.error("IOException for : " + ledgerPath, e);
		    e.printStackTrace();
		}
		  		
    }
	
	public void updateFile(String oldLedgerEntry, String newLedgerEntry) {
        
        // Read in whole ledger
        try (Stream<String> stream = Files.lines(ledgerPath, StandardCharsets.UTF_8)) {
            // Replace old ledger entry with new one
            List<String> list = stream.map(line -> line.replace(oldLedgerEntry, newLedgerEntry)).collect(Collectors.toList());
            // Write the new ledger entry back
            Files.write(ledgerPath, list, StandardCharsets.UTF_8);            
             
        } catch (IOException e) {
        	logger.error("IOException for : " + ledgerPath, e);
            e.printStackTrace();
        }
    }	

}
