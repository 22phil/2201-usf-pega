package questions;

import java.util.Comparator;

public class AgeComparator implements Comparator<Employee> {
	
	// Compare Employees by age
	public int compare(Employee a, Employee b){
        return a.age - b.age;
    }

}
