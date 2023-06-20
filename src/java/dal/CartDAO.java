/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Cart;
import model.Category;
import model.Image;
import model.Product;

/**
 *
 * @author Admin
 */
public class CartDAO extends DBContext {

    public List<Cart> getAll() {
        List<Cart> list = new ArrayList<>();
        String sql = "select * from carts";
        ProductDAO pdb = new ProductDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cart a = new Cart();
                a.setID(rs.getInt("ID"));
                a.setAccountID(rs.getInt("AccountID"));
                a.setProductID(rs.getInt("ProductID"));
                a.setQuantity(rs.getInt("Quantity"));
                a.setSize(rs.getInt("Size"));
                a.setPro(pdb.getByID(rs.getInt("ID")));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insert(Cart c) {
        String sql0 = "select * from carts where AccountID = ? and ProductID = ?";
        String sql = "insert into carts (AccountID, ProductID, Quantity, Size)\n"
                + " values (?,?,?,?)";
        try {
            PreparedStatement st0 = connection.prepareStatement(sql0);
            st0.setInt(1, c.getAccountID());
            st0.setInt(2, c.getProductID());
            ResultSet rs0 = st0.executeQuery();
            if (rs0.next()) {
                return;
            }
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getAccountID());
            st.setInt(2, c.getProductID());
            st.setInt(3, c.getQuantity());
            st.setInt(4, c.getSize());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Cart> getByUser(int id) {
        List<Cart> list = new ArrayList<>();
        String sql = "select * from carts where AccountID = ?";
        ProductDAO pdb = new ProductDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cart a = new Cart();
                a.setID(rs.getInt("ID"));
                a.setAccountID(rs.getInt("AccountID"));
                a.setProductID(rs.getInt("ProductID"));
                a.setQuantity(rs.getInt("Quantity"));
                a.setSize(rs.getInt("Size"));
                a.setPro(pdb.getByID(rs.getInt("ProductID")));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void update(int id, int Quantity, int Size) {
        String sql = "update Carts "
                + " set size = ? , quantity = ? "
                + " where id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Size);
            st.setInt(2, Quantity);
            st.setInt(3, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void remove(int id) {
        String sql = "delete Carts "
                + " where id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean isEnoughMoney(int id, int discount) {
        String sql = " select c.*, p.Price, p.OwnerID from Carts c inner join Products p"
                + " on c.ProductID = p.ID where c.AccountID = ?";
        double total = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                total += rs.getDouble("price") * rs.getInt("quantity");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (discount == 1) {
            total = (double) Math.round(total * (95 / 100) * 100) / 100;
        }
        AccountDAO adb = new AccountDAO();
        return total < adb.getMoney(id);
    }

    public void buyByUser(int id, String date, int discount) { // discount 1 - ok, 0 - no # accountID is customer, owner is shop
        if (isEnoughMoney(id, discount) == false) { // not enough money
            return;
        }
        String sql1 = "  insert into Orders (AccountID, OrderDate)\n"
                + "  values (?,?)";
        String sql2 = "select top 1 id from orders order by id desc";
        String sql3 = " select c.*, p.Price, p.OwnerID from Carts c inner join Products p"
                + " on c.ProductID = p.ID where c.AccountID = ?";  // 4 last info
        String sql3_1 = "  insert into OrderDetails \n" // oderdetail
                + "  values (?,?,?,?,?,?)";
        String sql3_2 = " update Products\n" // change quantity in product
                + "set Quantity = Quantity - ?\n"
                + "where ID = ?";
        String sql3_3 = "update Accounts \n"
                + " set achieve = achieve + ?, Money = Money + ?\n"
                + "where id = ?";
        String sql4 = "delete carts where AccountID = ?";
        try {
            //add orders
            PreparedStatement st1 = connection.prepareStatement(sql1);
            st1.setInt(1, id);
            st1.setString(2, date);
            st1.executeUpdate();
            int orderId = -1;
            //get order id
            PreparedStatement st2 = connection.prepareStatement(sql2);
            ResultSet rs2 = st2.executeQuery();
            if (rs2.next()) {
                orderId = rs2.getInt("id");
            } else {
                return;
            }
            //get data prepare for order details & update money for everyone
            PreparedStatement st3 = connection.prepareStatement(sql3);
            st3.setInt(1, id);
            ResultSet rs3 = st3.executeQuery();
            while (rs3.next()) { // for each elements in cart
                // add order details
                PreparedStatement st3_1 = connection.prepareStatement(sql3_1);
                st3_1.setInt(1, orderId);
                st3_1.setInt(2, rs3.getInt("productID"));
                st3_1.setDouble(3, rs3.getDouble("price"));
                st3_1.setInt(4, rs3.getInt("quantity"));
                st3_1.setInt(5, rs3.getInt("size"));
                st3_1.setDouble(6, discount);
                st3_1.executeUpdate();

                //change quantity in product
                PreparedStatement st3_2 = connection.prepareStatement(sql3_2);
                st3_2.setInt(1, rs3.getInt("quantity"));
                st3_2.setInt(2, rs3.getInt("productID"));
                st3_2.executeUpdate();

                //change achieve, money in shop and customer, admin
                //1.customer
                PreparedStatement st3_3 = connection.prepareStatement(sql3_3);
                st3_3.setInt(1, rs3.getInt("quantity"));
                st3_3.setDouble(2, discount == 1 ? -calculator(95, rs3.getDouble("price"), rs3.getInt("quantity"))
                        : -calculator(100, rs3.getDouble("price"), rs3.getInt("quantity")));
                st3_3.setInt(3, id);
                st3_3.executeUpdate();

                //2.shop
                PreparedStatement st3_32 = connection.prepareStatement(sql3_3);
                st3_32.setInt(1, rs3.getInt("quantity"));
                st3_32.setDouble(2, calculator(90, rs3.getDouble("price"), rs3.getInt("quantity")));
                st3_32.setInt(3, rs3.getInt("ownerid"));
                st3_32.executeUpdate();

                //3.admin
                PreparedStatement st3_33 = connection.prepareStatement(sql3_3);
                st3_33.setInt(1, 0);
                st3_33.setDouble(2, discount == 1 ? calculator(5, rs3.getDouble("price"), rs3.getInt("quantity"))
                        : +calculator(10, rs3.getDouble("price"), rs3.getInt("quantity")));
                st3_33.setInt(3, 1); // 1 is admin
                st3_33.executeUpdate();

            }
            //remove in cart
            PreparedStatement st4 = connection.prepareStatement(sql4);
            st4.setInt(1, id);
            st4.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

        // update money for account
    }

    public double calculator(double per, double original, int quantity) { // 85 - 5 - 5 -5
        // first, devide money for get benefit (15%) -> original : 200 -> 235.3
        double part = (double) Math.round(quantity * original * (per / 85));
        return part;
    }

    public List<Product> getAllHistory(int id) {
        List<Product> list = new ArrayList<>();
        String sql = "  select o.*, od.Quantity, od.Size, od.Price, p.ID as ProID, "
                + " p.Name from Orders o inner join OrderDetails od\n"
                + "  on o.ID = od.OrderID inner join Products p\n"
                + "  on od.ProductID = p.ID where AccountID = ?";
        
        String sqlImg = "select Address\n"
                + "from Images where ProductID = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setID(rs.getInt("ProID"));

                PreparedStatement stImg = connection.prepareStatement(sqlImg);
                stImg.setInt(1, p.getID());
                ResultSet rsImg = stImg.executeQuery();
                List<Image> imgs = new ArrayList<>();
                while (rsImg.next()) {
                    imgs.add(new Image(rsImg.getString("Address")));
                }

                p.setName(rs.getString("Name"));
                p.setPrice(rs.getDouble("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setImgs(imgs);
                p.setSize(rs.getInt("size"));
                p.setDate(rs.getString("orderdate"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
