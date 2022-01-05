package Questions;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {
	
	// Compare Employees by name
	public int compare(Employee a, Employee b){
        return a.name.compareTo(b.name);
    }

}
