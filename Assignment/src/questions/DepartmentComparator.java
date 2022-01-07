package questions;

import java.util.Comparator;

public class DepartmentComparator implements Comparator<Employee> {
	
	// Compare Employees by department
	public int compare(Employee a, Employee b){
        return a.department.compareTo(b.department);
    }

}
