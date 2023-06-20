package model;

public class Feedback {
    private int AccountID;
    private int ProductID;
    private String Date;
    private int Stars;
    private String Description;
    private Account Acc;
    
    public Feedback() {
    }

    public Feedback(int AccountID, int ProductID, String Date, int Stars, String Description) {
        this.AccountID = AccountID;
        this.ProductID = ProductID;
        this.Date = Date;
        this.Stars = Stars;
        this.Description = Description;
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

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getStars() {
        return Stars;
    }

    public void setStars(int Stars) {
        this.Stars = Stars;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Account getAcc() {
        return Acc;
    }

    public void setAcc(Account Acc) {
        this.Acc = Acc;
    }
    
    
    
}
