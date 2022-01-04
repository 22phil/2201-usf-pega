package Questions;

public class Q2 {
	
	public Integer[] fibonacci(int n) {
		
		// Instantiate integer array and populate it with starting values 0 and 1
		Integer[] fib = new Integer[n];
		fib[0] = 0;
		fib[1] = 1;
		
		// Populate array starting at index 2 with the sum of the two preceding values
		for (int i = 2; i<n; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		return fib;
	}
	
}
