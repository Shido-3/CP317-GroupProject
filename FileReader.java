package source;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    
    private String filePath;
    
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
	    System.out.println("ERROR: Cannot open file");
	    System.out.println("Exiting Program...");
	}
	
	return source;
    }
}
