package Questions;

public class Q5 {
	
	public String substring(String str, int idx) {
		
		// Handle empty strings and invalid idx
		if (str == null || idx >= str.length()) {
			return null;
		}
		
		// Instantiate empty string
		String tmp = "";
		
		// Iterate over str to concatenate it to the empty string
		for (int i = 0; i <= idx; i++) {
			tmp += str.charAt(i);
		}
		
		return tmp;
	}

}
