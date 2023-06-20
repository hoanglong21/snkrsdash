package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Role;

public class RoleDAO extends DBContext{
    public Role getRole(int id) {
        List<Role> list = new ArrayList<>();
        String sql = "select * from Roles where ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Role a = new Role();
                a.setID(rs.getInt("id"));
                a.setName(rs.getString("name"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
