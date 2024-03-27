package source;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    
    protected String filePath;
    
    public FileReader(String filePath) {
	this.filePath = filePath;
    }
    
    // Public method to open a file for reading, returns a scanner object, used by inherited classes
    public Scanner openFile() {
	
	File file = new File(filePath);
	
	Scanner source = null;

	try {
	    // Create a file scanner.
	    source = new Scanner(file);
	}
	catch (FileNotFoundException e) {
	    System.out.println("Error opening file");
	}
	
	return source;
    }
}
