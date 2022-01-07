package questions;

import java.util.ArrayList;

import other.OtherClass;

public class Q11 {
	
public ArrayList<Float> accessVarFromOtherPackage() {
		
		ArrayList<Float> floatList = new ArrayList<Float>();
		
		// Instantiate the OtherClass
		OtherClass other = new OtherClass();
	
		// Access the variables from the instantiated class through the getter methods
		floatList.add(other.getFloat1());
		floatList.add(other.getFloat2());
		
		return floatList;
	}

}
