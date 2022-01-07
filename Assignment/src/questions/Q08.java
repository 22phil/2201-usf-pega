package questions;

import java.util.ArrayList;

public class Q08 {
	
public ArrayList<String> palindromes(ArrayList<String> args) {
		
		ArrayList<String> palin = new ArrayList<String>();
	
		// Iterate through args
		for(String element : args) {
			
			boolean isPalindrome = true;
			
			// If element's first and last char are equal, second and second last... -> palindrome
			for (int i = 0; i < element.length(); i++) {
				if (element.charAt(i) != element.charAt(element.length()-i-1)) {
					isPalindrome = false;
					break;
				}
			}
			if (isPalindrome == true) {
				palin.add(element);
			}
		}
		
		return palin;
	
	}

}