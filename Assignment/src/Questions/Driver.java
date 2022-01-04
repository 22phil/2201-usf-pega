package Questions;

import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		Q1 q1 = new Q1();
		Integer[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("Q1 " + Arrays.toString(q1.bubbleSort(arr)));
		
		Q2 q2 = new Q2();
		System.out.println("Q2 " + Arrays.toString(q2.fibonacci(25)));
		
		Q3 q3 = new Q3();
		String s = "TestString";
		System.out.println("Q3 " + q3.reverseString(s));
		
		Q4 q4 = new Q4();
		System.out.println("Q4 " + q4.factorial(5));
		
		Q5 q5 = new Q5();
		System.out.println("Q5 " + q5.substring(s, 3));

	}

}
