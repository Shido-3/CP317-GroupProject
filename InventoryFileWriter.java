package source;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

public class InventoryFileWriter {
    
    public static void writeInventoryFile(ArrayList<Product> products, ArrayList<Supplier> suppliers) {

	File desktop = new File(System.getProperty("user.home"), "/Desktop");
	File inventoryFile = new File(desktop, "InventoryFile.txt");
	
	int j = 0;
	int i = 0;
	String foundName = "";
	Product product;

	try {
	    
	    Files.deleteIfExists(inventoryFile.toPath());
	    
	    PrintWriter pw = new PrintWriter(inventoryFile, "UTF-8");
	    
	    try {
		for(i = 0; i < products.size(); i++) {
		    
		    product = products.get(i);
		    while(foundName == "" && j < suppliers.size()) {
			if(suppliers.get(j).getSID().equals(product.getSID())) {
			    foundName = suppliers.get(j).getSupplierName();
			}
			j++;
		    }
		
		    if(foundName == "") {
			throw new Exception();
		    }
		    
		    pw.printf("%s, %s, %d, $%.2f, %c, %s\n", product.getPID(), product.getProductName(), product.getProductQuantity(),
			    				product.getProductPrice(), product.getProductStatus(), foundName);
		    
		    foundName = "";
		    j = 0;
		
		}
	    }
	    catch (Exception e) {
		System.out.println("Error: product on line " + i + " supplier ID doe not exist in SupplierFile.txt");
		pw.close();
	    }
	    
	    pw.close();
	    
	}
	catch (Exception e) {
	    System.out.println("Error: IO is wrong or Cannot write to InventoryFile");
	}
    }
}
