package Questions;

public class Q03 {
	public String reverseString(String s) {
		
		// Handle empty strings
		if (s == null) {
			return null;
		}
		
		// Instantiate char array and result string
		char[] ch = new char[s.length()];
		String result = "";
		
		// Iterate over string and add it in reverse order to char array and result
		for (int i = 0; i < s.length(); i++) {
			ch[i] = s.charAt(s.length() -1 -i);
			result += ch[i];
        }
		
		return result;
	}
}
