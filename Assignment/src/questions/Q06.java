package questions;

public class Q06 {
	
	public boolean isEven(int n) {
		
		// If rightmost bit is 1, n is odd
		if ((n&1) == 1) {
			return false;
		} else {
			return true;
		}
	}

}
