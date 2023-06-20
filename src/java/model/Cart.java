/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Cart {
    private int ID;
    private int AccountID;
    private int ProductID;
    private Product pro;
    private int quantity, size;

    public Cart() {
    }

    public Cart(int ID, int AccountID, int ProductID, int quantity, int size) {
        this.ID = ID;
        this.AccountID = AccountID;
        this.ProductID = ProductID;
        this.quantity = quantity;
        this.size = size;
    }

    public Cart(int AccountID, int ProductID, int quantity, int size) {
        this.AccountID = AccountID;
        this.ProductID = ProductID;
        this.quantity = quantity;
        this.size = size;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public Product getPro() {
        return pro;
    }

    public void setPro(Product pro) {
        this.pro = pro;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
