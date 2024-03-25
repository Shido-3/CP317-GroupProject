package source;

public class Supplier {
    
    private String supplierID;
    private String supplierName;
    
    public Supplier(String sID, String sName) {
	supplierID = sID;
	supplierName = sName;
    }
   
    public void getTest() {
	System.out.println(supplierID + ", " + supplierName);
    }
    
}
