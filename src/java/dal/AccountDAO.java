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

/**
 *
 * @author Admin
 */
public class AccountDAO extends DBContext {

    public List<Account> getAll() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Accounts";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setID(rs.getInt("id"));
                a.setUsername(rs.getString("Username"));
                a.setPassword(rs.getString("Password"));
                a.setRoleID(rs.getInt("RoleID"));
                a.setImage(rs.getString("Image"));
                a.setEmail(rs.getString("Email"));
                RoleDAO rdb = new RoleDAO();
                a.setRo(rdb.getRole(rs.getInt("RoleID")));
                a.setAddress(rs.getString("Address"));
                a.setAchieve(rs.getInt("achieve"));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Account check(String user, String pass) {
        String sql = "select * from Accounts where username = ? and password = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getInt("roleID"), rs.getString("Image"), rs.getString("Email"));
                a.setAddress(rs.getString("Address"));
                RoleDAO rdb = new RoleDAO();
                a.setRo(rdb.getRole(rs.getInt("RoleID")));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        // ko tim thay
        return null;
    }

    public void insert(Account a) {
        String sql = "insert into Accounts (username, password, roleID, email)\n"
                + "values (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getUsername());
            st.setString(2, a.getPassword());
            st.setInt(3, a.getRoleID());
            st.setString(4, a.getEmail());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean checkReg(String user, String email) {
        String sql = "select * from Accounts where username = ? or email = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        // ko tim thay
        return true;
    }
    
    public void updateImg(Account a, String img) {
        String sql = "UPDATE Accounts\n" +
                "SET Image = ? " +
                "WHERE username = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, img);
            st.setString(2, a.getUsername());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void updatePaD(Account a, String pass, String address) {
        String sql = " UPDATE Accounts" +
"                SET password = ?, Address = ?" +
"                WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pass);
            st.setString(2, address);
            st.setString(3, a.getUsername());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void updatePass(Account a, String pass) {
        String sql = " UPDATE Accounts" +
"                SET password = ?" +
"                WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pass);
            st.setString(2, a.getUsername());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public String getName(int id) {
        String sql = "select * from Accounts where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return (rs.getString("Username"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public Account getAccountById(int id) {
        String sql = "select * from Accounts where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getInt("roleID"), rs.getString("Image"), rs.getString("Email"));
                a.setAddress(rs.getString("Address"));
                RoleDAO rdb = new RoleDAO();
                a.setRo(rdb.getRole(rs.getInt("RoleID")));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        // ko tim thay
        return null;
    }
    
    public void deleteById(int id) {
        String sql = "delete Accounts where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public double getMoney(Integer id) {
        if(id==null) {
            return 0;
        }
        String sql = "select Money from Accounts where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return (double) Math.round(rs.getDouble("Money") * 100) / 100;  
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
}
