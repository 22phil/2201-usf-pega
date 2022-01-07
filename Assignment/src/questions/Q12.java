package questions;

public class Q12 {
	
	public Integer[] numArray(){
		
		Integer[] integerArr = new Integer[100];
		
		// Stores the numbers from 1 to 100
		for (int i = 1; i <= 100; i++) {
			integerArr[i-1] = i;
		}
		
		return integerArr;
	}

}
