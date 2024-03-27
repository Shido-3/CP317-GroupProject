package source;

import java.awt.Desktop;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

public class InventoryFileWriter {
    
    public static void writeInventoryFile(ArrayList<Product> products, ArrayList<Supplier> suppliers) {
	
	//creates filepath to user desktop *only works on windows
	File desktop = new File(System.getProperty("user.home"), "/Desktop");
	File inventoryFile = new File(desktop, "InventoryFile.txt");
	
	int j = 0;
	int i = 0;
	String foundName = "";
	Product product;
	ArrayList<String> inventoryLines = new ArrayList<>();

	try {
	    //check if inventoryFile already exists on desktop and deletes it
	    Files.deleteIfExists(inventoryFile.toPath());
	    	    
	    try {
		for(i = 0; i < products.size(); i++) {
		    
		    //get each individual product
		    product = products.get(i);
		    //find the supplier ID that matches the one that the product has
		    while(foundName == "" && j < suppliers.size()) {
			if(suppliers.get(j).getSID().equals(product.getSID())) {
			    foundName = suppliers.get(j).getSupplierName();
			}
			j++;
		    }
		    
		    //if supplier ID not found throw exception
		    if(foundName == "") {
			throw new Exception();
		    }
		    
		    //supplier ID found create string to be written to InventoryFile.txt
		    inventoryLines.add(String.format("%s, %s, %d, $%.2f, %c, %s", product.getPID(), product.getProductName(), 
			    product.getProductQuantity(), product.getProductPrice(), product.getProductStatus(), foundName));
		    
		    foundName = "";
		    j = 0;
		
		}
		
		//sort the new strings by product ID
		inventoryLines.sort(null);
		
		//creates a writer to write to the created InventoryFile
		PrintWriter pw = new PrintWriter(inventoryFile, "UTF-8");
		
		for(i = 0; i < inventoryLines.size(); i++) {
		    pw.println(inventoryLines.get(i));
		}
		
		//closes the writer
		pw.close();
		
		//open output file
		Desktop openFile = Desktop.getDesktop();
		
		try {
		    openFile.open(inventoryFile);
		}
		catch (Exception e) {
		    System.out.println("Error: Cannot Open InventoryFile.txt");
		}
		
	    }
	    //tells user when a product Supplier ID does not exist in the Supplier File
	    catch (Exception e) {
		System.out.println("Error: product on line " + i + " supplier ID does not exist in SupplierFile.txt");
	    }
	    
	}
	//An error with creating the files or writer
	catch (Exception e) {
	    System.out.println("Error: IO is wrong or Cannot write to InventoryFile");
	}
    }
}
