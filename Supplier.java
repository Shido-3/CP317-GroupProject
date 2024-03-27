package source;

public class Supplier {
    
    private String supplierID;
    private String supplierName;
    
    public Supplier(String sID, String sName) {
	supplierID = sID;
	supplierName = sName;
    }
    
    public String getSID() {
	return supplierID;
    }
    
    public String getSupplierName() {
	return supplierName;
    }
}
