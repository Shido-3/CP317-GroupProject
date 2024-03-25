package source;

public class Product {
    
    private String productID;
    private String productName;
    private float productPrice;
    private int productQuantity;
    private char productStatus;
    private String supplierID;
    
    public Product(String pID, String pName, float pPrice, int pQuantity, char pStatus, String sID) {
	productID = pID;
	productName = pName;
	productPrice = pPrice;
	productQuantity = pQuantity;
	productStatus = pStatus;
	supplierID = sID;
    }
   
    public void getTest() {
	System.out.println(productID + ", " + productName + ", " + productPrice + ", " + productQuantity 
		+ ", " + productStatus + ", " + supplierID);
    }
    
}
