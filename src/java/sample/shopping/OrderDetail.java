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
public class OrderDetail {
    private String orderID;
    private String orderDetailID;
    private String productID;
    private int quantity;
    private double price;
    private String statusID;

    public OrderDetail(String orderID, String orderDetailID, String productID,int quantity, double price, String statusID) {
        this.orderID = orderID;
        this.orderDetailID = orderDetailID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.statusID = statusID;
    }

    public OrderDetail() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }
    
}
