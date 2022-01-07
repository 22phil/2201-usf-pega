package questions;

import java.util.ArrayList;
import java.util.Iterator;

public class Q19 {
	
	// Add up all even numbers of integer list
	public int addEven(ArrayList<Integer> intList){
		
		int res = 0;
		
		for (int i : intList) {
			if (i % 2 == 0) {
				res += i;
			}
		}
		
		return res;
	}
	
	// Add up all odd numbers of integer list
	public int addOdd(ArrayList<Integer> intList){
		
		int res = 0;
		
		for (int i : intList) {
			if (i % 2 == 1) {
				res += i;
			}
		}
		
		return res;
	}
	
	// Check for prime
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
	
	// Remove primes from the list
	public ArrayList<Integer> removePrimes(ArrayList<Integer> intList){
		
		// Create an iterator object
        Iterator<Integer> itr = intList.iterator();
		
		while (itr.hasNext()) {
			 
            // Remove primes via Iterator.remove() to avoid concurrency issues
            int i = (Integer)itr.next();
            if (isPrime(i)) {
            	itr.remove();
            }
        }
		
		return intList;
	}

}
