package source;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductFileReader extends FileReader {
    
    protected ArrayList<Product> products = new ArrayList<>();
    
    public ProductFileReader(String filePath) {
	super(filePath);
    }
    
    /*Public method to read the ProductFile.txt, returns nothing
     * creates Product objects to store data for each product into products arrayList
     */
    public void readFile() {
	Scanner source = openFile(); //call inherited method from FileReader class
	int i = 0;
	String[] data;
	
	while(source.hasNext()) {
	    data = source.nextLine().split(", ");
	    //checks if data is formatted and valid
	    if (validateData(data)) {
		//if data is valid creates new Product object with data and add to products arrayList
		products.add(new Product(data[0], 
					data[1], 
					Float.parseFloat(data[3].substring(1)), 
					Integer.parseInt(data[4]), 
					data[5].charAt(0), 
					data[6]));
	    }
	    //if data is not valid or well formatted throw exception with error message telling the user which line is the problem
	    else {
		throw new IllegalArgumentException("ERROR: There is a problem with product on line " + (i + 1));
	    }
	    i++;
	}
	
    }
    
    //Private method to be used by class to check format and validate data, returns true or false
    private boolean validateData(String[] data) {
	if (data.length < 7) { //check to see if all data is provided
	    return false;
	}
	
	try {
	    int i = Integer.parseInt(data[0]); //see if ID is int
	    
	    i = Integer.parseInt(data[4]); //see if quantity is int
	    
	    Double d = Double.parseDouble(data[3].substring(1)); //see if price is a float
	}
	catch (NumberFormatException nfs) {
	    return false;
	}
	
	if (data[5].length() != 1 || !Character.isLetter(data[5].charAt(0)) //check if status is letter, status has only 1 character
		|| !Character.isUpperCase(data[5].charAt(0))) {  //if the character is uppercase
	    return false;
	}
	
	return true;
    }
    
    //Public method to encapsulate data by providing a specific method to access the products arrayList, returns ArrayList<Product>
    public ArrayList<Product> getProducts() {
	
	return products;
    }

}
