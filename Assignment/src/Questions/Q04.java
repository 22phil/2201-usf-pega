package Questions;

public class Q04 {
	
	public Integer factorial(int n) {
		
		// return 1 at deepest level
		if (n == 1 || n == 0) {
			return 1;
		}
		
		// Recursive call to factorial to get the next multiplicand
		return n * factorial(n-1);
	}

}
