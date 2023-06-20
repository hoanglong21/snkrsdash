package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int ID;
    private String Name;
    private double Price;
    private int Quantity;
    private int CatID;
    private String Description;
    private Category cate;
    private Account acc;
    private List<Image> imgs = new ArrayList<>();
    // add last
    private String date;
    private int size;
    
    public Product() {
    }

    public Product(int ID, String Name, double Price, int Quantity, int CatID, String Description, Category cate, Account acc, List<Image> imgs) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.CatID = CatID;
        this.Description = Description;
        this.cate = cate;
        this.acc = acc;
        this.imgs = imgs;
    }

   
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return (double) Math.round(Price * 100/85 * 100) / 100; // we need to have income/ profit 
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getCatID() {
        return CatID;
    }

    public void setCatID(int CatID) {
        this.CatID = CatID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    public List<Image> getImgs() {
        return imgs;
    }

    public void setImgs(List<Image> imgs) {
        this.imgs = imgs;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }
    
    // add last

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
}
