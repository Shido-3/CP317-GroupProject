package source;

import java.util.ArrayList;
import java.util.Scanner;

public class SupplierFileReader extends FileReader {
    
    protected ArrayList<Supplier> suppliers = new ArrayList<>();
    
    public SupplierFileReader(String filePath) {
	super(filePath);
    }
    
    public void readFile() {
	Scanner source = openFile();
	int i = 0;
	String[] data;
	
//	products = source.next();
	while(source.hasNext()) {
//	    System.out.println(source.nextLine());
	    data = source.nextLine().split(", ");
	    if (validateData(data)) {
		suppliers.add(new Supplier(data[0], data[1]));
	    }
	    else {
		throw new IllegalArgumentException("ERROR: There is a problem with supplier on line " + (i + 1));
	    }
	    i++;
	}
	
    }
    
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
    
    public ArrayList<Supplier> getProducts() {
	
	return suppliers;
    }

}
