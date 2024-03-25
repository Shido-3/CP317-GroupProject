package source;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Main {
    
    public static void main(String[] args) {
	JFileChooser fileProductChooser = new JFileChooser();
	JFileChooser fileSupplierChooser = new JFileChooser();
	fileProductChooser.setDialogTitle("Select ProductFile.txt");
	fileSupplierChooser.setDialogTitle("Select SupplierFile.txt");

        int returnVal1 = fileProductChooser.showOpenDialog(null);
        int returnVal2 = fileSupplierChooser.showOpenDialog(null);

        if (returnVal1 == JFileChooser.APPROVE_OPTION && returnVal2 == JFileChooser.APPROVE_OPTION) {
            
            File productFilepath = fileProductChooser.getSelectedFile();
            File supplierFilepath = fileSupplierChooser.getSelectedFile();
            
            if(!productFilepath.getName().matches("ProductFile.txt") || !supplierFilepath.getName().matches("SupplierFile.txt")) {
        	System.out.println("Names of input file(s) are incorrect");
            }
            else {
        	
                ProductFileReader productFile = new ProductFileReader(productFilepath.getAbsolutePath());
                try {
                	productFile.readFile();
                	ArrayList<Product> products = productFile.getProducts();
                }
                catch (IllegalArgumentException e) {
            		System.out.println(e.getMessage());
                }
                
                SupplierFileReader supplierFile = new SupplierFileReader(supplierFilepath.getAbsolutePath());
                try {
                	supplierFile.readFile();
                	ArrayList<Supplier> suppliers = supplierFile.getProducts();
                }
                catch (IllegalArgumentException e) {
            		System.out.println(e.getMessage());	
                }
            }
        } 
        else {
            System.out.println("Input file(s) not selected");
        }
    }

}
