/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

/**
 *
 * @author Admin
 */
public class ProductDTO {
    private String productID;
    private String productName;
    private String description;
    private String categoryID;
    private double price;
    private int quantity;
    private String statusID;
    private String createDate;
    private String image;

    public ProductDTO() {
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productID=" + productID + ", productName=" + productName + ", description=" + description + ", categoryID=" + categoryID + ", price=" + price + ", quantity=" + quantity + ", statusID=" + statusID + ", createDate=" + createDate + ", image=" + image + '}';
    }

       
    
    public ProductDTO(String productID, String productName, String description, String categoryID, double price, int quantity, String statusID, String createDate, String image) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.categoryID = categoryID;
        this.price = price;
        this.quantity = quantity;
        this.statusID = statusID;
        this.createDate = createDate;
        this.image = image;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    
}
