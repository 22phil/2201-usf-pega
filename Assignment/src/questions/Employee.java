package questions;

import java.util.ArrayList;
import java.util.Arrays;

public class Employee {
	
	String name, department;
	int age;
	
	// Constructor
	public Employee(String name, String department, int age){
 
        this.name = name;
        this.department = department;
        this.age = age;
    }

	// Getter
	public ArrayList<String> getArgs() {
        return new ArrayList<String>(Arrays.asList(name.toString(), department.toString(), Integer.toString(age).toString()));
    }

}
