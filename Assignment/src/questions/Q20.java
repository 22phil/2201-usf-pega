package questions;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q20 {
  
	public void scan() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("/path/to/Data.txt"));
			int counter = 0;
    	
			// Check for input
			while(sc.hasNextLine()){
				String str = sc.nextLine();
				// Call the parse method
				parseData(str, counter);
				counter++;
			}
		// Handle exceptions
		} catch (IOException  e) {
			System.err.println("IOException: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.err.println("InputMismatchException: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}finally{
			if(sc != null) {
				sc.close();
			}
		}	  		
    }
	
	// Parse txt file
	private static void parseData(String str, int counter){	
		String surname, name, state;
		int age;
		Scanner scanner = new Scanner(str);
		scanner.useDelimiter(":");
		while(scanner.hasNext()){
			surname = scanner.next();
			name = scanner.next();
			age = scanner.nextInt();
			state = scanner.next();
			if (counter == 0) {
				System.out.println("Q20 Name: " + surname + " " + name);
			} else {
				System.out.println("    Name: " + surname + " " + name);
			}
			System.out.println("    Age: " + age + " years");
			System.out.println("    State: " + state + " State");
			System.out.println();
		}
		scanner.close();
	}
}
