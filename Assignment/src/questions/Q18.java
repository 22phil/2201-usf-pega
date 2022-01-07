package questions;

public class Q18 extends SuperQ18{
	
	public boolean uppercase(String s) {
		
		// Iterate through string and return true if any uppercase char is found
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) return true;
		}
		return false;
	}

	public String toUppercase(String s) {

		// Return string in uppercase
		return s.toUpperCase();
	}

	public int toIntPlus10(String s) {
		
		// Convert string to int and add 10
		return Integer.parseInt(s) + 10;
		
	}

}
