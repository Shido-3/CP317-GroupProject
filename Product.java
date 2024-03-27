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
    
    public String getPID() {
	return productID;
    }
    
    public String getProductName() {
	return productName;
    }
    
    public float getProductPrice() {
	return productPrice;
    }
    
    public int getProductQuantity() {
	return productQuantity;
    }
    
    public char getProductStatus() {
	return productStatus;
    }
    
    public String getSID() {
	return supplierID;
    }
    
}
