package questions;

import java.util.ArrayList;

public class Q09 {
	
	public boolean isPrime(int n) {
		
		// 1 and smaller integers are not prime
		if (n <= 1) {
			return false;
		}
		
		// If n has no divisors from two to the rounded value of the root of n -> n is prime
		for(int i = 2; i <= Math.round(Math.sqrt(n)); i++) {
			if (n % i == 0) return false;
		}
				
		return true;
	}
	
	public ArrayList<Integer> primes(int n) {
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
	
		// Iterate through all integers up to n
		for(int i = 3; i <= n; i++) {
			
			// Filter out primes
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		
		return primes;
	
	}

}
