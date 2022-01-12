package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IOTests {
	
	IO io = new IO();
	Customer customer = new Customer("Alice", "password", 100, true);
	
	@Test
	public void test_ledgerEntry() {
			
	    assertEquals(io.ledgerEntry(customer), "Alice:password:100.0:true");
	}
	
	@Test
	public void test_ledgerEntryMock() {
			
	    IO io = Mockito.mock(IO.class);
	    Customer Alice = new Customer("Alice", "password1", io);
	    Mockito.when(io.ledgerEntry(Alice)).thenReturn("Alice:password1:0.0:false");
	    
	    String result = io.ledgerEntry(Alice);
	    System.out.println(result);
	    assertEquals(result, "Alice:password1:0.0:false");
	}


}
