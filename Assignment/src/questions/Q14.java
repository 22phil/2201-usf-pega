package questions;

import java.time.LocalDate;

public class Q14 {
	
	public String switchMethod(int c, int no) {
		
		// Instantiate result string
		String res = "";
		
		switch(c) {
		  
		  // Computes root of no
		  case 1:
		    res += Math.sqrt(no);
		    break;
		  
		  // Today's date
		  case 2:
			res += LocalDate.now().toString();
		    break;
		  
		  // String split
		  case 3:
			String str = "I am learning Core Java";
			String[] arrStr = str.split(" ");
			res += arrStr;
		    break; 
		  
		  default:
			break;
		}
		
		return res;
			
	}

}
