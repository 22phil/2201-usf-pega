package Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Driver {

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
		for (int i = 0; i < arrList.size(); i++)
			if (i == 0) {
				System.out.println("Q07 " + arrList.get(i).getArgs());
			} else {
				System.out.println("    " + arrList.get(i).getArgs());
			}
		Collections.sort(arrList, new NameComparator());
		Collections.sort(arrList, new DepartmentComparator());
		Collections.sort(arrList, new AgeComparator());
		for (int i = 0; i < arrList.size(); i++)
            System.out.println("    " + arrList.get(i).getArgs());
        
		Q08 q08 = new Q08();
		ArrayList<String> stringList = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"));
		System.out.println("Q08 " + q08.palindromes(stringList));
		
		Q09 q09 = new Q09();
		System.out.println("Q09 " + q09.primes(100));
		
		Q10 q10 = new Q10();
		System.out.println("Q10 " + q10.min(2, 1));

	}

}
