package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Driver {

	// Run the question classes
	public static void main(String[] args) {
		
		Q01 q01 = new Q01();
		Integer[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("Q01 " + Arrays.toString(q01.bubbleSort(arr)));
		
		Q02 q02 = new Q02();
		System.out.println("Q02 " + Arrays.toString(q02.fibonacci(25)));
		
		Q03 q03 = new Q03();
		String s = "TestString";
		System.out.println("Q03 " + q03.reverseString(s));
		
		Q04 q04 = new Q04();
		System.out.println("Q04 " + q04.factorial(5));
		
		Q05 q05 = new Q05();
		System.out.println("Q05 " + q05.substring(s, 3));
		
		Q06 q06 = new Q06();
		System.out.println("Q06 " + q06.isEven(3));
		
		ArrayList<Employee> arrList = new ArrayList<Employee>();
		arrList.add(new Employee("Bob", "DepartmentB", 31));
		arrList.add(new Employee("Alice", "DepartmentA", 30));
		for (int i = 0; i < arrList.size(); i++) {
			if (i == 0) {
				System.out.println("Q07 " + arrList.get(i).getArgs());
			} else {
				System.out.println("    " + arrList.get(i).getArgs());
			}
		}
		// Sort Employees
		Collections.sort(arrList, new NameComparator());
		Collections.sort(arrList, new DepartmentComparator());
		Collections.sort(arrList, new AgeComparator());
		for (int i = 0; i < arrList.size(); i++) {
			System.out.println("    " + arrList.get(i).getArgs());
		}
        
		Q08 q08 = new Q08();
		ArrayList<String> stringList = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"));
		System.out.println("Q08 " + q08.palindromes(stringList));
		
		Q09 q09 = new Q09();
		System.out.println("Q09 " + q09.primes(100));
		
		Q10 q10 = new Q10();
		System.out.println("Q10 " + q10.min(2, 1));
		
		Q11 q11 = new Q11();
		System.out.println("Q11 " + q11.accessVarFromOtherPackage());
		
		Q12 q12 = new Q12();
		System.out.printf("Q12 ");
		// Enhanced for loop for printing out even numbers
		for (int i : q12.numArray()) {
			if (i == q12.numArray().length) {
				System.out.printf(i + "\n");
				break;
			}
			if ((i&1) != 1) {
				System.out.printf(i + ", ");
			}
		}
		
		Q13 q13 = new Q13();
		for (int i = 0; i < q13.triangle().size(); i++) {
			if (i == 0) {
				System.out.println("Q13 " + q13.triangle().get(i));
			} else {
				System.out.println("    " + q13.triangle().get(i));
			}
		}
		
		Q14 q14 = new Q14();
		System.out.println("Q14 " + q14.switchMethod(2, 3).toString());
		
		Q15 q15 = new Q15();
		double d1 = 5.3;
		double d2 = 1.3;
		System.out.println("Q15 " + q15.addition(d1, d2));
		
		Q17 q17 = new Q17();
		System.out.println("Q17 " + q17.interest());
		
		Q18 q18 = new Q18();
		String no = "42";
		System.out.println("Q18 " + q18.uppercase(s));
		System.out.println("Q18 " + q18.toUppercase(s));
		System.out.println("Q18 " + q18.toIntPlus10(no));
		
		Q19 q19 = new Q19();
		ArrayList<Integer> intList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		System.out.println("Q19 " + intList);
		System.out.println("    " + q19.addEven(intList));
		System.out.println("    " + q19.addOdd(intList));
		System.out.println("    " + q19.removePrimes(intList));
		
		Q20 q20 = new Q20();
		q20.scan();
		
	}

}
