package Questions;

public class Q01 {
	
	public Integer[] bubbleSort(Integer[] arr) {
		
		int i = 0;
		
		// Iterate through array until no consecutive elements are increasing
		while (i < arr.length-1) {	
			
			// Swap consecutive elements if they are increasing and restart iteration
			if (arr[i] > arr[i+1]) {
				int tmp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = tmp;
				i = 0;
			} else {
				i++;
			}
		}
		
		return arr;
	}

}
