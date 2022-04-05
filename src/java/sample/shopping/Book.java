/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.shopping;

/**
 *
 * @author Admin
 */
public class Book {
    private String productID;
    private String productName;
    private String description;
    private String categoryName;
    private double price;
    private int quantityCART;   
    private String image;

    public Book() {
    }

    public Book(String productID, String productName, String description, String categoryName, double price, int quantityCART, String image) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.categoryName = categoryName;
        this.price = price;
        this.quantityCART = quantityCART;
        this.image = image;
    }

    public Book(String productID, String productName, double price, int quantityCART, String image) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantityCART = quantityCART;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityCART() {
        return quantityCART;
    }

    public void setQuantityCART(int quantityCART) {
        this.quantityCART = quantityCART;
    }

   

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
