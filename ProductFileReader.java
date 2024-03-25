package source;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductFileReader extends FileReader {
    
    protected ArrayList<Product> products = new ArrayList<>();
    
    public ProductFileReader(String filePath) {
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
		products.add(new Product(data[0], 
					data[1], 
					Float.parseFloat(data[3].substring(1)), 
					Integer.parseInt(data[4]), 
					data[5].charAt(0), 
					data[6]));
	    }
	    else {
		throw new IllegalArgumentException("ERROR: There is a problem with product on line " + (i + 1));
	    }
	    i++;
	}
	
    }
    
    private boolean validateData(String[] data) {
	if (data.length < 7) { //check to see if all data is provided
	    return false;
	}
	
	try {
	    int i = Integer.parseInt(data[0]); //see if ID is int
	    
	    double d = Double.parseDouble(data[4]); //see if quantity is int
	    
	    d = Double.parseDouble(data[3].substring(1)); //see if price is a float
	}
	catch (NumberFormatException nfs) {
	    return false;
	}
	
	if (data[5].length() != 1 || !Character.isLetter(data[5].charAt(0))) { //check if status is letter
	    return false;
	}
	
	return true;
    }
    
    public ArrayList<Product> getProducts() {
	
	return products;
    }

}
