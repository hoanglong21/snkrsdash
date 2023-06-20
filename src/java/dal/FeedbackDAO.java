package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Feedback;

public class FeedbackDAO extends DBContext {

    public void insert(Feedback fb) {
        String sql0 = "   select o.AccountID, od.ProductID from Orders o inner join" // already buy
                + "  OrderDetails od on o.ID = od.OrderID\n"
                + "  where AccountID = ? and ProductID = ?";
        String sql1 = "  select * from Feedbacks \n" //check exist
                + "  where AccountID = ? and ProductID = ?";

        String sql2 = " insert into Feedbacks values (?,?,?,?,?)"; // insert

        String sql3 = "update Feedbacks set date=?, " // update
                + "Stars=?, Description = ? where AccountID = ? and ProductID = ?";
        try {
            PreparedStatement st0 = connection.prepareStatement(sql0);
            st0.setInt(1, fb.getAccountID());
            st0.setInt(2, fb.getProductID());
            ResultSet rs0 = st0.executeQuery();
            if (rs0.next()) { // already buy
                PreparedStatement st1 = connection.prepareStatement(sql1);
                st1.setInt(1, fb.getAccountID());
                st1.setInt(2, fb.getProductID());
                ResultSet rs1 = st1.executeQuery();
                if (rs1.next()) { // exist
                    PreparedStatement st3 = connection.prepareStatement(sql3);
                    st3.setString(1, fb.getDate());
                    st3.setInt(2, fb.getStars());
                    st3.setString(3, fb.getDescription());
                    st3.setInt(4, fb.getAccountID());
                    st3.setInt(5, fb.getProductID());
                    st3.executeUpdate();
                } else { // new
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, fb.getAccountID());
                    st2.setInt(2, fb.getProductID());
                    st2.setString(3, fb.getDate());
                    st2.setInt(4, fb.getStars());
                    st2.setString(5, fb.getDescription());
                    st2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Feedback> getFeedbackByProID(int id) {
        List<Feedback> list = new ArrayList<>();
        String sql = "select fb.*, a.Username, a.Image from Feedbacks fb inner join Accounts a on\n"
                + "  fb.AccountID = a.ID where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Feedback fb = new Feedback();
                fb.setAccountID(rs.getInt("AccountID"));
                fb.setProductID(rs.getInt("ProductID"));
                fb.setDate(rs.getString("date"));
                fb.setStars(rs.getInt("stars"));
                fb.setDescription(rs.getString("description"));
                Account a = new Account();
                a.setImage(rs.getString("image"));
                a.setUsername(rs.getString("username"));
                fb.setAcc(a);
                list.add(fb);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Double getStarsByID(int id) {
        String sql = " select ProductID, avg(stars) as Stars from Feedbacks\n"
                + "  group by ProductID having ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getDouble("Stars");
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return 0.0;
    }
}
