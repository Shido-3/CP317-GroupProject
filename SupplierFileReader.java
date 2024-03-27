package source;

import java.util.ArrayList;
import java.util.Scanner;

public class SupplierFileReader extends FileReader {
    
    private ArrayList<Supplier> suppliers = new ArrayList<>();
    
    public SupplierFileReader(String filePath) {
	super(filePath);
    }
    
    /*Public method to read the SupplierFile.txt, returns nothing
     * creates Supplier objects to store data for each product into suppliers arrayList
     */
    public void readFile() {
	Scanner source = openFile();
	int i = 0;
	String[] data;
	
	while(source.hasNext()) {
	    data = source.nextLine().split(", ");
	    //checks if data is formatted and valid
	    if (validateData(data, i)) {
		//if data is valid creates new Supplier object with data and add to suppliers arrayList
		suppliers.add(new Supplier(data[0], data[1]));
	    }
	    i++;
	}
	
    }
    
    //Private method to be used by class to check format and validate data, returns true or throw exceptions
    private boolean validateData(String[] data, int i) {
	if (data.length < 5) { //check to see if all data is provided
	    throw new IllegalArgumentException("ERROR: Supplier on line " + (i + 1) + ", doesn't contain all data");
	}
	
	try {
	    int n = Integer.parseInt(data[0]); //see if ID is int
	}
	catch (NumberFormatException nfs) {
	    throw new IllegalArgumentException("ERROR: Supplier on line " + (i + 1) + ", supplier ID should be integer");
	}
	
	return true;
    }
    
    //Public method to encapsulate data by providing a specific method to access the suppliers arrayList, returns ArrayList<Supplier>
    public ArrayList<Supplier> getSuppliers() {
	
	return suppliers;
    }

}
