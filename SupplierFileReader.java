package source;

import java.util.ArrayList;
import java.util.Scanner;

public class SupplierFileReader extends FileReader {
    
    protected ArrayList<Supplier> suppliers = new ArrayList<>();
    
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
	    if (validateData(data)) {
		//if data is valid creates new Supplier object with data and add to suppliers arrayList
		suppliers.add(new Supplier(data[0], data[1]));
	    }
	    //if data is not valid or well formatted throw exception with error message telling the user which line is the problem
	    else {
		throw new IllegalArgumentException("ERROR: There is a problem with supplier on line " + (i + 1));
	    }
	    i++;
	}
	
    }
    
    //Private method to be used by class to check format and validate data, returns true or false
    private boolean validateData(String[] data) {
	if (data.length < 5) { //check to see if all data is provided
	    return false;
	}
	
	try {
	    int i = Integer.parseInt(data[0]); //see if ID is int
	}
	catch (NumberFormatException nfs) {
	    return false;
	}
	
	return true;
    }
    
    //Public method to encapsulate data by providing a specific method to access the suppliers arrayList, returns ArrayList<Supplier>
    public ArrayList<Supplier> getProducts() {
	
	return suppliers;
    }

}
