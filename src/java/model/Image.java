package model;

public class Image {
    private int ID;
    private String Name;
    private String Address;
    private int ProductID;

    public Image() {
    }

    public Image(int ID, String Name, String Address, int ProductID) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.ProductID = ProductID;
    }

    public Image(String Address) {
        this.Address = Address;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }
    
    
}
