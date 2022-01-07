package questions;

import java.util.Scanner;

public class Q17 {
	
	public double interest() {
		
		double principal = 0;
		double interest = 0;
		double years = 0;
		
		// Create a Scanner object
		Scanner scan = new Scanner(System.in);
		
		try {
	    	
	    	// Read user input
			System.out.println("Enter principal");
			if(scan.hasNextDouble()){
				principal = scan.nextDouble();
			} else {
				throw new IllegalArgumentException("Argument must be of type double");
			}
			
			System.out.println("Enter rate of interest");
		    if(scan.hasNextDouble()){
				interest = scan.nextDouble();
			} else {
				throw new IllegalArgumentException("Argument must be of type double");
			}
			
			System.out.println("Enter number of years");
		    if(scan.hasNextDouble()){
				years = scan.nextDouble();
			} else {
				throw new IllegalArgumentException("Argument must be of type double");
			}

	    // Catch error
	    } catch (IllegalArgumentException e) {
	        System.err.println("IllegalArgumentException: " + e.getMessage());
	    } finally {
			scan.close();
		}
		
		return principal*interest*years;
	}

}
