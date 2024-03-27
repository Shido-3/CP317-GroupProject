package source;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Main {
    
    public static void main(String[] args) {
	
	JFileChooser fileProductChooser = new JFileChooser(); //variables to store product and supplier files
	JFileChooser fileSupplierChooser = new JFileChooser();
	fileProductChooser.setDialogTitle("Select ProductFile.txt"); //rename the file explorer window to tell user what to do
	fileSupplierChooser.setDialogTitle("Select SupplierFile.txt");

        int returnVal1 = fileProductChooser.showOpenDialog(null); //opens file explorer so user can select the input files
        int returnVal2 = fileSupplierChooser.showOpenDialog(null);

        //checks if user has selected 2 files for both prompts
        if (returnVal1 == JFileChooser.APPROVE_OPTION && returnVal2 == JFileChooser.APPROVE_OPTION) { 
            
            File productFilepath = fileProductChooser.getSelectedFile();
            File supplierFilepath = fileSupplierChooser.getSelectedFile();
            
            //checks if both input files have the correct name and file type
            if(!productFilepath.getName().matches("ProductFile.txt") || !supplierFilepath.getName().matches("SupplierFile.txt")) {
        	System.out.println("Names of input file(s) or file type are incorrect");
        	System.out.println("Stopping Program...");
            }
            else {
        	
        	//creates variable for classes that reads both the input files and get its data
                ProductFileReader productFile = new ProductFileReader(productFilepath.getAbsolutePath());
                SupplierFileReader supplierFile = new SupplierFileReader(supplierFilepath.getAbsolutePath());
                
                try {
                    	//calls readFile to get data from product file
                	productFile.readFile();
                	//get the list of product objects created by readFile method
                	ArrayList<Product> products = productFile.getProducts();
                	
                	//calls readFile to get data from supplier file
                	supplierFile.readFile();
                	//get the list of supplier objects created by readFile method
                	ArrayList<Supplier> suppliers = supplierFile.getProducts();
                	
                	//calls writeInventoryFile with list of products and suppliers to write formatted output to InventoryFile.txt
                	InventoryFileWriter.writeInventoryFile(products, suppliers);
                }	
                //catches exception and error messages from readFile method
                catch (IllegalArgumentException e) {
            		System.out.println(e.getMessage());	
                }
            }
        } 
        else {
            //if user cancels any file selection the program stops
            System.out.println("Input file(s) not selected");
            System.out.println("Stopping Program...");
        }
    }

}
