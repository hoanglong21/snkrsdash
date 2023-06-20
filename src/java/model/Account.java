package model;

public class Account {

    private int ID;
    private String Username, Password;
    private int RoleID;
    private String Image;
    private String Email;
    private Role ro;
    private String Address;
    private int Achieve;
    private double Money;

    public Account(int ID, String Username, String Password, int RoleID, String Image, String Email, Role ro, String Address, int Achieve, double Money) {
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        this.RoleID = RoleID;
        this.Image = Image;
        this.Email = Email;
        this.ro = ro;
        this.Address = Address;
        this.Achieve = Achieve;
        this.Money = Money;
    }

    public Account() {
    }

    public Account(int ID, String Username) {
        this.ID = ID;
        this.Username = Username;
    }
    
    public Account(String Username, String Password, String Email) {
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
    }

    public Account(int ID, String Username, String Password, int RoleID, String Image, String Email) {
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        this.RoleID = RoleID;
        this.Image = Image;
        this.Email = Email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Role getRo() {
        return ro;
    }

    public void setRo(Role ro) {
        this.ro = ro;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getAchieve() {
        return Achieve;
    }

    public void setAchieve(int Achieve) {
        this.Achieve = Achieve;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double Money) {
        this.Money = Money;
    }

    
}
